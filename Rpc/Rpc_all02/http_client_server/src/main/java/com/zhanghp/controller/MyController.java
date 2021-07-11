package com.zhanghp.controller;

import com.zhanghp.bean.People;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: zhanghp
 * @version: 1.0
 */
@Controller
public class MyController {
    @RequestMapping("/demo")
    @ResponseBody
    public String DemoController01(String param){
        return param+"hello";
    }
    @RequestMapping("/demo2")
    @ResponseBody
    public People DemoController02(People peo){

        return peo;
    }
    @RequestMapping("/demo3")
    @ResponseBody
    public List<People> DemoController03(){
        List<People> list = new ArrayList<>();
        list.add(new People("李",22));
        list.add(new People("张",11));
        return list;
    }
    @RequestMapping("/demo4")
    @ResponseBody
    @CrossOrigin
    public List<People> DemoController04(@RequestBody List<People> list){
        System.out.println(list);
        return list;
    }
}
