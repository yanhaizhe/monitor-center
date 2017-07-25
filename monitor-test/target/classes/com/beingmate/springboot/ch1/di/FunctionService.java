package com.beingmate.springboot.ch1.di;

import org.springframework.stereotype.Service;

/**
 * @author yanhaizhe
 * @create 2017-06-07 下午 10:05
 **/
@Service
public class FunctionService {
    public String sayHello(String world){
        return "Hello world !";
    }
}
