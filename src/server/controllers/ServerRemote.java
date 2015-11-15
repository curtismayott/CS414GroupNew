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

    public ServerRemote() throws RemoteException {
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
    public void addNewOrder(Order order) throws RemoteException {
        System.out.println("Placeholder for add new order");
    }

    @Override
    public void addNewCustomer(Person customer) throws RemoteException {
    }

    @Override
    public void saveCustomerProfile(Person customer) throws RemoteException {
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
    public String printMenu() throws RemoteException {
        String temp = '\n' + "---SIZES---" + '\n';
        int i = 0;
        for (PizzaSize ps : register.getCatalog().getSizes()){
            temp += ps.getFullName() + "    Price: " + ps.getPrice() + '\n';
        }
        temp += '\n' + "---SAUCES---" + '\n';
        for (Sauce s : register.getCatalog().getSauces()){
            i++;
            if (i % 3 == 0){
                temp += '\n';
            }
            temp += s.getFullName() + '\t';
        }
        temp += '\n' + "---TOPPINGS---" + '\n';
        i = 0;
        for (Topping pt : register.getCatalog().getToppings()){
            i++;
            if (i % 3 == 0){
                temp += '\n';
            }
            temp += "<" + pt.getFullName() + ">" + '\t';
        }
        temp += '\n' + "---SIDES---" + '\n';
        for (Side si : register.getCatalog().getSides()){
            temp += si.getName() + "    Price: " + si.getPrice() + '\n';
        }
        return temp;
    }

    @Override
    public void addEmployeeToStore(Employee hire) throws RemoteException {
        register.addEmployee(hire);
    }

    @Override
    public void removeEmployee(Employee fire) throws RemoteException {
        register.removeEmployee(fire);
    }

    @Override
    public void addItemToMenu(Object item){
        register.getCatalog().addItem(item);
    }

    @Override
    public void removeItemFromMenu(Object item){
        register.getCatalog().deleteItem(item);
    }
}
