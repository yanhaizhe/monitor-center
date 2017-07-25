package com.beingmate.springboot.ch1.aop;

import java.lang.annotation.*;

/**
 * @author yanhaizhe
 * @create 2017-06-08 上午 10:35
 **/
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Action {
    String name();
}
