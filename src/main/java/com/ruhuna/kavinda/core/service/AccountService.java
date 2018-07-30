package com.ruhuna.kavinda.core.service;

import com.ruhuna.kavinda.core.account.Account;
import com.ruhuna.kavinda.core.account.CorporateAccount;
import com.ruhuna.kavinda.core.account.PersonalAccount;
import com.ruhuna.kavinda.core.account.TransactionStatus;
import com.ruhuna.kavinda.core.scheduler.SchedulerService;
import com.ruhuna.kavinda.database.CurdRepository;
import com.ruhuna.kavinda.database.inmemory.repository.implementation.InMemoryCurdRepositoryImpl;
import com.ruhuna.kavinda.logger.Logger;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Map;

import static com.ruhuna.kavinda.core.scheduler.JobScheduler.createJob;
import static com.ruhuna.kavinda.core.scheduler.JobScheduler.createTrigger;

/**
 * Created By Supun Kavinda
 * Email naskavinda@gmail.com
 * Date  : 7/27/2018
 */
public class AccountService {
    private static final SchedulerService schedulerService = SchedulerService.getInstance();
    private static final CurdRepository curdRepository = new InMemoryCurdRepositoryImpl();

    public int getTransactionId(int simNo) {
        String accountBySimNo = curdRepository.getAccountTypeBySimNo(simNo);
        switch (accountBySimNo) {
            case "CORPORATE":
                CorporateAccount corporateAccount = curdRepository.getCorporateAccountBySimNo(simNo);
                return getTransactionNoByAccount(simNo, corporateAccount, "CORPORATE");
            case "PERSONAL":
                PersonalAccount personalAccount = curdRepository.getPersonalAccountBySimNo(simNo);
                return getTransactionNoByAccount(simNo, personalAccount, "PERSONAL");
            default:
                throw new AssertionError();
        }
    }

    private int getTransactionNoByAccount(int simNo, Account account, String accountType) {
        BigDecimal allAmount = getTotalAmount(account.getAmount());
        if (account.getCreditLimit().compareTo(allAmount.add(account.getSmsService().getSmsPrice())) > 0) {
            return getTransactionNoWhenSimNoIsExist(simNo, account.getAccountId(), accountType);
        }
        Logger.logInfoMessage(this, simNo + " number Credit limit is exceeded.");
        return 0;
    }

    private BigDecimal getTotalAmount(Map<TransactionStatus, BigDecimal> amount) {
        BigDecimal totalAmount = BigDecimal.ZERO;
        for (Map.Entry<TransactionStatus, BigDecimal> entry : amount.entrySet()) {
            if (entry.getKey().equals(TransactionStatus.PENDING) || entry.getKey().equals(TransactionStatus.CONFIRM)) {
                totalAmount = totalAmount.add(entry.getValue());
            }
        }
        return totalAmount;
    }

    private int getTransactionNoWhenSimNoIsExist(int simNo, int accountId, String accountType) {
        int transactionNo = curdRepository.getTransactionId();
        long currentTimeMillis = System.currentTimeMillis();
        curdRepository.saveTransaction(simNo, accountId, transactionNo, currentTimeMillis);
        schedulerService.addJob(createJob(String.valueOf(transactionNo), accountType), createTrigger(String.valueOf(simNo), new Date(currentTimeMillis + 60000)));
        Logger.logInfoMessage(this, transactionNo + " transaction no is successfully generated at " + new Timestamp(currentTimeMillis));
        return transactionNo;
    }

    public void confirm(int transactionNo) {
        curdRepository.changeTransactionType(transactionNo, TransactionStatus.CONFIRM);
        String accountBySimNo = curdRepository.getAccountTypeByTransactionId(transactionNo);
        schedulerService.removeJobFromScheduler(createJob(String.valueOf(transactionNo), accountBySimNo));
    }

    public void cancel(int transactionNo) {
        curdRepository.changeTransactionType(transactionNo, TransactionStatus.CANCEL);
        String accountBySimNo = curdRepository.getAccountTypeByTransactionId(transactionNo);
        schedulerService.removeJobFromScheduler(createJob(String.valueOf(transactionNo), accountBySimNo));
    }
}
