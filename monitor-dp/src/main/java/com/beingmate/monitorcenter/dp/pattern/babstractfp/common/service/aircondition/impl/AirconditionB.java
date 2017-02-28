package com.beingmate.monitorcenter.dp.pattern.babstractfp.common.service.aircondition.impl;

import com.beingmate.monitorcenter.dp.pattern.babstractfp.common.service.aircondition.Aircondition;

/**
 * Created by lenovo on 2017/2/27.
 */
public class AirconditionB implements Aircondition {
    @Override
    public void fill() {
        System.out.println("Inside AirconditionB::fill() method.");
    }
}
