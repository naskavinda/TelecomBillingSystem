package com.ruhuna.kavinda.core.account;

import com.ruhuna.kavinda.core.Sim;
import com.ruhuna.kavinda.exception.Assert;

import java.math.BigDecimal;

/**
 * Created By Supun Kavinda
 * Email naskavinda@gmail.com
 * Date  : 27/25/2018
 */

public class PersonalAccount extends Account {

    private Sim sim;

    public PersonalAccount(int accountId, Sim sim, BigDecimal creditLimit,SmsService smsService) {
        super(creditLimit, accountId,smsService);
        Assert.isNull(sim);
        this.sim = sim;
    }

    public Sim getSim() {
        return sim;
    }

}
