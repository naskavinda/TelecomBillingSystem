package com.ruhuna.kavinda.database.inmemory.model;

import java.math.BigDecimal;

/**
 * Created By Supun Kavinda
 * Email naskavinda@gmail.com
 * Date  : 7/28/2018
 */

public class CorporateAccount {

    private int accountId;
    private BigDecimal creditLimit;
    private String companyName;

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

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
}
