package com.zhanghp.service;

import com.zhanghp.pojo.Dept;
import com.zhanghp.pojo.Emp;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @author: zhanghp
 * @version: 1.0
 */
public interface EmpService {
    public void insert(Emp emp, MultipartFile file);
    public List<Dept> showAll();
}
