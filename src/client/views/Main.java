package client.views;

import client.controllers.Client;
import server.controllers.MyServer;
import server.controllers.WindowManager;

/**
 * Created by darkbobo on 9/28/15.
 */
public class Main {

    public static void main(String[] args){

        MyServer server = new MyServer();
        Client client = new Client();
        WindowManager manager = new WindowManager();

    }
}
