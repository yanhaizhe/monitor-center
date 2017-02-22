package com.beingmate.monitorcenter.dal.cat.dao;

import com.beingmate.monitorcenter.dal.cat.dataobject.ConfigDO;
import com.beingmate.monitorcenter.dal.cat.query.ConfigQuery;

import java.util.List;

public interface ConfigDOMapper {
    ConfigDO selectByPrimaryKey(Integer id);

    List<ConfigQuery> listConfigByName(String name);
}