package com.ruhuna.kavinda.database;

import com.ruhuna.kavinda.core.account.CorporateAccount;
import com.ruhuna.kavinda.core.account.PersonalAccount;
import com.ruhuna.kavinda.core.account.TransactionStatus;

/**
 * Created By Supun Kavinda
 * Email naskavinda@gmail.com
 * Date  : 7/28/2018
 */
public interface CurdRepository {
    String getAccountTypeBySimNo(int simNo);

    CorporateAccount getCorporateAccountBySimNo(int simNo);

    int getTransactionId();

    void saveTransaction(int simNo, int accountId, int transactionId, long localDateTime);

    PersonalAccount getPersonalAccountBySimNo(int simNo);

    void changeTransactionType(int transactionId, TransactionStatus transactionStatus);

    String getAccountTypeByTransactionId(int transactionId);
}
