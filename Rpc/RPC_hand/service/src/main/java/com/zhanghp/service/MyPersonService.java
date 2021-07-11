package com.zhanghp.service;

import com.zhanghp.pojo.Person;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 * @author: zhanghp
 * @version: 1.0
 */
public interface MyPersonService extends Remote {
    public List<Person> findAll() throws RemoteException;
}
