package com.beingmate.crazyjava.lambda;

/**
 * 客户端
 *
 * @author yanhaizhe
 * @create 2017-03-21 下午 10:11
 **/
public class Client {
    public static void main(String[] args) {
//        Runnable
        ProcessArray processArray = new ProcessArray();
        int[] array ={1,2,4,3};
        processArray.process(array, target->{
            int sum = 0;
            for(int tmp : target){
                sum += tmp;
            }
            System.out.printf("总和为："+sum);
        });
        processArray.process(array, target-> System.out.printf("总和为："+target)
        );

    }
}
