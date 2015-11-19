package server.controllers;

import lipermi.handler.CallHandler;
import lipermi.net.IServerListener;
import lipermi.net.Server;
import server.objects.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * Created by Jim on 11/13/2015.
 */
public class RegServer {

    private final int PORT_NUM = 8080;

    private static ServerSocket serverSocket;
    private static Socket clientSocket;
    private static InputStreamReader inputStreamReader;
    private static BufferedReader bufferedReader;
    private static String message;
    private WindowManager wm;
    private static Register register;

    public RegServer() throws RemoteException {
        register = new Register();
        wm = new WindowManager(register);
        try {
            serverSocket = new ServerSocket(PORT_NUM); // Server socket

        } catch (IOException e) {
            System.out.println("Could not listen on port: " + PORT_NUM);
        }
        register.setWindowManager(wm);
        System.out.println("Server started. Listening to the port " + PORT_NUM);

        while (true) {
            try {

                clientSocket = serverSocket.accept(); // accept the client connection
                inputStreamReader = new InputStreamReader(clientSocket.getInputStream());
                bufferedReader = new BufferedReader(inputStreamReader); // get the client message
                message = bufferedReader.readLine();

                System.out.println(message);
                inputStreamReader.close();
                clientSocket.close();

            } catch (IOException ex) {
                System.out.println("Problem in message reading");
            }
        }
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
