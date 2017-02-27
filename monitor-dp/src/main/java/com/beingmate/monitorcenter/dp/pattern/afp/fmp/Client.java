package com.beingmate.monitorcenter.dp.pattern.afp.fmp;

/**
 * Created by lenovo on 2017/2/24.
 */
public class Client {
    public static void main(String[] args) {
        FactoryMethodPattern pattern = new FactoryMethodPattern();
        pattern.newMailSender().send();
    }
}
