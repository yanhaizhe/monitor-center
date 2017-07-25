package com.beingmate.springboot.ch1.taskexecutor;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @author yanhaizhe
 * @create 2017-06-08 下午 5:29
 **/
@Service
public class AsyncTaskService {

    @Async
    public void executeAsyncTask(Integer i){
        System.out.println("执行异步任务："+i);
    }

    @Async
    public void executeAsyncTaskPlus(Integer i){
        System.out.println("执行异步任务+1："+(i+1));
    }
}
