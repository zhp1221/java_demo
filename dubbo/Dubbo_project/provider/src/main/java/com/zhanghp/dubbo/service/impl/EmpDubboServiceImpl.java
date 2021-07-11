package com.zhanghp.dubbo.service.impl;

import com.zhanghp.dubbo.service.EmpDubboService;
import com.zhanghp.mapper.EmpMapper;
import com.zhanghp.pojo.Emp;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author: zhanghp
 * @version: 1.0
 */
@Service
public class EmpDubboServiceImpl implements EmpDubboService {
    @Autowired
    private EmpMapper empMapper;
    @Override
    public int insertEmp(Emp emp) {
        return empMapper.insertEmp(emp);
    }

    @Override
    public List<Emp> findEmpByDeptId(Integer did) {
        return empMapper.findEmpByDeptId(did);
    }
}
