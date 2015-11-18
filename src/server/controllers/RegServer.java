package server.controllers;

import lipermi.exception.LipeRMIException;
import lipermi.handler.CallHandler;
import lipermi.net.IServerListener;
import lipermi.net.Server;
import server.objects.*;

import java.io.IOException;
import java.net.Socket;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * Created by Jim on 11/13/2015.
 */
public class RegServer extends UnicastRemoteObject implements ServerInterface {

    private WindowManager wm;
    private static Register register;

    public RegServer() throws RemoteException {
        try {
            register = new Register();
            wm = new WindowManager(register);
            CallHandler ch = new CallHandler();
            ch.registerGlobal(ServerInterface.class, this);
            Server server = new Server();
            server.bind(7777, ch);
            server.addServerListener(new IServerListener() {
                @Override
                public void clientConnected(Socket socket) {
                    System.out.println("Client Disconnected: " + socket.getInetAddress());
                }

                @Override
                public void clientDisconnected(Socket socket) {
                    System.out.println("Client Connected: " + socket.getInetAddress());
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
        register.setWindowManager(wm);
        System.out.println("Server Listening");
    }

    @Override
    public String printOrders() {
        String temp = "";
        for (Order o : register.getOrders()){
            temp += "Order: " + o.getOrderID() + '\t' + "Price: " + o.getAmountDue();
        }
        return temp;
    }

    @Override
    public void addNewOrder(Order order) {
        System.out.println("Placeholder for add new order");
    }

    @Override
    public void addNewCustomer(Person customer) {
    }

    @Override
    public void saveCustomerProfile(Person customer) {
    }

    public String printMenu(){
        String temp = '\n' + "---SIZES---" + '\n';
        int i = 0;
        for (PizzaSize ps : register.getCatalog().getSizes()){
            temp += ps.getFullName() + "    Price: " + ps.getPrice() + '\n';
        }
        temp += '\n' + "---SAUCES---" + '\n';
        for (Sauce s : register.getCatalog().getSauces()){
            i++;
            if (i % 3 == 0){
                temp += '\n';
            }
            temp += s.getFullName() + '\t';
        }
        temp += '\n' + "---TOPPINGS---" + '\n';
        i = 0;
        for (Topping pt : register.getCatalog().getToppings()){
            i++;
            if (i % 3 == 0){
                temp += '\n';
            }
            temp += "<" + pt.getFullName() + ">" + '\t';
        }
        temp += '\n' + "---SIDES---" + '\n';
        for (Side si : register.getCatalog().getSides()){
            temp += si.getName() + "    Price: " + si.getPrice() + '\n';
        }
        return temp;
    }
}
