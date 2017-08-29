package com.beingmate.monitorcenter.dp.pattern.observer;

import java.util.Observable;
import java.util.Observer;

/**
 * @author yanhaizhe
 * @create 2017-03-29 下午 3:56
 **/
public class Reader implements Observer {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void update(Observable o, Object arg) {
        System.out.printf("---"+arg);

    }
}
