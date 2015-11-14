package server.controllers;

import server.objects.Employee;
import server.objects.Order;
import server.objects.Person;
import server.objects.Register;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * Created by Jim on 11/13/2015.
 */
public class ServerRemote extends UnicastRemoteObject implements ServerInterface, AndroidServerInterface, ClientServerInterface{

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
    public boolean editCustomer(Person customer) throws RemoteException {
        return false;
    }

    @Override
    public String printString(Order order) throws RemoteException {
        return "Working, created order";
    }


    public String printEmp() throws RemoteException {
        String temp = "";
        for (Employee e : register.getEmployees()){
            temp += "Employee: " + e.getName() + '\n';
            temp += '\t' + "username: " + e.getUserID() + "   password: " + e.getAuthentication();
            temp += "\n\n";
        }
        return temp;
    }
}
