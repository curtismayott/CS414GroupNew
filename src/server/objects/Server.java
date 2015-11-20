package server.objects;

import server.controllers.ManagerServerInterface;
import server.controllers.ServerInterface;
import server.controllers.ServerRemote;

import java.rmi.Naming;
import java.rmi.RemoteException;

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
            System.out.println("Server is running");
    }
}