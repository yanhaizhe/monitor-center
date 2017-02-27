package com.beingmate.monitorcenter.dp.pattern.fp.fmpe.factory;

import com.beingmate.monitorcenter.dp.pattern.fp.common.service.Sender;
import com.beingmate.monitorcenter.dp.pattern.fp.common.service.impl.MailSender;

/**
 * Created by lenovo on 2017/2/27.
 */
public class MailFactoryMethodPattern implements IFactoryMethodPattern {
    @Override
    public Sender getInstance() {
        return new MailSender();
    }
}
