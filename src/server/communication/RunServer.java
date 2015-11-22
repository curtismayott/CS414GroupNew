package server.communication;

import com.sun.net.httpserver.HttpServer;
import server.controllers.WindowManager;
import server.objects.Register;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.concurrent.ThreadPoolExecutor;

public class RunServer {

    private static final int PORT_NUM = 7777;

    public static void main(String[] args) throws IOException {
        InetSocketAddress isa=new InetSocketAddress(PORT_NUM);
        HttpServer server= HttpServer.create(isa, 0);
        Register register = new Register();
        WindowManager wm = new WindowManager(register);

        ToppingPushController sc = new ToppingPushController(register);
        server.createContext("/menu/toppings/", sc);

        InOrderController ic = new InOrderController(register);
        server.createContext("/order/in/", ic);

        SidePushController sp = new SidePushController(register);
        server.createContext("/menu/sides/", sp);

        SaucePushController sa = new SaucePushController(register);
        server.createContext("/menu/sauces/", sa);

        SizePushController si = new SizePushController(register);
        server.createContext("/menu/sizes/", si);

        SpecialPushController su = new SpecialPushController(register);
        server.createContext("/menu/specials/", su);

        DrinkPushController dr = new DrinkPushController(register);
        server.createContext("/menu/drinks/", dr);

        System.out.println("Server started..");
        server.start();
    }
}