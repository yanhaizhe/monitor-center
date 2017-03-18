package com.beingmate.monitorcenter.dp.pattern.babstractfp;

import com.beingmate.monitorcenter.dp.pattern.babstractfp.common.service.aircondition.Aircondition;
import com.beingmate.monitorcenter.dp.pattern.babstractfp.common.service.engine.Engine;

/**
 *
 * Created by lenovo on 2017/2/27.
 */
public abstract class AbstractFactory {
    /**
     * 制造引擎
     * @return
     */
    abstract Engine createEngine();

    /**
     * 制造空调
     * @return
     */
    abstract  Aircondition createAircondition() ;
}
