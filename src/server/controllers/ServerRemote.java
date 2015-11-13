package server.controllers;

import server.objects.Order;
import server.objects.Person;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * Created by Jim on 11/13/2015.
 */
public class ServerRemote extends UnicastRemoteObject implements ServerInterface, AndroidServerInterface{

    protected ServerRemote() throws RemoteException {
        super();
    }

    @Override
    public boolean addNewOrder(Order order) throws RemoteException {
        return false;
    }

    @Override
    public boolean addNewCustomer(Person customer) throws RemoteException {
        return false;
    }

    @Override
    public boolean editCustomer(Person customer) throws RemoteException {
        return false;
    }

    @Override
    public String print() throws RemoteException {
        return "It Works!";
    }
}
