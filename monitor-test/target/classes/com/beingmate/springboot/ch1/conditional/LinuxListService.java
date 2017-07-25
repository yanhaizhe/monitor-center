package com.beingmate.springboot.ch1.conditional;

import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Service;

/**
 * @author yanhaizhe
 * @create 2017-06-08 下午 6:12
 **/
@Service
@Conditional(LinuxCondition.class)
public class LinuxListService implements ListService {
    @Override
    public String showListCmd() {
        return "ls";
    }
}
