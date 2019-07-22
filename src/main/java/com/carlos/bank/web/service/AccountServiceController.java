package com.carlos.bank.web.service;

import com.carlos.bank.business.domain.BankAccount;
import com.carlos.bank.business.domain.BankUser;
import com.carlos.bank.business.exceptions.AccountNotFoundException;
import com.carlos.bank.business.exceptions.UserNotFoundException;
import com.carlos.bank.business.service.AccountService;
import com.carlos.bank.business.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
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


    @RequestMapping(method = RequestMethod.GET, value = "/v1/users/{userId}/accounts")
    public List<BankAccount> getAllUserAccounts(@PathVariable String userId){
        BankUser user = this.userService.getByUserIdWithAccounts(userId);
        if(user == null){
            throw new UserNotFoundException("id-" + userId);
        }

        return user.getAccountList();
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
