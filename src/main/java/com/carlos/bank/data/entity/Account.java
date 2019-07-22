package com.carlos.bank.data.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "ACCOUNT")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private long id;

    @Column(name = "ACCOUNT_ID")
    private String accountId;

    @Column(name = "NAME")
    private String name;

    @Column(name = "BALANCE")
    private long balance;

    @Column(name = "DATETIME")
    private Date dateTime;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private User user;

    @OneToMany(mappedBy = "account")
    private List<Card> cardList;

    @OneToMany(mappedBy = "accountId")
    private List<Transfer> transferList;


    public Account(){
        
    }

    public List<Card> getCardList() {
        return cardList;
    }

    public void setCardList(List<Card> cardList) {
        this.cardList = cardList;
    }

    public List<Transfer> getTransferList() {
        return transferList;
    }

    public void setTransferList(List<Transfer> transferList) {
        this.transferList = transferList;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

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
}
