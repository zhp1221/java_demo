package com.zhanghp.dubbo.service;

import com.zhanghp.pojo.Emp;

import java.util.List;

/**
 * @author: zhanghp
 * @version: 1.0
 */
public interface EmpDubboService {
    public int insertEmp(Emp emp);
    public List<Emp> findEmpByDeptId(Integer did);
}
