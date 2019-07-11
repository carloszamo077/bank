package com.carlos.bank.web.service;

import com.carlos.bank.business.domain.BankAccount;
import com.carlos.bank.business.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/accounts")
public class AccountServiceController {

    @Autowired
    private AccountService accountService;

    @RequestMapping(method = RequestMethod.GET, value = "/all")
    public List<BankAccount> getAccount(@RequestParam(required=false) String userId){
        if(null == userId){
            return  this.accountService.getAll();
        }else {
            return this.accountService.getAccountByUser(userId);
        }
    }
}
