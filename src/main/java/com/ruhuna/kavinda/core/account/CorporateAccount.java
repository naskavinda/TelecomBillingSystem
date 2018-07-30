package com.ruhuna.kavinda.core.account;

import com.ruhuna.kavinda.core.Sim;
import com.ruhuna.kavinda.exception.Assert;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created By Supun Kavinda
 * Email naskavinda@gmail.com
 * Date  : 7/25/2018
 */

public class CorporateAccount extends Account {

    private List<Sim> simList;

    /**
     * There List<Sim> parameter can not be empty. and creditLimit Parameter can not be less then zero.
     *
     * @param simList
     * @param creditLimit
     */
    public CorporateAccount(int accountId,List<Sim> simList, BigDecimal creditLimit,SmsService smsService) {
        super(creditLimit, accountId,smsService);
        Assert.isEmpty(simList);
        this.simList = simList;
    }

    /**
     * @return Clone of the simList.
     */
    public List<Sim> getSimList() {
        return new ArrayList<>(simList);
    }

    /**
     * This method is use add new sim.
     *
     * @param sim
     * @return CorporateAccount Object
     */
    public CorporateAccount addSim(Sim sim) {
        this.simList.add(sim);
        return this;
    }

}
