package server.controllers;

import server.objects.Employee;
import server.objects.Person;

import java.rmi.RemoteException;

/**
 * Created by Jim on 11/14/2015.
 */
public interface ManagerServerInterface {

    //creates model.Employee to display, edit, and eventually save
    public Employee createNewEmployee() throws RemoteException;

    //hires created employee
    public boolean addEmployeeToStore(Employee hire) throws RemoteException;


}
