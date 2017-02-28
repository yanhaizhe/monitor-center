package com.beingmate.monitorcenter.dp.pattern.afp.fp.factory;

import com.beingmate.monitorcenter.dp.pattern.afp.common.service.Sender;

/**
 *
 * 1、由客户端决定使用哪一个工厂来创建对应的对象（这不是将一个对象的直接依赖转换为对中间类的依赖吗？）
 *
 * 2、由子类决定实例化哪一个类
 * 3、遵循开闭原则
 *
 * Created by lenovo on 2017/2/27.
 */
public interface IFactoryPattern {
    /**
     * 获取需要的实例
     * @return
     */
    Sender getInstance();
}
