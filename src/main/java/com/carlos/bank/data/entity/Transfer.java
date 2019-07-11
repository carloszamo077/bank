package com.carlos.bank.data.entity;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "TRANSFER")
public class Transfer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "TRANSFER_ID")
    private long transferId;

    @Column(name = "ACCOUNT_ID")
    private long accountId;

    @Column(name = "TRANSFER_AMOUNT")
    private long transferAmount;

    @Column(name = "ACCOUNT_DESTINATION")
    private long accountDestination;

    @Column(name = "TRANSFER_DATE")
    private Date transferDate;

    public long getTransferId() {
        return transferId;
    }

    public void setTransferId(long transferId) {
        this.transferId = transferId;
    }

    public long getAccountId() {
        return accountId;
    }

    public void setAccountId(long accountId) {
        this.accountId = accountId;
    }

    public long getTransferAmount() {
        return transferAmount;
    }

    public void setTransferAmount(long transferAmount) {
        this.transferAmount = transferAmount;
    }

    public long getAccountDestination() {
        return accountDestination;
    }

    public void setAccountDestination(long accountDestination) {
        this.accountDestination = accountDestination;
    }

    public Date getTransferDate() {
        return transferDate;
    }

    public void setTransferDate(Date transferDate) {
        this.transferDate = transferDate;
    }
}
