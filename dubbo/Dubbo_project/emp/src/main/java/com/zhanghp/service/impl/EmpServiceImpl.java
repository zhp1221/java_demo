package com.zhanghp.service.impl;

import com.zhanghp.dubbo.service.DeptDubboService;
import com.zhanghp.dubbo.service.EmpDubboService;
import com.zhanghp.pojo.Dept;
import com.zhanghp.pojo.Emp;
import com.zhanghp.service.EmpService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

/**
 * @author: zhanghp
 * @version: 1.0
 */
@Service
public class EmpServiceImpl implements EmpService {
    @Reference
    private EmpDubboService empDubboService;
    @Reference
    private DeptDubboService deptDubboService;
    @Override
    public void insert(Emp emp, MultipartFile file) {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String realPath = request.getServletContext().getRealPath("/img");
        System.out.println(realPath);
        //uuid
        String uuid = UUID.randomUUID().toString();
        String originalFilename = file.getOriginalFilename();
        uuid += originalFilename.substring(originalFilename.lastIndexOf("."));
        File file1 = new File(realPath);
        if (!file1.exists()) {
            file1.mkdirs();
        }
        try {
            file.transferTo(new File(realPath,uuid));
            emp.setPhoto("http://localhost:8091/img/"+uuid);
            empDubboService.insertEmp(emp);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Dept> showAll() {
         return deptDubboService.findAllDept();
    }
}






