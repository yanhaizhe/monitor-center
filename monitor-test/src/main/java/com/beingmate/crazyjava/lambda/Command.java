package com.beingmate.crazyjava.lambda;

/**
 * 代表行为的接口
 *
 * @author yanhaizhe
 * @create 2017-03-21 下午 10:06
 **/
public interface Command {
    void process(int[] target);
}
