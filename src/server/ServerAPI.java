package server;

import objects.Register;

import java.rmi.Naming;
import java.rmi.Remote;

public interface ServerAPI extends Remote {

}


/*  Old main call
    public static void main(String args[]){
        try{
            //RegisterInterface stub = new Register();
            //Naming.rebind("rmi://localhost:5000/pizza", stub);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
 */