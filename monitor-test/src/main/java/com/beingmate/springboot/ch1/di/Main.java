package com.beingmate.springboot.ch1.di;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author yanhaizhe
 * @create 2017-06-07 下午 10:10
 **/
public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DiConfig.class);
        UseFunctionService useFunctionService = context.getBean(UseFunctionService.class);
        System.out.println(useFunctionService.sayHello("di"));
//        context.close();
    }
}
