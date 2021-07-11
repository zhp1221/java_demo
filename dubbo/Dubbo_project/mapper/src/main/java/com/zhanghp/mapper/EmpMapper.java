package com.zhanghp.mapper;

import com.zhanghp.pojo.Emp;

import java.util.List;

/**
 * @author: zhanghp
 * @version: 1.0
 */
public interface EmpMapper {
    public int insertEmp(Emp emp);
    public List<Emp> findEmpByDeptId(Integer did);
}
