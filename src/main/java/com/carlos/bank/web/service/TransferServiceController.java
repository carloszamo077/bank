package com.carlos.bank.web.service;


import com.carlos.bank.business.domain.BankTransfer;
import com.carlos.bank.business.service.TransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/api")
public class TransferServiceController {

    @Autowired
    private TransferService transferService;

    @RequestMapping(value = "/v2/transfers", method = RequestMethod.GET)
    public List<BankTransfer> getTransfers(@RequestParam(required=false) String date){
        List<BankTransfer> bankTransferList =  new ArrayList<>();
        if(null==date){
            return this.transferService.getAll();
        }else {
           return this.transferService.getTransferByDate(date);
        }
    }

    @RequestMapping(value = "/v1/transfers/{date}", method = RequestMethod.GET)
    public List<BankTransfer> getTransfer(@PathVariable String date){
        List<BankTransfer> bankTransferList =  this.transferService.getTransferByDate(date);
        return bankTransferList;
    }

    @RequestMapping(value = "/v1/transfers", method = RequestMethod.POST)
    public ResponseEntity<Object> createTransfer(@RequestBody BankTransfer bankTransfer){
        BankTransfer transfer = this.transferService.addTransfer(bankTransfer);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{date}")
                .buildAndExpand(transfer.getTransferDate()).toUri();

        return ResponseEntity.created(location).build();
    }
}
