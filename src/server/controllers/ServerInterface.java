package server.controllers;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Created by Jim on 11/13/2015.
 */
public interface ServerInterface extends Remote {
    public String print() throws RemoteException;
}
