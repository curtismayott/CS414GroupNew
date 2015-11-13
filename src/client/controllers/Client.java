package client.controllers;

import server.controllers.ServerInterface;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * Created by Jim on 11/13/2015.
 */
public class Client {

    private static int PORT_NUMBER= 9678;

    public static void main(String args[]){
        try {
            ServerInterface si = (ServerInterface)Naming.lookup("rmi://localhost:" + PORT_NUMBER + "/server");
            System.out.println(si.print());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
