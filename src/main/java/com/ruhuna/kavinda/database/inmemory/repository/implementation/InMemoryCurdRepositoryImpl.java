package com.ruhuna.kavinda.database.inmemory.repository.implementation;

import com.ruhuna.kavinda.core.RandomGenerator;
import com.ruhuna.kavinda.core.account.SmsService;
import com.ruhuna.kavinda.core.account.TransactionStatus;
import com.ruhuna.kavinda.database.inmemory.model.*;
import com.ruhuna.kavinda.database.inmemory.repository.InMemoryCurdRepository;
import com.ruhuna.kavinda.exception.SimNotRegisteredException;
import com.ruhuna.kavinda.exception.TransactionNoIncorrectException;

import java.math.BigDecimal;
import java.util.*;

/**
 * Created By Supun Kavinda
 * Email naskavinda@gmail.com
 * Date  : 7/28/2018
 */
public class InMemoryCurdRepositoryImpl extends RandomGenerator implements InMemoryCurdRepository {

    /**
     * this map key is CorporateAccount accountId.
     */
    private static Map<Integer, CorporateAccount> corporateAccountMap = new LinkedHashMap<>();
    /**
     * this map key is CorporateAccount accountId.
     */
    private static Map<Integer, PersonalAccount> personalAccountMap = new LinkedHashMap<>();
    /**
     * this map key is simNo.
     */
    private static Map<Integer, Sim> simMap = new LinkedHashMap<>();
    /**
     * this map key is transactionId.
     */
    private static Map<Integer, TransactionDetails> transactionDetailsMap = new LinkedHashMap<>();

    private static final BigDecimal smsPrice = BigDecimal.valueOf(0.34);

    @Override
    public String getAccountTypeBySimNo(int simNo) {
        if (simMap.containsKey(simNo)) {
            return simMap.get(simNo).getAccountType().toString().toUpperCase();
        } else {
            throw new SimNotRegisteredException("This SIM number is not registered. SIM NO : " + simNo);
        }
    }

    @Override
    public com.ruhuna.kavinda.core.account.CorporateAccount getCorporateAccountBySimNo(int simNo) {
        List<com.ruhuna.kavinda.core.Sim> simList = new ArrayList<>();
        int accountId = simMap.get(simNo).getAccountId();
        for (Map.Entry<Integer, Sim> entry : simMap.entrySet()) {
            if (entry.getValue().getAccountId() == accountId) {
                com.ruhuna.kavinda.core.Sim sim = new com.ruhuna.kavinda.core.Sim(entry.getValue().getSimNo());
                simList.add(sim);
            }
        }
        BigDecimal creditLimit = corporateAccountMap.get(accountId).getCreditLimit();
        SmsService smsService = new SmsService();
        smsService.setSmsPrice(smsPrice);

        return new com.ruhuna.kavinda.core.account.CorporateAccount(accountId, simList, creditLimit, smsService);
    }

    @Override
    public int getTransactionId() {
        return super.generateRandomNumber();
    }

    @Override
    public void saveTransaction(int simNo, int accountId, int transactionId, long localDateTime) {
        TransactionDetails transactionDetails = TransactionDetails.newTransactionDetails()
                .accountId(accountId)
                .simNo(simNo)
                .transactionStatus(TransactionStatus.PENDING)
                .price(smsPrice)
                .dateTime(localDateTime)
                .build();
        transactionDetailsMap.put(transactionId, transactionDetails);
    }

    @Override
    protected LinkedHashSet<Integer> getTransactionalNoList() {
        LinkedHashSet<Integer> transactionIdList = new LinkedHashSet<>();
        for (Map.Entry<Integer, TransactionDetails> entry : transactionDetailsMap.entrySet()) {
            transactionIdList.add(entry.getKey());
        }
        return transactionIdList;
    }

    @Override
    public com.ruhuna.kavinda.core.account.PersonalAccount getPersonalAccountBySimNo(int simNo) {
        com.ruhuna.kavinda.core.Sim sim = null;
        int accountId = simMap.get(simNo).getAccountId();
        for (Map.Entry<Integer, Sim> entry : simMap.entrySet()) {
            if (entry.getValue().getAccountId() == accountId) {
                sim = new com.ruhuna.kavinda.core.Sim(entry.getValue().getSimNo());
                break;
            }
        }
        BigDecimal creditLimit = personalAccountMap.get(accountId).getCreditLimit();
        SmsService smsService = new SmsService();
        smsService.setSmsPrice(smsPrice);
        return new com.ruhuna.kavinda.core.account.PersonalAccount(accountId, sim, creditLimit, smsService);
    }

    @Override
    public void changeTransactionType(int transactionId, com.ruhuna.kavinda.core.account.TransactionStatus transactionStatus) {
        if (!transactionDetailsMap.containsKey(transactionId)) {
            throw new TransactionNoIncorrectException(transactionId + " this transaction no is incorrect.");
        }
        TransactionDetails transactionDetails = transactionDetailsMap.get(transactionId);
        TransactionDetails transactionDetails1 = TransactionDetails.newTransactionDetails()
                .accountId(transactionDetails.getAccountId())
                .simNo(transactionDetails.getSimNo())
                .transactionStatus(transactionStatus)
                .price(transactionDetails.getPrice())
                .dateTime(transactionDetails.getDateTime())
                .build();
        transactionDetailsMap.put(transactionId, transactionDetails1);
    }

    @Override
    public String getAccountTypeByTransactionId(int transactionId) {
        if (!transactionDetailsMap.containsKey(transactionId)) {
            throw new TransactionNoIncorrectException(transactionId + " this transaction no is incorrect.");
        }
        TransactionDetails transactionDetails = transactionDetailsMap.get(transactionId);
        return getAccountTypeBySimNo(transactionDetails.getSimNo());

    }

    @Override
    public void saveBulkCorporateAccount(List<CorporateAccount> corporateAccounts) {
        for (CorporateAccount corporateAccount : corporateAccounts) {
            int accountId = corporateAccountMap.size() + 1;
            corporateAccount.setAccountId(accountId);
            corporateAccountMap.put(accountId, corporateAccount);
        }
    }

    @Override
    public void saveBulkPersonalAccount(List<PersonalAccount> personalAccounts) {
        for (PersonalAccount personalAccount : personalAccounts) {
            int accountId = personalAccountMap.size() + 1;
            personalAccount.setAccountId(accountId);
            personalAccountMap.put(accountId, personalAccount);
        }
    }

    @Override
    public void saveBulkSim(List<Sim> sims) {
        for (Sim sim : sims) {
            simMap.put(sim.getSimNo(), sim);
        }
    }
}
