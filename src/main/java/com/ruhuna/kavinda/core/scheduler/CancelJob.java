package com.ruhuna.kavinda.core.scheduler;

import com.ruhuna.kavinda.core.account.TransactionStatus;
import com.ruhuna.kavinda.database.CurdRepository;
import com.ruhuna.kavinda.database.inmemory.repository.implementation.InMemoryCurdRepositoryImpl;
import com.ruhuna.kavinda.logger.Logger;
import org.quartz.Job;
import org.quartz.JobExecutionContext;

/**
 * Created By Supun Kavinda
 * Email naskavinda@gmail.com
 * Date  : 7/28/2018
 */
public class CancelJob implements Job {

    @Override
    public void execute(JobExecutionContext jobExecutionContext) {
        CurdRepository curdRepository = new InMemoryCurdRepositoryImpl();
        curdRepository.changeTransactionType(Integer.parseInt(jobExecutionContext.getJobDetail().getName()), TransactionStatus.CANCEL);
        Logger.logInfoMessage(this, jobExecutionContext.getJobDetail().getName() + " transaction no is timeout. and it is automatically canceled.");
    }
}
