package client.controllers;

import lipermi.handler.CallHandler;
import server.controllers.ManagerServerInterface;
import server.controllers.ServerRemote;
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
            CallHandler callHandler = new CallHandler();
            String remoteHost = "localhost";
            lipermi.net.Client client = new lipermi.net.Client(remoteHost, PORT_NUMBER, callHandler);
            si = (ManagerServerInterface) client.getGlobal(ManagerServerInterface.class);
            System.out.println("Client is connected to server");
        } catch (Exception e) {
            e.printStackTrace();
        }
        si.addEmployeeToStore(new Employee("Jimmy", new Address("street3", "city3", "state3", "zip3"), new Phone("phone3"), "jimmy", "111", ROLE.MANAGER));
        System.out.println(si.printEmployees());

    }
}
