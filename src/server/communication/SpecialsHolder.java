package server.communication;

/**
 * Created by Jim on 11/22/2015.
 */
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;
import server.objects.PizzaSize;
import server.objects.Special;

import java.util.ArrayList;

/**
 * Created by Jim on 11/22/2015.
 */
@XStreamAlias("SPECIALSHOLDER")
public class SpecialsHolder {
    @XStreamImplicit(itemFieldName = "special")
    ArrayList<Special> s;

    public SpecialsHolder(ArrayList<Special> si) {
        this.s = si;
    }
}