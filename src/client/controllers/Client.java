package client.controllers;

import server.controllers.ManagerServerInterface;
import server.objects.*;

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
        si.addEmployeeToStore(new Employee("Jimmy", new Address("street3", "city3", "state3", "zip3"), new Phone("phone3"), "jimmy", "111", ROLE.MANAGER));
        System.out.println(si.printEmployees());
        si.addItemToMenu(new Side("Test", 11.99));
        System.out.println(si.printMenu());

    }
}
