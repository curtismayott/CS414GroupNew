package server.controllers;

import server.objects.*;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Created by Jim on 11/14/2015.
 */
public interface ManagerServerInterface{

    //test function. Prints list of all employees.
    public String printEmployees();

    //test function. Prints menu.
    public String printMenu();

    //hires created employee
    public void addEmployeeToStore(Employee hire);

    //removes employee from store
    public void removeEmployee(Employee fire);

    //adds the given item to the menu
    public void addItemToMenu(Object item);

    //removes given item from menu
    public void removeItemFromMenu(Object item);

}
