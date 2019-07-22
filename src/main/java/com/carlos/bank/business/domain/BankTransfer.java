package com.carlos.bank.business.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Past;
import java.util.Date;

@ApiModel(description = "All the details about the Transfer")
public class BankTransfer {

    private long amount;

    @ApiModelProperty(notes = "Date can not be in the future")
    @Past
    private Date dateTime;

    private BankAccount accountId;

    private String accountDestination;

    public BankTransfer(){}

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    public BankAccount getAccountId() {
        return accountId;
    }

    public void setAccountId(BankAccount accountId) {
        this.accountId = accountId;
    }

    public String getAccountDestination() {
        return accountDestination;
    }

    public void setAccountDestination(String accountDestination) {
        this.accountDestination = accountDestination;
    }
}
