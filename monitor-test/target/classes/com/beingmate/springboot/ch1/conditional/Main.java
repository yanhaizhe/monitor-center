package com.beingmate.springboot.ch1.conditional;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author yanhaizhe
 * @create 2017-06-08 下午 6:15
 **/
public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConditionConfig.class);
       ListService listService = context.getBean(ListService.class);
        System.out.println(context.getEnvironment().getProperty("os.name")+"系统命令列表"+listService.showListCmd());
    }
}
