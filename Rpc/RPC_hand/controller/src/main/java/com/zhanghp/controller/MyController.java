package com.zhanghp.controller;

import com.zhanghp.pojo.Person;
import com.zhanghp.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
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
    @Autowired
    private PersonService personService;


    @RequestMapping("/run")
    @ResponseBody
    public List<Person> show(){
        return personService.show();
    }
}
