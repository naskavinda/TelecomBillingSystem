package com.ruhuna.kavinda.core.account;

/**
 * Created By Supun Kavinda
 * Email naskavinda@gmail.com
 * Date  : 7/25/2018
 */
public enum TransactionStatus {
    PENDING(1), CONFIRM(2), CANCEL(3);

    private final int status;

    TransactionStatus(int status) {
        this.status = status;
    }

    public int getStatus() {
        return status;
    }

}
