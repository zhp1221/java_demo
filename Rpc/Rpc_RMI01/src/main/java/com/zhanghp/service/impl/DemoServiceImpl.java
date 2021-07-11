package com.zhanghp.service.impl;

import com.zhanghp.service.DemoService;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * @author: zhanghp
 * @version: 1.0
 */
public class DemoServiceImpl extends UnicastRemoteObject implements DemoService {

    public DemoServiceImpl() throws RemoteException {
    }

    @Override
    public String demo(String demo) throws RemoteException {

        return demo+"123";
    }
}
