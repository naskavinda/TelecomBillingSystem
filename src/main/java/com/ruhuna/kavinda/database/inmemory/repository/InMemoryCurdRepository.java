package com.ruhuna.kavinda.database.inmemory.repository;

import com.ruhuna.kavinda.database.CurdRepository;
import com.ruhuna.kavinda.database.inmemory.model.CorporateAccount;
import com.ruhuna.kavinda.database.inmemory.model.PersonalAccount;
import com.ruhuna.kavinda.database.inmemory.model.Sim;

import java.util.List;

/**
 * Created By Supun Kavinda
 * Email naskavinda@gmail.com
 * Date  : 7/28/2018
 */
public interface InMemoryCurdRepository extends CurdRepository {

    void saveBulkCorporateAccount(List<CorporateAccount> corporateAccounts);

    void saveBulkPersonalAccount(List<PersonalAccount> personalAccounts);

    void saveBulkSim(List<Sim> sims);
}
