package com.beingmate.monitorcenter;

import com.beingmate.monitorcenter.client.app.AppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by lenovo on 2017/2/20.
 */
@RestController
@RequestMapping("/app")
public class AppController {
    @Autowired
    private AppService appService;

    @RequestMapping(value = "/findString",produces = "application/json;charset=UTF-8")
    public String findString(){
        return appService.findString();
    }

    @RequestMapping(value = "/findConfig",produces = "application/json;charset=UTF-8")
    public String findConfig(){
        return appService.findConfig();
    }

}
