package com.study.quartz;

import org.junit.Test;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.util.Date;

public class QuartzScheduler {
    public static void main(String[] args) throws SchedulerException {
        QuartzScheduler quartzScheduler=new QuartzScheduler();
        quartzScheduler.test1();
    }
    public void test1() throws SchedulerException {
        //jobDetail 与job 绑定
        JobDetail jobDetail= JobBuilder.newJob(QuartzJob.class)
                .withIdentity("quartzDemo","1")  //创建标识
                .usingJobData("msg1","1") //传入参数
                .usingJobData("msg2","2")
                .build();
        //Trigger 触发 job 执行
        Trigger trigger = TriggerBuilder.newTrigger()
                .withIdentity("quartzTrigger","1") //创建标识
                .startNow()  //立即执行
                .usingJobData("msg1","01") //传入参数
                .usingJobData("msg2","02")
                //设置频率
                .withSchedule(SimpleScheduleBuilder.simpleSchedule()
                        .withIntervalInSeconds(10)  //每十秒执行
                        .repeatForever())  //不间断重复执行
                .build();
        //Scheduler
        SchedulerFactory schedulerFactory = new StdSchedulerFactory();
        Scheduler scheduler = schedulerFactory.getScheduler();
        scheduler.start();
        scheduler.scheduleJob(jobDetail,trigger); //绑定JobDetail与Trigger

    }
}
