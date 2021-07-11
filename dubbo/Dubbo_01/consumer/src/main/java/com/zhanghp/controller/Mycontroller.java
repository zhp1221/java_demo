package com.zhanghp.controller;

import com.zhanghp.service.WebService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author: zhanghp
 * @version: 1.0
 */
@Controller
public class Mycontroller {
    @Autowired
    private WebService webService ;
    @RequestMapping("/show")
    @ResponseBody
    public String test(){
        String show = webService.show();
        return show;
    }
}
