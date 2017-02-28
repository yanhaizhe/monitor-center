package com.beingmate.monitorcenter.dp.pattern.afp.fp.factory;

import com.beingmate.monitorcenter.dp.pattern.afp.common.service.Sender;
import com.beingmate.monitorcenter.dp.pattern.afp.common.service.impl.MailSender;

/**
 * Created by lenovo on 2017/2/27.
 */
public class MailFactoryPattern implements IFactoryPattern {
    @Override
    public Sender getInstance() {
        return new MailSender();
    }
}
