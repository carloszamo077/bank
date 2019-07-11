package com.carlos.bank.business.domain;

import java.util.Date;

public class BankTransfer {

    private long transferId;

    private long accountId;

    private long transferAmount;

    private long accountDestination;

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
