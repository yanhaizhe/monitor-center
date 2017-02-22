package com.beingmate.monitorcenter.client.cat;

import com.beingmate.monitorcenter.client.cat.dto.ConfigDTO;
import com.github.pagehelper.PageInfo;

/**
 * Created by lenovo on 2017/2/20.
 */
public interface AppService {
    /**
     * 查找一个字符串
     * @return
     */
    String findString();

    /**
     *
     * @return
     */
    String findConfig();

    /**
     *
     * @return
     */
    PageInfo<ConfigDTO> findConfigDOS(Integer pageNo,Integer size);
}
