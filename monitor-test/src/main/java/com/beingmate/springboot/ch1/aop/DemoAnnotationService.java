package com.beingmate.springboot.ch1.aop;

import org.springframework.stereotype.Service;

/**
 * @author yanhaizhe
 * @create 2017-06-08 上午 10:37
 **/
@Service
public class DemoAnnotationService {
    @Action(name = "注解式拦截的Add方法")
    public void add(){}
}
