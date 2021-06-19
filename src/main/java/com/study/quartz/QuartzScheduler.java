package com.study.quartz;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

public class QuartzScheduler {
    public static void main(String[] args) throws SchedulerException {
        //jobDetail 与job 绑定
        JobDetail jobDetail= JobBuilder.newJob(QuartzJob.class).withIdentity("quartsDemo").build();
        Trigger trigger = TriggerBuilder.newTrigger().withIdentity("quartzTrigger").startNow()
                .withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(2).repeatForever())
                .build();
        SchedulerFactory schedulerFactory = new StdSchedulerFactory();
        Scheduler scheduler = schedulerFactory.getScheduler();
        scheduler.start();
        scheduler.scheduleJob(jobDetail,trigger);

    }
}
