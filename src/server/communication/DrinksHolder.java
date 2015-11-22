package server.communication;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;
import server.objects.Drink;
import server.objects.Sauce;

import java.util.ArrayList;

/**
 * Created by Jim on 11/22/2015.
 */
@XStreamAlias("DRINKSHOLDER")
public class DrinksHolder {
    @XStreamImplicit(itemFieldName = "drinks")
    ArrayList<Drink> sauces;

    public DrinksHolder(ArrayList<Drink> s) {
        this.sauces = s;
    }
}
