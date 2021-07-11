package com.zhanghp.server;

import com.zhanghp.service.DemoService;
import com.zhanghp.service.impl.DemoServiceImpl;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

/**
 * @author: zhanghp
 * @version: 1.0
 */
public class DemoServer {
    //这是一个main方法，程序的入口
    public static void main(String[] args) throws Exception{
        DemoService demoService = new DemoServiceImpl();
        LocateRegistry.createRegistry(8989);
        Naming.bind("rmi://localhost:8989/demoService",demoService);
        System.out.println("服务器启动成功");
    }
}
