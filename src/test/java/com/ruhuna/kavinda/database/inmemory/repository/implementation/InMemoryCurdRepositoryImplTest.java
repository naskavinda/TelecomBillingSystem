package com.ruhuna.kavinda.database.inmemory.repository.implementation;

import com.ruhuna.kavinda.database.CurdRepository;
import com.ruhuna.kavinda.database.inmemory.model.AccountType;
import com.ruhuna.kavinda.database.inmemory.model.CorporateAccount;
import com.ruhuna.kavinda.database.inmemory.model.Sim;
import com.ruhuna.kavinda.exception.SimNotRegisteredException;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

/**
 * Created By Supun Kavinda
 * Email naskavinda@gmail.com
 * Date  : 7/29/2018
 */
public class InMemoryCurdRepositoryImplTest {

    @Test
    public void should_returnAccountType_when_simNo_isContain_simMap() {
        int simNo = 719669850;
        CurdRepository inMemoryCurdRepository = new InMemoryCurdRepositoryImpl();
        List<Sim> sims = new ArrayList<>();
        Sim sim = new Sim();
        sim.setSimNo(719669850);
        sim.setAccountType(AccountType.CORPORATE);
        sims.add(sim);
        ((InMemoryCurdRepositoryImpl) inMemoryCurdRepository).saveBulkSim(sims);

        String result = inMemoryCurdRepository.getAccountTypeBySimNo(simNo);
        assertThat(result, is("CORPORATE"));
    }

    @Test(expected = SimNotRegisteredException.class)
    public void should_throwSimNotRegisteredException_when_simNo_isNotContain_simMap() {
        int simNo = 719669850;
        CurdRepository inMemoryCurdRepository = new InMemoryCurdRepositoryImpl();

        inMemoryCurdRepository.getAccountTypeBySimNo(simNo);
    }

    @Test
    public void should_returnCorporateAccount_when_give_simNo() {
        int simNo = 719669850;
        CurdRepository inMemoryCurdRepository = new InMemoryCurdRepositoryImpl();
        List<Sim> sims = new ArrayList<>();
        Sim sim = new Sim();
        sim.setSimNo(719669850);
        sim.setAccountType(AccountType.CORPORATE);
        sim.setAccountId(1);
        sims.add(sim);
        ((InMemoryCurdRepositoryImpl) inMemoryCurdRepository).saveBulkSim(sims);
        List<CorporateAccount> corporateAccounts = new ArrayList<>();
        CorporateAccount corporateAccount = new CorporateAccount();
        corporateAccount.setCreditLimit(BigDecimal.valueOf(30000));
        corporateAccount.setCompanyName("CORPORATE");
        corporateAccount.setAccountId(1);
        corporateAccounts.add(corporateAccount);
        ((InMemoryCurdRepositoryImpl) inMemoryCurdRepository).saveBulkCorporateAccount(corporateAccounts);

        com.ruhuna.kavinda.core.account.CorporateAccount result = inMemoryCurdRepository.getCorporateAccountBySimNo(simNo);
        List<com.ruhuna.kavinda.core.Sim> simList = List.of(new com.ruhuna.kavinda.core.Sim(719669850));// List.of method introduce in since java 1.9
        assertThat(result.getAccountId(), is(1));
        assertThat(result.getCreditLimit(), is(BigDecimal.valueOf(30000)));
        assertThat(result.getSimList().size(), is(simList.size()));
    }

    @Test
    public void should_returnPositiveValue_when_ask_transactionId() {
        CurdRepository inMemoryCurdRepository = new InMemoryCurdRepositoryImpl();

        int transactionId = inMemoryCurdRepository.getTransactionId();
        assertTrue(transactionId > 0);
    }

    @Test
    public void should_returnEmptyList_when_NoTransactionAvailable() {
        CurdRepository inMemoryCurdRepository = new InMemoryCurdRepositoryImpl();

        LinkedHashSet<Integer> transactionalNoList = ((InMemoryCurdRepositoryImpl) inMemoryCurdRepository).getTransactionalNoList();
        assertThat(transactionalNoList.size(), is(0));
    }


}