package com.beingmate.monitorcenter.common;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by lenovo on 2017/2/24.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:/spring/spring-context.xml","classpath*:/spring/spring-servlet.xml"})
//@ContextConfiguration(classes = {HibernateConfiguration.class})
public class BaseTest {
}
