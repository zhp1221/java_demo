package com.zhanghp.controller;

import com.zhanghp.pojo.Dept;
import com.zhanghp.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author: zhanghp
 * @version: 1.0
 */
@Controller
public class DeptController{
    @Autowired
    private DeptService deptService;
    @GetMapping("/dept")
    public String DeptfindAll(Model model){
        model.addAttribute("list",deptService.findAll());
        return "dept";
    }
    @GetMapping("show")
    public String showByDeptID(Integer did,Model model){
        model.addAttribute("emp",deptService.findEmpByDeptId(did));
        return "show";
    }
}
