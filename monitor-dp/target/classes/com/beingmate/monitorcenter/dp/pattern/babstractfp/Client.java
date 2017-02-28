package com.beingmate.monitorcenter.dp.pattern.babstractfp;

import com.beingmate.monitorcenter.dp.pattern.babstractfp.common.service.aircondition.Aircondition;
import com.beingmate.monitorcenter.dp.pattern.babstractfp.common.service.engine.Engine;

/**
 * Created by lenovo on 2017/2/27.
 */
public class Client {
    public static void main(String[] args) {
        AbstractFactory abstractFactory = FactoryProducer.getFactoryBMW320();
        Engine engine = abstractFactory.createEngine();
        Aircondition aircondition = abstractFactory.createAircondition();
        engine.draw();
        aircondition.fill();

    }
}
