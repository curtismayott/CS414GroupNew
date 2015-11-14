package client.views;

import client.controllers.Client;
import client.controllers.WindowManager;
import server.controllers.Server;

import java.rmi.RemoteException;

/**
 * Created by darkbobo on 9/28/15.
 */
public class Main {

    private static final int PORT_NUM = 9587;

    public static void main(String[] args) throws RemoteException {
        Server ser = new Server(PORT_NUM);
        ser.runServer();
        /*
        Disabling while client/server is still tied together.

        Client client = new Client(PORT_NUM);
        client.runClient();
        */
    }
}
