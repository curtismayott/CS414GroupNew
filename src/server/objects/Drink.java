package server.objects;

import java.io.Serializable;

/**
 * Created by darkbobo on 10/26/15.
 */
public class Drink extends SideItem{
    public Drink(){
        super();
    }
    public Drink(String name, double price){
        super(name, price);
    }
}
