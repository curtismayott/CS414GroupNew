package server.communication;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;
import server.objects.PizzaSize;
import server.objects.Sauce;

import java.util.ArrayList;

/**
 * Created by Jim on 11/22/2015.
 */
@XStreamAlias("PIZZASIZESHOLDER")
public class PizzaSizesHolder {
    @XStreamImplicit(itemFieldName = "sizes")
    ArrayList<PizzaSize> s;

    public PizzaSizesHolder(ArrayList<PizzaSize> si) {
        this.s = si;
    }
}