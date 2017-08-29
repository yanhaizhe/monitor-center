package com.beingmate.monitorcenter.dp.pattern.babstractfp;

import com.beingmate.monitorcenter.dp.pattern.babstractfp.common.service.aircondition.Aircondition;
import com.beingmate.monitorcenter.dp.pattern.babstractfp.common.service.aircondition.impl.AirconditionB;
import com.beingmate.monitorcenter.dp.pattern.babstractfp.common.service.engine.Engine;
import com.beingmate.monitorcenter.dp.pattern.babstractfp.common.service.engine.impl.EngineB;

/**
 * Created by lenovo on 2017/2/27.
 */
public class FactoryBMW523 extends AbstractFactory {

    @Override
    Engine createEngine() {
        return new EngineB();
    }

    @Override
    Aircondition createAircondition() {
        return new AirconditionB();
    }
}
