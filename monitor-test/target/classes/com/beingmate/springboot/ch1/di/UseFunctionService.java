package com.beingmate.springboot.ch1.di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author yanhaizhe
 * @create 2017-06-07 下午 10:07
 **/
@Service
public class UseFunctionService {

    @Autowired
    private FunctionService functionService;

    public String sayHello(String word){
        return functionService.sayHello(word);
    }
}
