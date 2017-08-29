package com.beingmate.monitorcenter.dp.pattern.babstractfp;

/**
 * Created by lenovo on 2017/2/27.
 */
public class FactoryProducer {

    public static AbstractFactory getFactoryBMW320(){
        return new FactoryBMW320();
    }

    public static AbstractFactory getFactoryBMW523(){
        return new FactoryBMW523();
    }
}
