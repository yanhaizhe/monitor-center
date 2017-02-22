package com.beingmate.monitorcenter;

import com.beingmate.monitorcenter.client.cat.AppService;
import com.beingmate.monitorcenter.client.cat.dto.ConfigDTO;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

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

    @RequestMapping(value = "findConfigs",produces = "application/json;charset=UTF-8")
    public PageInfo<ConfigDTO> findConfigDOS(@RequestParam(value = "pageNo",defaultValue = "1") Integer pageNo, @RequestParam(value = "size", defaultValue = "10") Integer size, HttpServletResponse response){

        return null;
    }

}
