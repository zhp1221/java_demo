package com.zhanghp.service.impl;

import com.zhanghp.pojo.Person;
import com.zhanghp.service.PersonService;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: zhanghp
 * @version: 1.0
 */
public class PersonServiceImpl extends UnicastRemoteObject implements PersonService {

    public PersonServiceImpl() throws RemoteException {
    }

    @Override
    public List<Person> findAll() throws RemoteException {
        List<Person> list = new ArrayList<>();
        list.add(new Person(1, "zhangsan"));
        list.add(new Person(2, "lisi"));
        return list;
    }

}
