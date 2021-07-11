package com.zhanghp;

import com.zhanghp.dubbo.service.DubboService;
import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author: zhanghp
 * @version: 1.0
 */
@SpringBootApplication
@EnableDubbo
public class DubboApplication {
    //这是一个main方法，程序的入口
    public static void main(String[] args) {
        SpringApplication.run(DubboApplication.class,args);
    }
}
