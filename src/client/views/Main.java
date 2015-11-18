package client.views;

import server.controllers.RegServer;

import java.rmi.RemoteException;

/**
 * Created by darkbobo on 9/28/15.
 */
public class Main {

    private static final int PORT_NUM = 7777;

    public static void main(String[] args) throws RemoteException {
        RegServer ser = new RegServer();
    }
}
