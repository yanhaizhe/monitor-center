package com.beingmate.monitorcenter.cat;

import com.beingmate.monitorcenter.client.cat.AppService;
import com.beingmate.monitorcenter.client.cat.dto.ConfigDTO;
import com.beingmate.monitorcenter.common.BaseTest;
import com.github.pagehelper.PageInfo;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import java.util.List;

/**
 * Created by lenovo on 2017/2/24.
 */
public class AppController extends BaseTest {
    @Autowired
    private AppService appService;

    @Test
    public void testFindConfigDOS() {
        System.out.println("第一个测试方法*******");
        PageInfo<ConfigDTO> pageInfo = appService.findConfigDOS(1, 5);
        List<ConfigDTO> configDTOList = pageInfo.getList();
        Assert.assertEquals(configDTOList.size(), 5);
    }


    @Test
    public void testFindConfigDOS1() {
        System.out.println("第一个测试方法*******");
//        PageInfo<ConfigDTO> pageInfo =  appService.findConfigDOS(1,5);
//        List<ConfigDTO> configDTOList =  pageInfo.getList();
//        Assert.assertEquals(configDTOList.size(),5);

        Resource resource1 = new ClassPathResource("");

        ResourceLoader resourceLoader = new PathMatchingResourcePatternResolver();
        Resource resource = resourceLoader.getResource("");
        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
        reader.loadBeanDefinitions(resource);
        factory.getBean("");
//        BeanDefinition
//        BeanDefinitionRegistry
//        AnnotationBeanWiringInfoResolver
//        AnnotatedBeanDefinition
//        AnnotationConfigContextLoader
//        AnnotationConfigWebContextLoader
//        AnnotationConfigApplicationContext
//        ResourceLoader


    }


}
