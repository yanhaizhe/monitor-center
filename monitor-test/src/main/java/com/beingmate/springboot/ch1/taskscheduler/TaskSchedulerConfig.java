package com.beingmate.springboot.ch1.taskscheduler;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author yanhaizhe
 * @create 2017-06-08 下午 5:48
 **/
@Configuration
@ComponentScan("com.beingmate.springboot.ch1.taskscheduler")
@EnableScheduling
public class TaskSchedulerConfig {

}
