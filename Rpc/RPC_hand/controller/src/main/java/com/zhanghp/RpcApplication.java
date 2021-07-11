package com.zhanghp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author: zhanghp
 * @version: 1.0
 */
@SpringBootApplication
public class RpcApplication {
    //这是一个main方法，程序的入口
    public static void main(String[] args) {
        SpringApplication.run(RpcApplication.class,args);
    }
}
