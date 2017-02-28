package com.beingmate.monitorcenter.dp.pattern.babstractfp;

import com.beingmate.monitorcenter.dp.pattern.babstractfp.common.service.aircondition.Aircondition;
import com.beingmate.monitorcenter.dp.pattern.babstractfp.common.service.aircondition.impl.AirconditionA;
import com.beingmate.monitorcenter.dp.pattern.babstractfp.common.service.engine.Engine;
import com.beingmate.monitorcenter.dp.pattern.babstractfp.common.service.engine.impl.EngineA;

/**
 * Created by lenovo on 2017/2/27.
 */
public class FactoryBMW320 extends AbstractFactory {

    @Override
    Aircondition createAircondition() {
        return new AirconditionA();
    }

    @Override
    Engine createEngine() {
        return new EngineA();
    }
}
