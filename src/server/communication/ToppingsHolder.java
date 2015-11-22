package server.communication;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;
import server.objects.Topping;

import java.util.ArrayList;

/**
 * Created by Jim on 11/22/2015.
 */
@XStreamAlias("TOPPINGHOLDER")
public class ToppingsHolder {
    @XStreamImplicit(itemFieldName="toppings")
    ArrayList<Topping> toppings;

    public ToppingsHolder(ArrayList<Topping> t){
        this.toppings = t;
    }
}
