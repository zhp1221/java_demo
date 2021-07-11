package com.zhanghp.service;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * @author: zhanghp
 * @version: 1.0
 */
public interface DemoService extends Remote {
    String demo(String demo) throws RemoteException;
}
