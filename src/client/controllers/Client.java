package client.controllers;

import server.controllers.AndroidServerInterface;
import server.objects.Order;

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
        AndroidServerInterface si = null;
        try {
            si = (AndroidServerInterface) Naming.lookup("rmi://localhost:" + PORT_NUMBER + "/server");
            System.out.println("Client is connected to server");
        } catch (Exception e) {
            e.printStackTrace();
        }
        si.addNewOrder(new Order());
    }
}
