package server.controllers;

import client.controllers.WindowManager;
import server.objects.Order;
import server.objects.Person;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * Created by Jim on 11/13/2015.
 */
public class ServerRemote extends UnicastRemoteObject implements ServerInterface, AndroidServerInterface{

    private WindowManager manager;

    protected ServerRemote() throws RemoteException {
        super();
        manager = new WindowManager();
    }

    @Override
    public boolean addNewOrder(Order order) throws RemoteException {
        System.out.println("Placeholder for add new order");
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
    public String printString(Order order) throws RemoteException {
        return "Working, created order";
    }

    @Override
    public String print() throws RemoteException {
        return "It Works!";
    }
}
