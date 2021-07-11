package com.zhanghp.service.impl;

import com.zhanghp.dubbo.service.DubboService;
import org.apache.dubbo.config.annotation.Service;

/**
 * @author: zhanghp
 * @version: 1.0
 */
@Service
public class DubboServiceImpl implements DubboService {
    @Override
    public String find(String s) {
        System.out.println("启动成功");
        return s+"123";
    }
}
