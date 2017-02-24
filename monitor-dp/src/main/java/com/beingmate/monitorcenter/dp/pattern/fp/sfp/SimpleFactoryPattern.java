package com.beingmate.monitorcenter.dp.pattern.fp.sfp;

import com.beingmate.monitorcenter.dp.pattern.fp.common.enums.SendWayEnum;
import com.beingmate.monitorcenter.dp.pattern.fp.common.service.Sender;
import com.beingmate.monitorcenter.dp.pattern.fp.common.service.impl.MailSender;
import com.beingmate.monitorcenter.dp.pattern.fp.common.service.impl.SmsSender;

/**
 * Created by lenovo on 2017/2/24.
 */
public class SimpleFactoryPattern {


    /**
     * 1、若需要新增实现类，此处需要修改，反而破坏了开闭原则
     * 2、传入的参数容易出错
     * @param type
     * @return
     */
    public Sender produce(SendWayEnum type){
        if(SendWayEnum.mail.equals(type)){
            return new MailSender();
        }else if(SendWayEnum.sms.equals(type)){
            return new SmsSender();
        }else {
            return null;
        }

    }
}
