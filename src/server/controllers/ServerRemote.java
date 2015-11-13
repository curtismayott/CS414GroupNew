package server.controllers;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * Created by Jim on 11/13/2015.
 */
public class ServerRemote extends UnicastRemoteObject implements ServerInterface{

    protected ServerRemote() throws RemoteException {
        super();
    }

    @Override
    public String print() throws RemoteException {
        return "It works!";
    }
}
