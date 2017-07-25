package com.beingmate.springboot.ch1.el;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author yanhaizhe
 * @create 2017-06-07 下午 10:10
 **/
public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ELconfig.class);
        ELconfig eLconfig = context.getBean(ELconfig.class);
        eLconfig.outputResource();
        System.out.println();
//        context.close();
    }
}
