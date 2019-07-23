package com.carlos.bank.business.domain;


import com.fasterxml.jackson.annotation.JsonFilter;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Past;
import java.util.Date;

@ApiModel(description = "All the details about the Card")
@JsonFilter(value = "BankCardFilter")
public class BankCard {

    private String cardId;

    private String name;

    @ApiModelProperty(notes = "Date can not be in the future")
    @Past
    private Date dateTime;

    private String accountId;

    public BankCard(){}

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }
}
