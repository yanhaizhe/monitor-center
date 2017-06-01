package com.beingmate.monitorcenter.controller;

import com.beingmate.monitorcenter.client.cat.AppService;
import com.beingmate.monitorcenter.client.cat.dto.ConfigDTO;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

/**
 * Created by lenovo on 2017/2/20.
 */
@RestController
@RequestMapping
public class AppController {
    @Autowired
    private AppService appService;

    @RequestMapping(value="/login",method=RequestMethod.GET)
    public String loginForm(Model model){
        model.addAttribute("user","user");
        return "login";
    }

    @RequestMapping(value = "/findString",produces = "application/json;charset=UTF-8")
    public String findString(){
        return appService.findString();
    }

    @RequestMapping(value = "/findConfig",produces = "application/json;charset=UTF-8")
    public String findConfig(){
        return appService.findConfig();
    }

    @RequestMapping(value = "/findConfigs", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public PageInfo<ConfigDTO> findConfigDOS(@RequestParam(value = "pageNo",defaultValue = "1") Integer pageNo, @RequestParam(value = "size", defaultValue = "10") Integer size, HttpServletResponse response){
        return appService.findConfigDOS(pageNo,size);
    }

    @RequestMapping(value = "/findConfigs1", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public PageInfo<ConfigDTO> findConfigDOS1(@RequestParam(value = "pageNo",defaultValue = "1") Integer pageNo, @RequestParam(value = "size", defaultValue = "10") Integer size, HttpServletResponse response){
        return appService.findConfigDOS1(pageNo,size);
    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public long insert(@RequestBody ConfigDTO configDTO){
        return appService.insertD(configDTO);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public long update(){
        return appService.updateD();
    }
}
