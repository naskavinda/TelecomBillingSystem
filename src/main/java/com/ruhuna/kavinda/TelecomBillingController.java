package com.ruhuna.kavinda;

import com.ruhuna.kavinda.core.service.AccountService;
import com.ruhuna.kavinda.exception.Assert;
import com.ruhuna.kavinda.logger.Logger;

/**
 * Created By Supun Kavinda
 * Email naskavinda@gmail.com
 * Date  : 7/23/2018
 */
public class TelecomBillingController implements BillingSystem {
    private AccountService accountService = new AccountService();

    @Override
    public int authorize(int simNo) {
        Assert.isSimNo(simNo);
        try {
            return accountService.getTransactionId(simNo);
        } catch (Exception e) {
            Logger.logTraceMessage(this, e);
            return 0;
        }
    }

    @Override
    public void confirm(int transactionNo) {
        try {
            accountService.confirm(transactionNo);
            Logger.logInfoMessage(this, transactionNo + " transaction no is successfully confirmed.");
        } catch (Exception e) {
            Logger.logTraceMessage(this, e);
        }

    }

    @Override
    public void cancel(int transactionNo) {
        try {
            accountService.cancel(transactionNo);
            Logger.logInfoMessage(this, transactionNo + " transaction no is successfully canceled.");
        } catch (Exception e) {
            Logger.logTraceMessage(this, e);
        }
    }
}
