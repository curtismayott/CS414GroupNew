package server.controllers;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * Created by Jim on 11/13/2015.
 */
public class Server {

    private static int PORT_NUMBER= 9678;

    public static void main(String args[]) throws RemoteException {
        try {
            LocateRegistry.createRegistry(PORT_NUMBER);
            ServerRemote sr = new ServerRemote();
            /*
            Registry reg = LocateRegistry.getRegistry(PORT_NUMBER);
            reg.rebind("rmi://localhost:" + PORT_NUMBER + "/server", sr);
            */
            Naming.rebind("rmi://localhost:" + PORT_NUMBER + "/server", sr);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Server is running");
    }
}
