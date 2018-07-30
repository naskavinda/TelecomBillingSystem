package com.ruhuna.kavinda.core.account;

import com.ruhuna.kavinda.exception.Assert;

import java.math.BigDecimal;
import java.util.EnumMap;
import java.util.Map;

/**
 * Created By Supun Kavinda
 * Email naskavinda@gmail.com
 * Date  : 7/25/2018
 */

public abstract class Account {
    private int accountId;
    private BigDecimal creditLimit;
    private Map<TransactionStatus, BigDecimal> amount;
    private SmsService smsService;

    public Account(BigDecimal creditLimit, int accountId, SmsService smsService) {
        Assert.isGreaterThenZero(accountId);
        Assert.isGreaterThenZero(creditLimit);
        this.creditLimit = creditLimit;
        this.accountId = accountId;
        this.smsService = smsService;
        this.amount = new EnumMap<>(TransactionStatus.class);
    }

    public int getAccountId() {
        return accountId;
    }

    public BigDecimal getCreditLimit() {
        return creditLimit;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public void setCreditLimit(BigDecimal creditLimit) {
        this.creditLimit = creditLimit;
    }

    public Map<TransactionStatus, BigDecimal> getAmount() {
        return amount;
    }

    public void setAmount(Map<TransactionStatus, BigDecimal> amount) {
        this.amount = amount;
    }

    public SmsService getSmsService() {
        return smsService;
    }

    public void setSmsService(SmsService smsService) {
        this.smsService = smsService;
    }
}
