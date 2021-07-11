package com.zhanghp;

import com.zhanghp.service.DemoService;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * @author: zhanghp
 * @version: 1.0
 */
public class ClientDemo {
    //这是一个main方法，程序的入口
    public static void main(String[] args) throws Exception {

            DemoService demoService = (DemoService) Naming.lookup("rmi://localhost:8989/demoService");
            String s = demoService.demo("zhanghp");
            System.out.println(s);

    }
}
