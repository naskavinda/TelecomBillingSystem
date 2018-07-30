package com.ruhuna.kavinda;

import com.ruhuna.kavinda.core.service.AccountService;
import com.ruhuna.kavinda.database.inmemory.feeddata.FeedData;
import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created By Supun Kavinda
 * Email naskavinda@gmail.com
 * Date  : 7/30/2018
 */
public class TelecomBillingControllerTest {
    @Test
    public void name() {

    }

    /*
    @Test
    public void should_returnZero_when_creditLimitExceed() {
        int simNo = 719669850;
        AccountService accountService = mock(AccountService.class);
        when(accountService.getTransactionId(simNo)).thenReturn(0);

        TelecomBillingController telecomBillingController = new TelecomBillingController();
        int result = telecomBillingController.authorize(simNo);
        assertThat(result, is(0));
    }

    @Test
    public void should_returnTransactionNo_when_creditLimitNotExceed() {
        int simNo = 719669851;
        AccountService accountService = mock(AccountService.class);
        when(accountService.getTransactionId(simNo)).thenReturn(1234561151);

        TelecomBillingController telecomBillingController = new TelecomBillingController();
        int result = telecomBillingController.authorize(simNo);
        assertThat(result,is(1234561151));
    }*/
}