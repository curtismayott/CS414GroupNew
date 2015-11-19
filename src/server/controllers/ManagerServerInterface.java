package server.controllers;

import server.objects.*;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Created by Jim on 11/14/2015.
 */
public interface ManagerServerInterface  extends Remote {

    //test function. Prints list of all employees.
    public String printEmployees() throws RemoteException;

    //test function. Prints menu.
    public String printMenu() throws RemoteException;

    //hires created employee
    public void addEmployeeToStore(Employee hire) throws RemoteException;

    //removes employee from store
    public void removeEmployee(Employee fire) throws RemoteException;

    //adds the given item to the menu
    public void addItemToMenu(Object item) throws RemoteException;

    //removes given item from menu
    public void removeItemFromMenu(Object item) throws RemoteException;

}
