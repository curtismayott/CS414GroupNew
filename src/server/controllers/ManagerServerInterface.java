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

    //hires created employee
    public boolean addEmployeeToStore(Employee hire) throws RemoteException;

    //removes employee from store
    public boolean removeEmployee(Employee fire) throws RemoteException;

    //adds the given SideItem to the menu
    public boolean addSideItemToMenu(SideItem item) throws RemoteException;

    //removes SideItem from menu
    public boolean removeSideItemFromMEnu(SideItem item) throws RemoteException;

    //adds new PizzaSize to menu
    public boolean addNewPizzaSize(PizzaSize size) throws RemoteException;

    //removes PizzaSize from menu
    public boolean removePizzaSize(PizzaSize size) throws RemoteException;

    //adds new Topping to menu
    public boolean addNewTopping(Topping topping) throws RemoteException;

    //removes Topping from menu
    public boolean removeTopping(Topping topping) throws RemoteException;

    //adds new Sauce to menu
    public boolean addNewSauce(Sauce sauce) throws RemoteException;

    //removes Sauce from menu
    public boolean removeSauce(Sauce sauce) throws RemoteException;

    //adds new Drink to menu
    public boolean addNewDrink(Drink drink) throws RemoteException;

    //removes Drink from menu
    public boolean removeDrink(Drink drink) throws RemoteException;

}
