package com.zhanghp.service.impl;

import com.zhanghp.pojo.Person;
import com.zhanghp.service.MyPersonService;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: zhanghp
 * @version: 1.0
 */
public class MyPersonServieImpl extends UnicastRemoteObject implements MyPersonService {

    public  MyPersonServieImpl() throws RemoteException {
    }

    @Override
    public List<Person> findAll() throws RemoteException {
        List<Person> l = new ArrayList<>();
        l.add(new Person(1,"ss"));
        l.add(new Person(2,"zz"));
        return l;
    }
}
