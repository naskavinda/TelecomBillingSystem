package com.ruhuna.kavinda.database.inmemory.feeddata;

import com.ruhuna.kavinda.database.inmemory.model.AccountType;
import com.ruhuna.kavinda.database.inmemory.model.CorporateAccount;
import com.ruhuna.kavinda.database.inmemory.model.PersonalAccount;
import com.ruhuna.kavinda.database.inmemory.model.Sim;
import com.ruhuna.kavinda.database.inmemory.repository.InMemoryCurdRepository;
import com.ruhuna.kavinda.database.inmemory.repository.implementation.InMemoryCurdRepositoryImpl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created By Supun Kavinda
 * Email naskavinda@gmail.com
 * Date  : 7/29/2018
 */
public class FeedData {

    private InMemoryCurdRepository inMemoryCurdRepository = new InMemoryCurdRepositoryImpl();

    public void init() {
        saveCorporateAccount();
        savePersonalAccount();
        saveSim();
    }

    private void saveCorporateAccount() {
        List<CorporateAccount> corporateAccounts = new ArrayList<>();
        for (int i = 1; i < 6; i++) {
            CorporateAccount corporateAccount = new CorporateAccount();
            corporateAccount.setCompanyName("company" + i);
            corporateAccount.setCreditLimit(BigDecimal.valueOf(30000));
            corporateAccounts.add(corporateAccount);
        }
        inMemoryCurdRepository.saveBulkCorporateAccount(corporateAccounts);
    }

    private void savePersonalAccount() {
        List<PersonalAccount> personalAccounts = new ArrayList<>();
        for (int i = 1; i < 6; i++) {
            PersonalAccount personalAccount = new PersonalAccount();
            personalAccount.setNic("92244562" + i + "v");
            personalAccount.setCreditLimit(BigDecimal.valueOf(1500));
            personalAccounts.add(personalAccount);
        }
        inMemoryCurdRepository.saveBulkPersonalAccount(personalAccounts);
    }

    private void saveSim() {
        List<Sim> sims = new ArrayList<>();
        for (int i = 1; i < 6; i++) {
            Sim sim = new Sim();
            sim.setAccountId(i);
            sim.setAccountType(AccountType.CORPORATE);
            String simNo = "719669" + i + "50";
            sim.setSimNo(Integer.parseInt(simNo));
            sims.add(sim);

            Sim sim1 = new Sim();
            sim1.setAccountId(i);
            sim1.setAccountType(AccountType.CORPORATE);
            simNo = "719669" + i + "51";
            sim1.setSimNo(Integer.parseInt(simNo));
            sims.add(sim1);
        }

        for (int i = 1; i < 6; i++) {
            Sim sim = new Sim();
            sim.setAccountId(i);
            sim.setAccountType(AccountType.PERSONAL);
            String simNo = "7196698" + i + "0";
            sim.setSimNo(Integer.parseInt(simNo));
            sims.add(sim);
        }

        inMemoryCurdRepository.saveBulkSim(sims);

    }




}
