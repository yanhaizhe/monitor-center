package com.beingmate.springboot.ch1.aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author yanhaizhe
 * @create 2017-06-08 上午 10:49
 **/
public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AopConfig.class);
        DemoAnnotationService demoAnnotationService = context.getBean(DemoAnnotationService.class);
        DemoMethodService demoMethodService = context.getBean(DemoMethodService.class);
        demoAnnotationService.add();
        demoMethodService.add();
    }
}
