package com.beingmate.springboot.ch1.aop;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author yanhaizhe
 * @create 2017-06-08 上午 10:48
 **/
@Configuration
@ComponentScan("com.beingmate.springboot.ch1.aop")
@EnableAspectJAutoProxy
public class AopConfig {
}
