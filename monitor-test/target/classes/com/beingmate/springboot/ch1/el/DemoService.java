package com.beingmate.springboot.ch1.el;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @author yanhaizhe
 * @create 2017-06-08 下午 4:39
 **/
@Service
public class DemoService {

    @Value("其他类的属性")
    private String anothor;

    public String getAnothor() {
        return anothor;
    }

    public void setAnothor(String anothor) {
        this.anothor = anothor;
    }
}
