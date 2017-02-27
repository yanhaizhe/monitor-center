package com.beingmate.monitorcenter.dp.pattern.afp.sfp;

import com.beingmate.monitorcenter.dp.pattern.afp.common.enums.SendWayEnum;
import com.beingmate.monitorcenter.dp.pattern.afp.common.service.Sender;

/**
 * Created by lenovo on 2017/2/24.
 */
public class Client {

    public static void main(String[] args) {
        SimpleFactoryPattern pattern= new SimpleFactoryPattern();
        Sender sender = pattern.produce(SendWayEnum.mail);
        sender.send();
    }
}
