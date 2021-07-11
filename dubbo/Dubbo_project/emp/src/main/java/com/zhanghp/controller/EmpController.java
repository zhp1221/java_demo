package com.zhanghp.controller;

import com.zhanghp.pojo.Emp;
import com.zhanghp.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author: zhanghp
 * @version: 1.0
 */
@Controller
public class EmpController {
    @Autowired
    private EmpService empService;
    @GetMapping("empadd")
    public String empAdd(Model model){
        model.addAttribute("list",empService.showAll());
        return "emp-add";
    }
    @PostMapping("/add")
    public String insertEmp(Emp emp , MultipartFile file){
        empService.insert(emp,file);
        return "emp-add";
    }
}
