package com.zhanghp;

import org.apache.zookeeper.*;

import java.io.IOException;

/**
 * @author: zhanghp
 * @version: 1.0
 */
public class test01 {
    public static void main(String [] args){
        try {
            ZooKeeper zookeeper = new ZooKeeper("192.168.0.101:2181", 1000000000, new Watcher() {
                @Override
                public void process(WatchedEvent watchedEvent) {
                    System.out.println("获取连接");
                }
            });
            String content = zookeeper.create("/demo/nn", "rmi:localhost:8090/demoService".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT_SEQUENTIAL);
            System.out.println("content"+content);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (KeeperException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
