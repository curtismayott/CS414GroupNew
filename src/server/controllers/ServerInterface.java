package server.controllers;

import server.objects.*;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Created by Jim on 11/13/2015.
 */
public interface ServerInterface extends Remote{

    //test function. Prints list of all employees.
    public String printEmployees() throws RemoteException;

    //creates and returns model.Order that can be added to system after setting fields.
    public Order createNewOrder() throws RemoteException;

    //adds new order to PizzaSystem
    public boolean addNewOrder(Order order) throws RemoteException;

    //create and returns model.Customer that can be added to system after setting fields.
    public Person createNewCustomer() throws RemoteException;

    //adds new customer to PizzaSystem
    public boolean addNewCustomer(Person customer) throws RemoteException;

    //finds and returns customer profile
    public Person findCustomer(String name) throws RemoteException;

    //saves edited customer profile
    public boolean saveCustomerProfile(Person customer) throws RemoteException;
}
