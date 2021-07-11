package com.zhanghp;

import com.zhanghp.service.impl.MyPersonServieImpl;
import org.apache.zookeeper.*;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

/**
 * @author: zhanghp
 * @version: 1.0
 */
public class ProviderRun {

    //这是一个main方法，程序的入口
    public static void main(String[] args) throws  Exception{
        MyPersonServieImpl myPersonServie = new MyPersonServieImpl();
        LocateRegistry.createRegistry(8989);
        String url = "rmi://localhost:8989/myPersonService";
        Naming.bind(url,myPersonServie);
        System.out.println("rmi服务启动成功");
        ZooKeeper zooKeeper = new ZooKeeper("192.168.0.101:2181", 100000000, new Watcher() {
            @Override
            public void process(WatchedEvent watchedEvent) {
                System.out.println("获取连接");
            }
        });
        zooKeeper.create("/demo2/provider",url.getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        System.out.println("注册成功");

    }
}
