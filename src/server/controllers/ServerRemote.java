package server.controllers;

import server.objects.*;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * Created by Jim on 11/13/2015.
 */
public class ServerRemote extends UnicastRemoteObject implements ServerInterface, ManagerServerInterface, Remote {

    private WindowManager wm;
    private Register register;

    protected ServerRemote() throws RemoteException {
        super();
        try {
            register = new Register();
            wm = new WindowManager(register);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        register.setWindowManager(wm);
    }

    @Override
    public boolean addNewOrder(Order order) throws RemoteException {
        System.out.println("Placeholder for add new order");
        return true;
    }

    @Override
    public boolean addNewCustomer(Person customer) throws RemoteException {
        return false;
    }

    @Override
    public boolean saveCustomerProfile(Person customer) throws RemoteException {
        return false;
    }

    @Override
    public String printEmployees() throws RemoteException {
        String temp = "";
        for (Employee e : register.getEmployees()){
            temp += "Employee: " + e.getName() + '\n';
            temp += '\t' + "username: " + e.getUserID() + "   password: " + e.getAuthentication();
            temp += "\n\n";
        }
        return temp;
    }

    @Override
    public boolean addEmployeeToStore(Employee hire) throws RemoteException {
        if (!register.getEmployees().contains(hire)){
            register.addEmployee(hire);
            return true;
        }
        return false;

    }

    @Override
    public boolean removeEmployee(Employee fire) throws RemoteException {
        if (register.getEmployees().contains(fire)){
            register.removeEmployee(fire);
            return true;
        }
        return false;
    }

    @Override
    public boolean addSideItemToMenu(SideItem item) throws RemoteException {
        return false;
    }

    @Override
    public boolean removeSideItemFromMEnu(SideItem item) throws RemoteException {
        return false;
    }

    @Override
    public boolean addNewPizzaSize(PizzaSize size) throws RemoteException {
        return false;
    }

    @Override
    public boolean removePizzaSize(PizzaSize size) throws RemoteException {
        return false;
    }

    @Override
    public boolean addNewTopping(Topping topping) throws RemoteException {
        return false;
    }

    @Override
    public boolean removeTopping(Topping topping) throws RemoteException {
        return false;
    }

    @Override
    public boolean addNewSauce(Sauce sauce) throws RemoteException {
        return false;
    }

    @Override
    public boolean removeSauce(Sauce sauce) throws RemoteException {
        return false;
    }

    @Override
    public boolean addNewDrink(Drink drink) throws RemoteException {
        return false;
    }

    @Override
    public boolean removeDrink(Drink drink) throws RemoteException {
        return false;
    }
}
