package com.ruhuna.kavinda.core.account;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * Created By Supun Kavinda
 * Email naskavinda@gmail.com
 * Date  : 7/25/2018
 */
public class SmsService {
    private BigDecimal smsPrice;
    private LocalDateTime dateTime;
    private int transactionId;

    public BigDecimal getSmsPrice() {
        return smsPrice;
    }

    public void setSmsPrice(BigDecimal smsPrice) {
        this.smsPrice = smsPrice;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }
}
