package com.carlos.bank.business.service;

import com.carlos.bank.business.domain.BankTransfer;
import com.carlos.bank.common.aspect.Loggable;
import com.carlos.bank.data.entity.Transfer;
import com.carlos.bank.data.repository.AccountRepository;
import com.carlos.bank.data.repository.CardRepository;
import com.carlos.bank.data.repository.TransferRepository;
import com.carlos.bank.data.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class TransferService {

    private AccountRepository accountRepository;
    private CardRepository cardRepository;
    private UserRepository userRepository;
    private TransferRepository transferRepository;

    private final DateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");

    @Autowired
    public TransferService(AccountRepository accountRepository, CardRepository cardRepository, UserRepository userRepository, TransferRepository transferRepository) {
        this.accountRepository = accountRepository;
        this.cardRepository = cardRepository;
        this.userRepository = userRepository;
        this.transferRepository = transferRepository;
    }

    public BankTransfer addTransfer(BankTransfer bankTransfer){
        Transfer transfer = new Transfer();
        transfer.setAccountId(bankTransfer.getAccountId());
        transfer.setAccountDestination(bankTransfer.getAccountDestination());
        transfer.setTransferAmount(bankTransfer.getTransferAmount());
        transfer.setTransferDate(new java.sql.Date(bankTransfer.getTransferDate().getTime()));

       Transfer transferSaved =  this.transferRepository.save(transfer);

       return bankTransfer;
    }

    @Loggable
    public List<BankTransfer> getAll(){
        List<BankTransfer> bankTransfers = new ArrayList<>();
        Iterable<Transfer> transfers = this.transferRepository.findAll();

        transfers.forEach(transfer -> {
            BankTransfer bankTransfer = new BankTransfer();
            bankTransfer.setTransferId(transfer.getTransferId());
            bankTransfer.setAccountId(transfer.getAccountId());
            bankTransfer.setAccountDestination(transfer.getAccountDestination());
            bankTransfer.setTransferAmount(transfer.getTransferAmount());
            bankTransfer.setTransferDate(transfer.getTransferDate());
            bankTransfers.add(bankTransfer);
        });
        return bankTransfers;
    }

    @Loggable
    public List<BankTransfer> getTransferByDate(String dateString){
        Date date = this.createDateFromDateString(dateString);
        List<BankTransfer> bankTransfers = new ArrayList<>();
        Iterable<Transfer> transfers = this.transferRepository.findByTransferDate(new java.sql.Date(date.getTime()));

        transfers.forEach(transfer -> {
            BankTransfer bankTransfer = new BankTransfer();
            bankTransfer.setTransferId(transfer.getTransferId());
            bankTransfer.setAccountId(transfer.getAccountId());
            bankTransfer.setAccountDestination(transfer.getAccountDestination());
            bankTransfer.setTransferAmount(transfer.getTransferAmount());
            bankTransfer.setTransferDate(transfer.getTransferDate());
            bankTransfers.add(bankTransfer);
        });
        return bankTransfers;
    }



    private Date createDateFromDateString(String dateString){
        Date date = null;
        if(null!=dateString) {
            try {
                date = DATE_FORMAT.parse(dateString);
            }catch(ParseException pe){
                date = new Date();
            }
        }else{
            date = new Date();
        }
        return date;
    }

}
