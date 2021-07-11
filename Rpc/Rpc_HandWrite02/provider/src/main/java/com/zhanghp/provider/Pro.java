package com.zhanghp.provider;

import com.zhanghp.service.PersonService;
import com.zhanghp.service.impl.PersonServiceImpl;
import org.apache.zookeeper.*;

import java.io.IOException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

/**
 * @author: zhanghp
 * @version: 1.0
 */
public class Pro {
    //这是一个main方法，程序的入口
    public static void main(String[] args)  {
        try {
            PersonServiceImpl personService = new PersonServiceImpl();
            String url = "rmi://localhost:8989/demoService";
            LocateRegistry.createRegistry(8989);
            Naming.bind(url,personService);
            ZooKeeper zooKeeper = new ZooKeeper("192.168.0.101:2181",100000000, new Watcher() {
                @Override
                public void process(WatchedEvent watchedEvent) {
                    System.out.println("获取连接");
                }
            });
            zooKeeper.create("/demo/rpc02",url.getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
            System.out.println("注册成功");
        } catch (AlreadyBoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
