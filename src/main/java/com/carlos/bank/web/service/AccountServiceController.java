package com.carlos.bank.web.service;

import com.carlos.bank.business.domain.BankAccount;
import com.carlos.bank.business.exception.AccountNotFoundException;
import com.carlos.bank.business.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class AccountServiceController {

    @Autowired
    private AccountService accountService;

    @RequestMapping(method = RequestMethod.GET, value = "/accounts")
    public List<BankAccount> getAccount(@RequestParam(required=false) String userId){
        if(null == userId){
            return  this.accountService.getAll();
        }else {
            return this.accountService.getAccountByUser(userId);
        }
    }

    @GetMapping("/accounts/{userId}")
    public List<BankAccount> getAccounts(@PathVariable String userId){
        List<BankAccount> bankAccountList = this.accountService.getAccountByUser(userId);
            if(bankAccountList.isEmpty()){
                throw new AccountNotFoundException("userId-" + userId);
            }
            return bankAccountList;

    }
}
