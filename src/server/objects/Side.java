package server.objects;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import java.io.Serializable;

/**
 * Created by darkbobo on 10/26/15.
 */
@XStreamAlias("SIDE")
public class Side extends SideItem {

    public Side(){
        super();
    }
    public Side(String name, double price){
        super(name, price);
    }
}
