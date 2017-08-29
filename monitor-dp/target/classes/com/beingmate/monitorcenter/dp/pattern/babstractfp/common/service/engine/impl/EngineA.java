package com.beingmate.monitorcenter.dp.pattern.babstractfp.common.service.engine.impl;

import com.beingmate.monitorcenter.dp.pattern.babstractfp.common.service.engine.Engine;

/**
 * Created by lenovo on 2017/2/27.
 */
public class EngineA implements Engine {
    @Override
    public void draw() {
        System.out.println("Inside EngineA::draw() method.");
    }
}
