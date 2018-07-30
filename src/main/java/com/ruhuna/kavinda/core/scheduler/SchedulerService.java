package com.ruhuna.kavinda.core.scheduler;

import com.ruhuna.kavinda.logger.Logger;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SimpleTrigger;
import org.quartz.impl.StdSchedulerFactory;

/**
 * Created By Supun Kavinda
 * Email naskavinda@gmail.com
 * Date  : 7/28/2018
 */
public class SchedulerService {

    private static final class SchedulerServiceHelper {
        private static SchedulerService INSTANCE = new SchedulerService();
    }

    public static SchedulerService getInstance() {
        return SchedulerServiceHelper.INSTANCE;
    }

    private SchedulerService() {
    }

    private static Scheduler scheduler = null;

    static {
        try {
            scheduler = new StdSchedulerFactory().getScheduler();
            scheduler.start();
        } catch (SchedulerException e) {
            Logger.logTraceMessage(SchedulerService.class, e);
        }
    }

    public void addJob(JobDetail jobDetail, SimpleTrigger simpleTrigger) {
        try {
            scheduler.scheduleJob(jobDetail, simpleTrigger);
        } catch (SchedulerException e) {
            Logger.logTraceMessage(this, e);
        }
    }

    public void removeJobFromScheduler(JobDetail jobDetail) {
        try {
            scheduler.deleteJob(jobDetail.getName(), jobDetail.getGroup());
        } catch (SchedulerException e) {
            Logger.logTraceMessage(this, e);
        }
    }
}
