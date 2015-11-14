package server.objects;

import java.io.Serializable;

/**
 * Created by darkbobo on 10/26/15.
 */
public class Side extends SideItem  implements Serializable {

    private static final long serialVersionUID = 6529685098267757690L;
    public Side(){
        super();
    }
    public Side(String name, double price){
        super(name, price);
    }
}
