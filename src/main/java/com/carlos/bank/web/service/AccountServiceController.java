package com.carlos.bank.web.service;

import com.carlos.bank.business.constants.AppConstants;
import com.carlos.bank.business.domain.BankAccount;
import com.carlos.bank.business.domain.BankUser;
import com.carlos.bank.business.exceptions.AccountNotFoundException;
import com.carlos.bank.business.exceptions.UserNotFoundException;
import com.carlos.bank.business.service.AccountService;
import com.carlos.bank.business.service.UserService;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@RestController
@RequestMapping(value = "/api")
public class AccountServiceController {

    @Autowired
    private AccountService accountService;

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET, value = "/v1/accounts")
    public List<BankAccount> getAllAccounts(){
            return  this.accountService.getAll();
    }


    @RequestMapping(method = RequestMethod.GET, value = "/v1/users/{userId}/accounts/{accountId}")
    public MappingJacksonValue getAllUserAccounts(@PathVariable String userId, @PathVariable String accountId){
        BankAccount bankAccount = this.accountService.getAccountByUser(userId);
        if(user == null){
            throw new UserNotFoundException("id-" + userId);
        }

        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter
                .filterOutAllExcept("userId", "firstName",
                        "lastName","emailAddress","address",
                        "country","state","phoneNumber","dateTime");

        FilterProvider filters = new SimpleFilterProvider()
                .addFilter(AppConstants.USER_FILTER, filter);

        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(resource);
        mappingJacksonValue.setFilters(filters);

        return mappingJacksonValue;
    }


    @RequestMapping(method = RequestMethod.GET, value = "/v1/accounts/{userId}")
    public List<Resource> getAccounts(@PathVariable String userId){
        Iterable<BankAccount> bankAccountList = this.accountService.getAccountByUser(userId);
            if(bankAccountList == null){
                throw new AccountNotFoundException("userId-" + userId);
            }

        List<Resource> resourceList = new ArrayList<>();
            bankAccountList.forEach(bankAccount -> {
                Resource<BankAccount> resource = new Resource<>(bankAccount);
                ControllerLinkBuilder linkTo =
                        linkTo(methodOn(AccountServiceController.class).getAllAccounts());
                resource.add(linkTo.withRel("all-accounts"));
                resourceList.add(resource);
            });

        return resourceList;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/v2/accounts")
    public List<BankAccount> getAccount(@RequestParam(required=false) String userId){
        if(null == userId){
            return  this.accountService.getAll();
        }else {
            return this.accountService.getAccountByUser(userId);
        }
    }
}
