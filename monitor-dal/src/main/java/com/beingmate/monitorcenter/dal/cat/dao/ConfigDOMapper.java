package com.beingmate.monitorcenter.dal.cat.dao;

import com.beingmate.monitorcenter.dal.cat.dataobject.ConfigDO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ConfigDOMapper {
    ConfigDO selectByPrimaryKey(Integer id);

    List<ConfigDO> listConfigByName(@Param("name") String name);
}