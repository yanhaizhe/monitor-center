package com.beingmate.springboot.ch1.javaconfig;

/**
 * @author yanhaizhe
 * @create 2017-06-07 下午 10:07
 **/
//@Service
public class UseFunctionService {

//    @Autowired
    private FunctionService functionService;

    public void setFunctionService(FunctionService functionService) {
        this.functionService = functionService;
    }

    public String sayHello(String word){
        return functionService.sayHello(word);
    }
}
