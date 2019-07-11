package com.carlos.bank.web.service;


import com.carlos.bank.business.domain.BankTransfer;
import com.carlos.bank.business.service.TransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/api/transfers")
public class TransferServiceController {

    @Autowired
    private TransferService transferService;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<BankTransfer> getTransfer(@RequestParam(required=false) String date){
        List<BankTransfer> bankTransferList =  new ArrayList<>();
        if(null==date){
            return this.transferService.getAll();
        }else {
           return this.transferService.getTransferByDate(date);
        }
    }

    @RequestMapping(value = "/add/{accountId}/{accountDestination}/{transactionAmount}", method = RequestMethod.POST)
    public Map<String, String> postTransfer(@PathVariable(value = "accountId") long accountId,
                                       @PathVariable(value = "accountDestination") long accountDestination,
                                       @PathVariable(value = "transactionAmount") long transactionAmount){

        return this.transferService.addTransaction(accountId, accountDestination, transactionAmount);
    }
}
