package com.ruhuna.kavinda;

/**
 * Created By Supun Kavinda
 * Email naskavinda@gmail.com
 * Date  : 7/23/2018
 */
public interface BillingSystem {
    public int authorize(int simNo);

    public void confirm(int transactionNo);

    public void cancel(int transactionNo);
}
