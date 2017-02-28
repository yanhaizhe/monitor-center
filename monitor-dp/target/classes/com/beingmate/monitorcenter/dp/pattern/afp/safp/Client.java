package com.beingmate.monitorcenter.dp.pattern.afp.safp;

import com.beingmate.monitorcenter.dp.pattern.afp.common.service.Sender;

/**
 * Created by lenovo on 2017/2/27.
 */
public class Client {
    public static void main(String[] args) {
        Sender sender = StaticFactoryPattern.mailSender();
        sender.send();
    }
}
