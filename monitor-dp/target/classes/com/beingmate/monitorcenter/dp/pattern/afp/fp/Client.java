package com.beingmate.monitorcenter.dp.pattern.afp.fp;

import com.beingmate.monitorcenter.dp.pattern.afp.common.service.Sender;
import com.beingmate.monitorcenter.dp.pattern.afp.fp.factory.IFactoryPattern;
import com.beingmate.monitorcenter.dp.pattern.afp.fp.factory.MailFactoryPattern;

/**
 * Created by lenovo on 2017/2/27.
 */
public class Client {
    public static void main(String[] args) {
        IFactoryPattern pattern = new MailFactoryPattern();
        Sender sender = pattern.getInstance();
        sender.send();
    }
}
