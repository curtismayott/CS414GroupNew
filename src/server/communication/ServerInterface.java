package server.communication;

import server.objects.*;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Created by Jim on 11/13/2015.
 */
public interface ServerInterface extends Remote{

    //test method to print off orders
    public String printOrders() throws RemoteException ;

    //adds new order to PizzaSystem
    public void addNewOrder(Order order) throws RemoteException;

    //adds new customer to PizzaSystem
    public void addNewCustomer(Person customer) throws RemoteException;

    //saves edited customer profile
    public void saveCustomerProfile(Person customer) throws RemoteException;
}