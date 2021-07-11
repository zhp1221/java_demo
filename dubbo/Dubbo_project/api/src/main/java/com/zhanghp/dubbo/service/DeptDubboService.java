package com.zhanghp.dubbo.service;

import com.zhanghp.pojo.Dept;

import java.util.List;

/**
 * @author: zhanghp
 * @version: 1.0
 */
public interface DeptDubboService {
    public List<Dept> findAllDept();
}
