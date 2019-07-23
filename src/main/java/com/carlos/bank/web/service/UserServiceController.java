package com.carlos.bank.web.service;

import com.carlos.bank.business.constants.AppConstants;
import com.carlos.bank.business.domain.BankAccount;
import com.carlos.bank.business.domain.BankUser;
import com.carlos.bank.business.exceptions.UserNotFoundException;
import com.carlos.bank.business.service.UserService;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.hateoas.Resource;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class UserServiceController {

    @Autowired
    private UserService userService;


    @RequestMapping(method = RequestMethod.GET, value = "/v1/users")
    public MappingJacksonValue getAllUsers(){

        List<BankUser> bankUserList = this.userService.getAll();

        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter
                .filterOutAllExcept("userId", "firstName",
                        "lastName","emailAddress","address",
                        "country","state","phoneNumber","dateTime");

        FilterProvider filters = new SimpleFilterProvider()
                .addFilter(AppConstants.USER_FILTER, filter);

        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(bankUserList);
        mappingJacksonValue.setFilters(filters);

        return mappingJacksonValue;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/v1/users/{id}")
    public MappingJacksonValue getUser(@PathVariable String id){

        BankUser user = this.userService.getByUserId(id);

        if(user == null){
            throw new UserNotFoundException("id-" + id);
        }

        Resource<BankUser> resource = new Resource<>(user);
        ControllerLinkBuilder linkTo =
                linkTo(methodOn(UserServiceController.class).getAllUsers());

        resource.add(linkTo.withRel("all-users"));


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

    @RequestMapping(method = RequestMethod.GET, value = "/v1/users/{userId}/accounts")
    public List<BankAccount> getAllUserAccounts(@PathVariable String userId){
        BankUser user = this.userService.getByUserIdWithAccounts(userId);
        if(user == null){
            throw new UserNotFoundException("id-" + userId);
        }

        return user.getAccountList();
    }
}
