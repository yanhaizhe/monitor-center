package com.beingmate.springboot.ch1.conditional;

import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Service;

/**
 * @author yanhaizhe
 * @create 2017-06-08 下午 6:11
 **/
@Service
@Conditional(WindowsCondition.class)
public class WindowsListService implements ListService {
    @Override
    public String showListCmd() {
        return "dir";
    }
}
