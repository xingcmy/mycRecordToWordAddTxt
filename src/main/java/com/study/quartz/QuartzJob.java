package com.study.quartz;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.text.SimpleDateFormat;
import java.util.Date;


public class QuartzJob implements Job {
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        //编写具体业务逻辑
        Date date = new Date();
        SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(sf.format(date));
    }
}
