package com.ruhuna.kavinda.core.scheduler;

import com.ruhuna.kavinda.exception.Assert;
import org.quartz.JobDetail;
import org.quartz.SimpleTrigger;

import java.util.Date;
/**
 * Created By Supun Kavinda
 * Email naskavinda@gmail.com
 * Date  : 7/28/2018
 */
public class JobScheduler {

    private JobScheduler() {
    }

    public static JobDetail createJob(String jobName, String groupName) {
        Assert.isEmpty(jobName,"Job name can not be null or empty.");
        Assert.isEmpty(groupName,"Group name can not be null or empty.");
        JobDetail job = new JobDetail();
        job.setName(jobName);
        job.setGroup(groupName);
        job.setJobClass(CancelJob.class);
        return job;
    }

    public static SimpleTrigger createTrigger(String triggerName, Date startTime) {
        Assert.isEmpty(triggerName,"Trigger name cannot be null or empty.");
        SimpleTrigger trigger = new SimpleTrigger();
        trigger.setName(triggerName);
        trigger.setStartTime(startTime);
        return trigger;
    }
}
