package com.carlos.bank.business.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@ApiModel(description = "All the details about the Account")
public class BankAccount {

    private String accountId;

    @ApiModelProperty(notes = "User ID should have 9 characters")
    @Size(min=9, max = 9, message = "User ID should have 9 characters")
    private String name;

    //@ApiModelProperty(notes = "Account name should have 2 characters")
    @Size(min=2, message = "Account name should have 2 characters")
    private long balance;

    @ApiModelProperty(notes = "Date can not be in the future")
    @Past
    private Date dateTime;

    private List<BankCard> cardList;

    private List<BankTransfer> transferList;

    public BankAccount(){}

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getBalance() {
        return balance;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    public List<BankCard> getCardList() {
        return cardList;
    }

    public void setCardList(List<BankCard> cardList) {
        this.cardList = cardList;
    }

    public List<BankTransfer> getTransferList() {
        return transferList;
    }

    public void setTransferList(List<BankTransfer> transferList) {
        this.transferList = transferList;
    }
}
