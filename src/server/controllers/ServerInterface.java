package server.controllers;

import server.objects.*;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Created by Jim on 11/13/2015.
 */
public interface ServerInterface{

    //test method to print off orders
    public String printOrders();

    //adds new order to PizzaSystem
    public void addNewOrder(Order order);

    //adds new customer to PizzaSystem
    public void addNewCustomer(Person customer);

    //saves edited customer profile
    public void saveCustomerProfile(Person customer);
}
