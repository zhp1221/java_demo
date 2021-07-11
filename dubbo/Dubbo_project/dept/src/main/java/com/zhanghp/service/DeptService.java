package com.zhanghp.service;

import com.zhanghp.pojo.Dept;
import com.zhanghp.pojo.Emp;

import java.util.List;

/**
 * @author: zhanghp
 * @version: 1.0
 */
public interface DeptService {
    public List<Dept> findAll();
    public List<Emp> findEmpByDeptId(Integer did);
}
