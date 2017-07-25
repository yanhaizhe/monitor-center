package com.beingmate.springboot.ch1.annotation;

import org.springframework.stereotype.Service;

/**
 * @author yanhaizhe
 * @create 2017-06-12 下午 5:47
 **/
@Service
public class DemoService {
    public void outputResult() {
        System.out.println("组合注解");
    }
}
