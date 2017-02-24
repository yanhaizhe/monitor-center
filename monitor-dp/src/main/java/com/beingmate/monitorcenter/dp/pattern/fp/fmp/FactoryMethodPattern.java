package com.beingmate.monitorcenter.dp.pattern.fp.fmp;

import com.beingmate.monitorcenter.dp.pattern.fp.common.service.Sender;
import com.beingmate.monitorcenter.dp.pattern.fp.common.service.impl.MailSender;
import com.beingmate.monitorcenter.dp.pattern.fp.common.service.impl.SmsSender;

/**
 * 多工厂方法模式：
 * 1、若接口新增实现类，工厂类中要添加方法
 * 2、在客户端调用的时候，要多创建工厂类
 *
 * 3、解决了简单工厂模式中传参错误问题
 * Created by lenovo on 2017/2/24.
 */
public class FactoryMethodPattern {

    /**
     *
     * @return
     */
    public Sender newMailSender(){
        return  new MailSender();
    }

    public Sender newSmsSender(){
        return new SmsSender();
    }

}
