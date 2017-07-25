package com.beingmate.monitorcenter.dal.cat.dao;

import com.beingmate.monitorcenter.dal.cat.dataobject.UserDefineRuleDO;
import com.beingmate.monitorcenter.dal.cat.dataobject.UserDefineRuleDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserDefineRuleDOMapper {
    long countByExample(UserDefineRuleDOExample example);

    int deleteByExample(UserDefineRuleDOExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(UserDefineRuleDO record);

    int insertSelective(UserDefineRuleDO record);

    List<UserDefineRuleDO> selectByExampleWithBLOBs(UserDefineRuleDOExample example);

    List<UserDefineRuleDO> selectByExample(UserDefineRuleDOExample example);

    UserDefineRuleDO selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") UserDefineRuleDO record, @Param("example") UserDefineRuleDOExample example);

    int updateByExampleWithBLOBs(@Param("record") UserDefineRuleDO record, @Param("example") UserDefineRuleDOExample example);

    int updateByExample(@Param("record") UserDefineRuleDO record, @Param("example") UserDefineRuleDOExample example);

    int updateByPrimaryKeySelective(UserDefineRuleDO record);

    int updateByPrimaryKeyWithBLOBs(UserDefineRuleDO record);

    int updateByPrimaryKey(UserDefineRuleDO record);
}