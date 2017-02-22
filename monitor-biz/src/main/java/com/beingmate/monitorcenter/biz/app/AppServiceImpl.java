package com.beingmate.monitorcenter.biz.app;

import com.alibaba.fastjson.JSON;
import com.beingmate.monitorcenter.client.cat.AppService;
import com.beingmate.monitorcenter.client.cat.dto.ConfigDTO;
import com.beingmate.monitorcenter.dal.cat.dao.ConfigDOMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by lenovo on 2017/2/20.
 */
@Service
public class AppServiceImpl implements AppService {

    @Autowired
    private ConfigDOMapper configDOMapper;


    @Override
    public String findString() {
        return "我是谁？";
    }

    @Override
    public String findConfig() {
        return JSON.toJSONString(configDOMapper.selectByPrimaryKey(1));
    }

    @Override
    public PageInfo<ConfigDTO> findConfigDOS(Integer pageNo,Integer size) {
        PageHelper.startPage(pageNo, size);

        return null;
    }
}
