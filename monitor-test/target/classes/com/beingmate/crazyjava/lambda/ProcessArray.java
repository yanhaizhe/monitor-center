package com.beingmate.crazyjava.lambda;

/**
 * 数组传入的地方
 *
 * @author yanhaizhe
 * @create 2017-03-21 下午 10:08
 **/
public class ProcessArray {
    public void process(int[] target, Command command){
        command.process(target);
    }
}
