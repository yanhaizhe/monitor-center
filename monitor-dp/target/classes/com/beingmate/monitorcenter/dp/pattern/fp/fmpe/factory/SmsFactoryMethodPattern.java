package com.beingmate.monitorcenter.dp.pattern.fp.fmpe.factory;

import com.beingmate.monitorcenter.dp.pattern.fp.common.service.Sender;
import com.beingmate.monitorcenter.dp.pattern.fp.common.service.impl.SmsSender;

/**
 * Created by lenovo on 2017/2/27.
 */
public class SmsFactoryMethodPattern implements IFactoryMethodPattern {
    @Override
    public Sender getInstance() {
        return new SmsSender();
    }
}
