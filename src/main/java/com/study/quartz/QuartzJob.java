package com.study.quartz;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.quartz.*;
import sun.awt.geom.AreaOp;

import java.text.SimpleDateFormat;
import java.util.Date;

public class QuartzJob implements Job {
    @Getter
    @Setter
    private String msg1;
    @Setter
    @Getter
    private String msg2;
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        //编写具体业务逻辑
        Date date = new Date();
        SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(sf.format(date));
        //获取传入参数 methods 1
        JobKey keyJ=jobExecutionContext.getJobDetail()  //获取JobDetail 信息
                .getKey();
        System.out.println(keyJ.getName()+":"+keyJ.getGroup());
        TriggerKey keyT=jobExecutionContext.getTrigger() //获取Trigger 信息
                .getKey();
        System.out.println(keyT.getName()+":"+keyT.getGroup());
        //获取传入参数 methods 2
        JobDataMap dataMapJ=jobExecutionContext.getJobDetail().getJobDataMap(); //获取JobDetail 传入参数
        System.out.println(dataMapJ.get("msg1")+":"+dataMapJ.get("msg2"));
        JobDataMap dataMapT=jobExecutionContext.getTrigger().getJobDataMap(); //获取Trigger 传入参数
        System.out.println(dataMapT.get("msg1")+":"+dataMapT.get("msg2"));
        JobDataMap dataMap=jobExecutionContext.getMergedJobDataMap(); //获取传入参数
        System.out.println(dataMap.get("msg1")+":"+dataMap.get("msg2"));
        //获取传入参数 methods 3
        System.out.println(msg1+":"+msg2);
    }
}
