package server.communication;

import com.thoughtworks.xstream.annotations.XStreamImplicit;
import server.objects.Sauce;

import java.util.ArrayList;

/**
 * Created by Jim on 11/22/2015.
 */
public class SaucesHolder {
    @XStreamImplicit(itemFieldName="sauces")
    ArrayList<Sauce> sauces;

    public SaucesHolder(ArrayList<Sauce> s){
        this.sauces = s;
    }
}
