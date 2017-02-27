package com.beingmate.monitorcenter.dp.pattern.afp.safp;

import com.beingmate.monitorcenter.dp.pattern.afp.common.service.Sender;
import com.beingmate.monitorcenter.dp.pattern.afp.common.service.impl.MailSender;
import com.beingmate.monitorcenter.dp.pattern.afp.common.service.impl.SmsSender;

/**
 * 1、与工厂方法模式相比，在客户端不需要创建工厂实例
 *
 * 2、对新增对象时，仍然违背了开闭原则，但粒度控制在类方法的新增，此处还好
 *
 * Created by lenovo on 2017/2/27.
 */
public class StaticFactoryPattern {
    /**
     *
     * @return
     */
    public static Sender mailSender(){
        return new MailSender();
    }

    public static Sender smsSender(){
        return new SmsSender();
    }
}
