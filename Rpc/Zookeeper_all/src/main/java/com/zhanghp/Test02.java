package com.zhanghp;


import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

import java.util.List;

/**
 * @author: zhanghp
 * @version: 1.0
 */
public class Test02 {
    //这是一个main方法，程序的入口
    public static void main(String[] args) throws  Exception{
        ZooKeeper zooKeeper = new ZooKeeper("192.168.0.101", 10000000, new Watcher() {
            @Override
            public void process(WatchedEvent watchedEvent) {
                System.out.println("获取连接");
            }
        });
        List<String> l =  zooKeeper.getChildren("/demo",false);
        for (String s : l) {
            System.out.println(s);
            byte[] data = zooKeeper.getData("/demo/" + s, false, null);
            System.out.println(new String(data));
        }
    }
}
