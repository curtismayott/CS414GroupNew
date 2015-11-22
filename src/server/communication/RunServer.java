package server.communication;

import com.sun.net.httpserver.HttpServer;
import server.controllers.WindowManager;
import server.objects.Register;

import java.io.IOException;
import java.net.InetSocketAddress;

public class RunServer {

    private static final int PORT_NUM = 7777;

    public static void main(String[] args) throws IOException {
        InetSocketAddress isa=new InetSocketAddress(PORT_NUM);
        HttpServer server=HttpServer.create(isa, 0);
        Register register = new Register();
        WindowManager wm = new WindowManager(register);


        ToppingPushController sc = new ToppingPushController(register);
        server.createContext("/toppings", sc);

        SaucePushController ic = new SaucePushController(register);
        server.createContext("/order", ic);

        SidePushController sp = new SidePushController(register);
        server.createContext("/sides", sp);

        SizePushController si = new SizePushController(register);
        server.createContext("/sizes", si);

        SpecialPushController su = new SpecialPushController(register);
        server.createContext("/specials", su);

        System.out.println("Server started..");
        server.start();
    }
}