package com.zhanghp.controller;


import com.zhanghp.pojo.Person;
import com.zhanghp.service.PersonService02;
import com.zhanghp.service.impl.PersonServiceImpl02;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
    PersonService02 personService02 = new PersonServiceImpl02();
    @RequestMapping("/test")
    @ResponseBody
    public List<Person> demo(){
        List<Person> show = personService02.show();
        return show;
    }
}
