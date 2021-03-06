package server.objects;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import java.io.Serializable;

/**
 * Created by darkbobo on 11/17/15.
 */
@XStreamAlias("SPECIAL")
public class Special {
    @XStreamAlias("specialid")
    int specialID;
    @XStreamAlias("itemtype")
    String itemType;
    @XStreamAlias("name")
    String name;
    @XStreamAlias("size")
    PizzaSize size;
    @XStreamAlias("sideitem")
    SideItem sideItem;
    @XStreamAlias("numtoppings")
    int numToppings;
    @XStreamAlias("discountedprice")
    double discountedPrice;

    public Special(){
        specialID = 0;
        this.discountedPrice = 0;
        itemType = null;
        name = null;
        size = null;
        sideItem = null;
        this.numToppings = 0;
    }

    public Special(PizzaSize size, int numToppings, double discountedPrice) {
        specialID = -1;
        name = null;
        itemType = null;
        this.size = size;
        sideItem = null;
        this.numToppings = numToppings;
        this.discountedPrice = discountedPrice;
    }

    @Override
    public String toString(){
        StringBuilder builder = new StringBuilder();
        builder.setLength(0);
        builder.append(getItemType()).append(" ");
        builder.append(getName()).append(" ");
        if(size != null){
            builder.append(getSize().getFullName()).append(" ");
        }
        if(sideItem != null){
            builder.append(getSideItem().getName()).append(" ");
        }
        if(numToppings != 0) {
            builder.append(numToppings).append(" ");
        }
        builder.append(getDiscountedPrice());
        return builder.toString();
    }

    public int getSpecialID() {
        return specialID;
    }

    public void setSpecialID(int specialID) {
        this.specialID = specialID;
    }

    public PizzaSize getSize() {
        return size;
    }

    public void setSize(PizzaSize size) {
        this.size = size;
    }

    public int getNumToppings() {
        return numToppings;
    }

    public void setNumToppings(int numToppings) {
        this.numToppings = numToppings;
    }

    public double getDiscountedPrice() {
        return discountedPrice;
    }

    public void setDiscountedPrice(double discountedPrice) {
        this.discountedPrice = discountedPrice;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public SideItem getSideItem() {
        return sideItem;
    }

    public void setSideItem(SideItem sideItem) {
        this.sideItem = sideItem;
    }
}
