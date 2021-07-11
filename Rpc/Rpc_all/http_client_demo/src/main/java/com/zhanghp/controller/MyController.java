package com.zhanghp.controller;

import com.zhanghp.bean.People;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author: zhanghp
 * @version: 1.0
 */
@Controller
public class MyController {
    @RequestMapping("/test")
    @ResponseBody
    public List<People> test01(@RequestBody List<People> list){
        return list;
    }
}
