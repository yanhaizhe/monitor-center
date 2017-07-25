package com.beingmate.springboot.ch1.taskscheduler;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author yanhaizhe
 * @create 2017-06-08 下午 5:43
 **/
@Service
public class SchedulerService {
    private static final SimpleDateFormat dateFromat = new SimpleDateFormat("HH:mm:ss");

    @Scheduled(fixedRate = 1000)
    public void reportCurrentTime(){
        System.out.println("每隔一秒执行一次"+dateFromat.format(new Date()));
    }

    @Scheduled(cron = "0 53 17 ? * *")
    public void fixTimeExecution(){
        System.out.println("在指定时间执行"+dateFromat.format(new Date()));
    }
}
