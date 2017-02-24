package com.beingmate.monitorcenter.dal.cat.dao;

import com.beingmate.monitorcenter.dal.cat.dataobject.ConfigDO;
import com.beingmate.monitorcenter.dal.cat.dataobject.ConfigDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ConfigDOMapper {
    long countByExample(ConfigDOExample example);

    int deleteByExample(ConfigDOExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ConfigDO record);

    int insertSelective(ConfigDO record);

    List<ConfigDO> selectByExampleWithBLOBs(ConfigDOExample example);

    List<ConfigDO> selectByExample(ConfigDOExample example);

    ConfigDO selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ConfigDO record, @Param("example") ConfigDOExample example);

    int updateByExampleWithBLOBs(@Param("record") ConfigDO record, @Param("example") ConfigDOExample example);

    int updateByExample(@Param("record") ConfigDO record, @Param("example") ConfigDOExample example);

    int updateByPrimaryKeySelective(ConfigDO record);

    int updateByPrimaryKeyWithBLOBs(ConfigDO record);

    int updateByPrimaryKey(ConfigDO record);
}