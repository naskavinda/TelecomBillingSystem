package com.ruhuna.kavinda.database.inmemory.model;

import java.math.BigDecimal;

/**
 * Created By Supun Kavinda
 * Email naskavinda@gmail.com
 * Date  : 7/28//2018
 */
public class PersonalAccount {

    private int accountId;
    private BigDecimal creditLimit;
    private String personName;
    private String nic;

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public BigDecimal getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(BigDecimal creditLimit) {
        this.creditLimit = creditLimit;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }
}
