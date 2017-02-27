package com.beingmate.monitorcenter.dp.pattern.fp.fmpe.factory;

import com.beingmate.monitorcenter.dp.pattern.fp.common.service.Sender;

/**
 * Created by lenovo on 2017/2/27.
 */
public interface IFactoryMethodPattern {
    /**
     * 获取需要的实例
     * @return
     */
    public Sender getInstance();
}
