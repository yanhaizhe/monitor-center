package com.beingmate.monitorcenter.biz.cat;

import com.alibaba.fastjson.JSON;
import com.beingmate.common.beancopier.BeanCopierUtils;
import com.beingmate.monitorcenter.client.cat.AppService;
import com.beingmate.monitorcenter.client.cat.dto.ConfigDTO;
import com.beingmate.monitorcenter.dal.cat.dao.ConfigDOMapper;
import com.beingmate.monitorcenter.dal.cat.dataobject.ConfigDO;
import com.beingmate.monitorcenter.dal.cat.dataobject.ConfigDOExample;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
    public PageInfo<ConfigDTO> findConfigDOS(Integer pageNo,Integer pageSize) {
        pageNo = pageNo == null?1:pageNo;
        pageSize = pageSize == null?10:pageSize;
        PageHelper.startPage(pageNo, pageSize);
        ConfigDOExample example = new ConfigDOExample();
        example.setOrderByClause("id, name");
        example.createCriteria().andNameLike("剑魔");
        List<ConfigDO> configQueries = configDOMapper.selectByExample(example);
        List<ConfigDTO> configDTOS = new ArrayList<>();
        BeanCopierUtils.copyListBean(configQueries,configDTOS,ConfigDTO.class);
        PageInfo<ConfigDTO> pageInfo = new PageInfo<>(configDTOS);
        return pageInfo;
    }
}
