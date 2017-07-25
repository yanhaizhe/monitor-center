package com.beingmate.springboot.ch1.el;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;

import java.io.IOException;

/**
 * @author yanhaizhe
 * @create 2017-06-08 下午 4:42
 **/
@Configuration
@ComponentScan("com.beingmate.springboot.ch1.el")
@PropertySource("classpath:com/beingmate/springboot/ch1/el/test.properties")
public class ELconfig {

    @Value("I Love You!")
    private String normal;

    @Value("#{systemProperties['os.name']}")
    private String osName;

    @Value("#{demoService.anothor}")
    private String fromAnother;

    @Value("classpath:com/beingmate/springboot/ch1/el/test.txt")
    private Resource fileContent;

    @Value("http://www.baidu.com")
    private Resource urlContent;

    @Value("${book.name}")
    private String bookName;

    @Autowired
    private Environment environment;

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    public void outputResource(){
        System.out.println(normal);
        System.out.println(osName);
        System.out.println(fromAnother);
        try {
            System.out.println(IOUtils.toString(fileContent.getInputStream()));
            System.out.println(IOUtils.toString(urlContent.getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(bookName);
        System.out.println(environment.getProperty("book.author"));
    }

}
