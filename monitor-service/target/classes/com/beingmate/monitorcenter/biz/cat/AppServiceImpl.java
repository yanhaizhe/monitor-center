package com.beingmate.monitorcenter.biz.cat;

import com.alibaba.fastjson.JSON;
import com.beingmate.common.beancopier.BeanCopierUtils;
import com.beingmate.monitorcenter.client.cat.AppService;
import com.beingmate.monitorcenter.client.cat.dto.ConfigDTO;
import com.beingmate.monitorcenter.dal.cat.dao.ConfigDOMapper;
import com.beingmate.monitorcenter.dal.cat.dao.UserDefineRuleDOMapper;
import com.beingmate.monitorcenter.dal.cat.dataobject.ConfigDO;
import com.beingmate.monitorcenter.dal.cat.dataobject.ConfigDOExample;
import com.beingmate.monitorcenter.dal.cat.dataobject.UserDefineRuleDO;
import com.dangdang.ddframe.rdb.sharding.api.HintManager;
import com.dangdang.ddframe.rdb.sharding.api.rule.DataSourceRule;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by lenovo on 2017/2/20.
 */
@Service("appService")
public class AppServiceImpl implements AppService {

    @Autowired
    private ConfigDOMapper configDOMapper;

    @Autowired
    private UserDefineRuleDOMapper userDefineRuleDOMapper;


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
        example.createCriteria().andNameLike("%剑魔%");
        HintManager.getInstance().setMasterRouteOnly();
        List<ConfigDO> configQueries = configDOMapper.selectByExample(example);
//        Map<String, Object> param = new HashMap<>();
//        List<String> re = new ArrayList<>();
//        re.add("2");
//        re.add("1");
//        param.put("contentList", re);
////        param.put("content", "111111");
//        List<ConfigDO> configQueries = configDOMapper.selectByExampleP(param);
        List<ConfigDTO> configDTOS = new ArrayList<>();
        BeanCopierUtils.copyListBean(configQueries,configDTOS,ConfigDTO.class);
        PageInfo<ConfigDTO> pageInfo = new PageInfo<>(configDTOS);
        return pageInfo;
    }

    @Override
    public ConfigDTO findOne(Integer id) {
        HintManager.getInstance().setMasterRouteOnly();
        return configDOMapper.selectByPrimaryKey(id);
    }

    @Override
    public long insertD(ConfigDTO configDTO) {
        ConfigDO configDO = new ConfigDO();
        BeanCopierUtils.copyProperties(configDTO, configDO);
        configDOMapper.insert(configDO);
        UserDefineRuleDO userDefineRuleDO = new UserDefineRuleDO();
        userDefineRuleDO.setId(1);
        userDefineRuleDO.setCreationDate(new Date());
        userDefineRuleDO.setContent("```1122343445");
        userDefineRuleDOMapper.insert(userDefineRuleDO);
//        DataSourceRule dataSourceRule = new DataSourceRule(dataSourceMap,"datasource_0")
        return 1L;
    }

    @Override
    public long updateD(){
        HintManager.getInstance().setMasterRouteOnly();
        ConfigDO configDO = configDOMapper.selectByPrimaryKey(1);
        configDO.setContent("jjdjfjdjf");
//        configDO.setName("剑魔update");
        return configDOMapper.updateByPrimaryKeySelective(configDO);
    }

    @Override
    public PageInfo<ConfigDTO> findConfigDOS1(Integer pageNo, Integer pageSize) {
        pageNo = pageNo == null?1:pageNo;
        pageSize = pageSize == null?10:pageSize;
        PageHelper.startPage(pageNo, pageSize);
        ConfigDOExample example = new ConfigDOExample();
        example.setOrderByClause("id, name");
        example.createCriteria().andNameLike("%剑魔%");
        List<ConfigDO> configQueries = configDOMapper.selectByExample(example);
        List<ConfigDTO> configDTOS = new ArrayList<>();
        BeanCopierUtils.copyListBean(configQueries,configDTOS,ConfigDTO.class);
        PageInfo<ConfigDTO> pageInfo = new PageInfo<>(configDTOS);
        return pageInfo;
    }
}
