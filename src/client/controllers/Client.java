package client.controllers;

import server.controllers.AndroidServerInterface;
import server.objects.Order;

import java.rmi.Naming;
import java.rmi.RemoteException;

/**
 * Created by Jim on 11/13/2015.
 */
public class Client {

    private static int PORT_NUMBER= 9678;

    public static void main(String args[]) throws RemoteException {
        AndroidServerInterface si = null;
        try {
            si = (AndroidServerInterface) Naming.lookup("rmi://localhost:" + PORT_NUMBER + "/server");
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(si.printString(new Order()));
    }
}
