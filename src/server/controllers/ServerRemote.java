package server.controllers;

import server.objects.Employee;
import server.objects.Order;
import server.objects.Person;
import server.objects.Register;

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
    public Person createNewCustomer() throws RemoteException {
        return null;
    }

    @Override
    public boolean addNewCustomer(Person customer) throws RemoteException {
        return false;
    }

    @Override
    public Person findCustomer(String name) throws RemoteException {
        return null;
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
    public Order createNewOrder() throws RemoteException {
        return null;
    }

    @Override
    public Employee createNewEmployee() throws RemoteException {
        return null;
    }

    @Override
    public boolean addEmployeeToStore(Employee hire) throws RemoteException {
        return false;
    }
}
