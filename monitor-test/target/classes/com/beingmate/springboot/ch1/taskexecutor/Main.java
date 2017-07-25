package com.beingmate.springboot.ch1.taskexecutor;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author yanhaizhe
 * @create 2017-06-07 下午 10:10
 **/
public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(TaskExecutorConfig.class);
//        UseFunctionService useFunctionService = context.getBean(UseFunctionService.class);
        AsyncTaskService asyncTaskService = context.getBean(AsyncTaskService.class);
        for(int i=0;i<50;i++){
            asyncTaskService.executeAsyncTask(i);
//            asyncTaskService.executeAsyncTaskPlus(i);
        }
        context.close();
    }
}
