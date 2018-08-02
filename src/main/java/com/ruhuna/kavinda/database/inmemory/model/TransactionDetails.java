package com.ruhuna.kavinda.database.inmemory.model;


import com.ruhuna.kavinda.core.account.TransactionStatus;

import java.math.BigDecimal;

/**
 * Created By Supun Kavinda
 * Email naskavinda@gmail.com
 * Date  : 7/28/2018
 */
public class TransactionDetails {
    private int accountId;
    private int simNo;
    private BigDecimal price;
    private TransactionStatus transactionStatus;
    private Long dateTime;

    private TransactionDetails(Builder builder) {
        this.accountId = builder.accountId;
        this.simNo = builder.simNo;
        this.price = builder.price;
        this.transactionStatus = builder.transactionStatus;
        this.dateTime = builder.dateTime;
    }

    public static Builder newTransactionDetails() {
        return new Builder();
    }

    public int getAccountId() {
        return accountId;
    }

    public int getSimNo() {
        return simNo;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public TransactionStatus getTransactionStatus() {
        return transactionStatus;
    }

    public Long getDateTime() {
        return dateTime;
    }

    public static final class Builder {
        private int accountId;
        private int simNo;
        private BigDecimal price;
        private TransactionStatus transactionStatus;
        private Long dateTime;

        private Builder() {
        }

        public TransactionDetails build() {
            return new TransactionDetails(this);
        }

        public Builder accountId(int accountId) {
            this.accountId = accountId;
            return this;
        }

        public Builder simNo(int simNo) {
            this.simNo = simNo;
            return this;
        }

        public Builder price(BigDecimal price) {
            this.price = price;
            return this;
        }

        public Builder transactionStatus(TransactionStatus transactionStatus) {
            this.transactionStatus = transactionStatus;
            return this;
        }

        public Builder dateTime(Long dateTime) {
            this.dateTime = dateTime;
            return this;
        }
    }
}
