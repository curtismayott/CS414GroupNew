package server.controllers;

import server.objects.Order;
import server.objects.Person;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Created by Jim on 11/13/2015.
 */
public interface AndroidServerInterface extends Remote{

    public boolean addNewOrder(Order order) throws RemoteException;
    public boolean addNewCustomer(Person customer) throws RemoteException;
    public boolean editCustomer(Person customer) throws RemoteException;
}
