package com.beingmate.monitorcenter.cat;

import com.beingmate.monitorcenter.client.cat.AppService;
import com.beingmate.monitorcenter.client.cat.dto.ConfigDTO;
import com.beingmate.monitorcenter.common.BaseTest;
import com.github.pagehelper.PageInfo;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by lenovo on 2017/2/24.
 */
public class AppController extends BaseTest {
    @Autowired
    private AppService appService;

    @Test
    public void testFindConfigDOS(){
        System.out.println("第一个测试方法*******");
        PageInfo<ConfigDTO> pageInfo =  appService.findConfigDOS(1,5);
        List<ConfigDTO> configDTOList =  pageInfo.getList();
        Assert.assertEquals(configDTOList.size(),5);
    }

}
