package com.beingmate.monitorcenter.dp.pattern.afp.common.service.impl;

import com.beingmate.monitorcenter.dp.pattern.afp.common.service.Sender;

/**
 * Created by lenovo on 2017/2/24.
 */
public class SmsSender implements Sender {
    @Override
    public void send() {
        System.out.println("this is sms sender!");
    }
}
