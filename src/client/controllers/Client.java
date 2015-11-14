package client.controllers;

import server.controllers.ManagerServerInterface;
import server.objects.Address;
import server.objects.Employee;
import server.objects.Phone;
import server.objects.ROLE;

import java.rmi.Naming;
import java.rmi.RemoteException;

/**
 * Created by Jim on 11/13/2015.
 */
public class Client {

    private int PORT_NUMBER;

    public Client(int port){
        this.PORT_NUMBER = port;
    }

    public Client(){
        this.PORT_NUMBER = 8878;
    }


    public void runClient() throws RemoteException {
        ManagerServerInterface si = null;
        try {
            si = (ManagerServerInterface) Naming.lookup("rmi://localhost:" + PORT_NUMBER + "/server");
            System.out.println("Client is connected to server");
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (si != null){
            si.addEmployeeToStore(new Employee("Jimmy", new Address("street3", "city3", "state3", "zip3"), new Phone("phone3"), "jimmy", "111", ROLE.MANAGER));
        }
        System.out.println("Employees: " + '\n' + si.printEmployees());

    }
}
