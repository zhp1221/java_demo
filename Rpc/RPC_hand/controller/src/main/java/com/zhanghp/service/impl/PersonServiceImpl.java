package com.zhanghp.service.impl;

import com.zhanghp.pojo.Person;
import com.zhanghp.service.MyPersonService;
import com.zhanghp.service.PersonService;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.util.List;

/**
 * @author: zhanghp
 * @version: 1.0
 */
@Service
public class PersonServiceImpl implements PersonService {

    @Override
    public List<Person> show() {
        try {
            ZooKeeper zooKeeper = new ZooKeeper("192.168.0.101:2181", 10000000, new Watcher() {
                @Override
                public void process(WatchedEvent watchedEvent) {
                    System.out.println("获取连接");
                }
            });
            byte[] data = zooKeeper.getData("/demo2/provider", false, null);
            MyPersonService myPersonService = (MyPersonService) Naming.lookup(new String(data));
            return myPersonService.findAll();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (KeeperException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (NotBoundException e) {
            e.printStackTrace();
        }

        return null;
    }
}
