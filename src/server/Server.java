package server;

import objects.Register;

import java.rmi.Naming;

/**
 * Created by darkbobo on 11/9/15.
 */
public class Server {
    public static void main(String args[]){
        try{
            //RegisterInterface stub = new Register();
            //Naming.rebind("rmi://localhost:5000/pizza", stub);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
