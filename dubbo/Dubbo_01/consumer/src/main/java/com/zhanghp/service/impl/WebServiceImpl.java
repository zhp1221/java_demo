package com.zhanghp.service.impl;

import com.zhanghp.dubbo.service.DubboService;
import com.zhanghp.service.WebService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Service;

/**
 * @author: zhanghp
 * @version: 1.0
 */
@Service
public class WebServiceImpl implements WebService {
    @Reference(loadbalance = "roundrobin")
    private DubboService dubboService;
    @Override
    public String show() {
        String s = dubboService.find("zz");
        return s;

    }
}
