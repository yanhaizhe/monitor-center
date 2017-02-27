package com.beingmate.monitorcenter.dp.pattern.fp.fmpe;

import com.beingmate.monitorcenter.dp.pattern.fp.common.service.Sender;
import com.beingmate.monitorcenter.dp.pattern.fp.fmpe.factory.IFactoryMethodPattern;
import com.beingmate.monitorcenter.dp.pattern.fp.fmpe.factory.MailFactoryMethodPattern;

/**
 * Created by lenovo on 2017/2/27.
 */
public class Client {
    public static void main(String[] args) {
        IFactoryMethodPattern pattern = new MailFactoryMethodPattern();
        Sender sender = pattern.getInstance();
        sender.send();
    }
}
