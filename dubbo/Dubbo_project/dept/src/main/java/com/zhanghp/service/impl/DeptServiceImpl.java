package com.zhanghp.service.impl;

import com.zhanghp.dubbo.service.DeptDubboService;
import com.zhanghp.dubbo.service.EmpDubboService;
import com.zhanghp.pojo.Dept;
import com.zhanghp.pojo.Emp;
import com.zhanghp.service.DeptService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Service;


import java.util.List;

/**
 * @author: zhanghp
 * @version: 1.0
 */
@Service
public class DeptServiceImpl implements DeptService {
    @Reference
    private DeptDubboService deptDubboService;
    @Reference
    private EmpDubboService empDubboService;
    @Override
    public List<Dept> findAll() {
        return deptDubboService.findAllDept();
    }

    @Override
    public List<Emp> findEmpByDeptId(Integer did) {
        return empDubboService.findEmpByDeptId(did);
    }
}
