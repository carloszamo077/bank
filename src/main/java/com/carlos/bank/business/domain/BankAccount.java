package com.carlos.bank.business.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;

@ApiModel(description = "All the details about the Account")
public class BankAccount {

    private long accountId;

    @ApiModelProperty(notes = "User ID should have 9 characters")
    @Size(min=9, max = 9, message = "User ID should have 9 characters")
    private String userId;

    @ApiModelProperty(notes = "Account name should have 2 characters")
    @Size(min=2, message = "Account name should have 2 characters")
    private String accountName;

    private long accountBalance;

    @ApiModelProperty(notes = "Date can not be in the future")
    @Past
    private Date accountDate;

    public long getAccountId() {
        return accountId;
    }

    public void setAccountId(long accountId) {
        this.accountId = accountId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public long getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(long accountBalance) {
        this.accountBalance = accountBalance;
    }

    public Date getAccountDate() {
        return accountDate;
    }

    public void setAccountDate(Date accountDate) {
        this.accountDate = accountDate;
    }
}
