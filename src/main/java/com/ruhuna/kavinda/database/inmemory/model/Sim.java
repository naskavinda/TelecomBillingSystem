package com.ruhuna.kavinda.database.inmemory.model;

/**
 * Created By Supun Kavinda
 * Email naskavinda@gmail.com
 * Date  : 7/28/2018
 */
public class Sim {
    private int simNo;
    private AccountType accountType;
    private int accountId;

    public int getSimNo() {
        return simNo;
    }

    public void setSimNo(int simNo) {
        this.simNo = simNo;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }
}
