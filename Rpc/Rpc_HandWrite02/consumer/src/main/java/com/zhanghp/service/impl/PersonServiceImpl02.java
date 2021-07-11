package com.zhanghp.service.impl;

import com.zhanghp.pojo.Person;
import com.zhanghp.service.PersonService;
import com.zhanghp.service.PersonService02;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.util.List;


/**
 * @author: zhanghp
 * @version: 1.0
 */
@Service
public class PersonServiceImpl02 implements PersonService02 {

    @Override
    public List<Person> show() {
        try {
            ZooKeeper zooKeeper = new ZooKeeper("192.168.0.101:2181", 100000, new Watcher() {
                @Override
                public void process(WatchedEvent watchedEvent) {
                    System.out.println("获取连接");
                }
            });
            byte[] data = zooKeeper.getData("/demo/rpc", false, null);
            PersonService personService = (PersonService)Naming.lookup(new String(data));
            return personService.findAll();
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
