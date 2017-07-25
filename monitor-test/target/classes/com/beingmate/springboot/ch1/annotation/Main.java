package com.beingmate.springboot.ch1.annotation;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author yanhaizhe
 * @create 2017-06-08 上午 10:49
 **/
public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
        DemoService demoService = context.getBean(DemoService.class);
        demoService.outputResult();
        
    }
}
