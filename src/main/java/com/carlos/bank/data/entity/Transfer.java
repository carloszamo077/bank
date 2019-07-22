package com.carlos.bank.data.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "TRANSFER")
public class Transfer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private long id;

    @Column(name = "AMOUNT")
    private long amount;

    @Column(name = "DATETIME")
    private Date dateTime;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private Account accountId;

    @Column(name = "ACCOUNT_DESTINATION")
    private long accountDestination;

    public Transfer(){}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

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

    public Account getAccountId() {
        return accountId;
    }

    public void setAccountId(Account accountId) {
        this.accountId = accountId;
    }

    public long getAccountDestination() {
        return accountDestination;
    }

    public void setAccountDestination(long accountDestination) {
        this.accountDestination = accountDestination;
    }
}
