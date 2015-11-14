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

    private int PORT_NUMBER;

    public Server(int port){
        this.PORT_NUMBER = port;
    }

    public Server(){
        this.PORT_NUMBER = 8878;
    }

    public void runServer() throws RemoteException {
        try {
            LocateRegistry.createRegistry(PORT_NUMBER);
            ServerRemote sr = new ServerRemote();
            Naming.rebind("rmi://localhost:" + PORT_NUMBER + "/server", sr);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Server is running");
    }
}
