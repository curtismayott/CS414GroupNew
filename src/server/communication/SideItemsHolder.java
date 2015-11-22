package server.communication;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;
import server.objects.Sauce;
import server.objects.Side;
import server.objects.SideItem;

import java.util.ArrayList;

/**
 * Created by Jim on 11/22/2015.
 */
@XStreamAlias("SIDEITEMSHOLDER")
public class SideItemsHolder {
    @XStreamImplicit(itemFieldName = "sides")
    ArrayList<Side> side;

    public SideItemsHolder(ArrayList<Side> s) {
        this.side = s;
    }
}