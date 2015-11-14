package server.objects;

import java.io.Serializable;

/**
 * Created by darkbobo on 10/26/15.
 */
public class SideItem extends OrderItem  implements Serializable {

    private static final long serialVersionUID = 6529685098267757690L;
    int itemID;
    String name;

    public SideItem(){
        super();
    }
    public SideItem(String name, double price){
        super(price);
        this.name = name;
    }

    @Override
    public String toString(){
        return getName() + "   " + getPrice();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getItemID() {
        return itemID;
    }

    public void setItemID(int itemID) {
        this.itemID = itemID;
    }
}
