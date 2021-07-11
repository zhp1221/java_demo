package com.zhanghp.dubbo.service.impl;

import com.zhanghp.dubbo.service.DeptDubboService;
import com.zhanghp.mapper.DeptMapper;
import com.zhanghp.pojo.Dept;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author: zhanghp
 * @version: 1.0
 */
@Service
public class DeptDubboServiceImpl implements DeptDubboService {
    @Autowired
    private DeptMapper deptMapper;
    @Override
    public List<Dept> findAllDept() {
        return deptMapper.findAll();
    }
}
