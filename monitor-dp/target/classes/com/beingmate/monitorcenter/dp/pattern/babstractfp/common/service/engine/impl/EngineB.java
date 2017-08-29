package com.beingmate.monitorcenter.dp.pattern.babstractfp.common.service.engine.impl;

import com.beingmate.monitorcenter.dp.pattern.babstractfp.common.service.engine.Engine;

/**
 * Created by lenovo on 2017/2/27.
 */
public class EngineB implements Engine {
    @Override
    public void draw() {
        System.out.println("Inside EngineB::draw() method.");
    }
}
