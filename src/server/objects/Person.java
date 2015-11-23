package server.objects;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import java.util.ArrayList;

/**
 * Created by clark on 10/7/15.
 */
@XStreamAlias("PERSON")
public class Person {
    @XStreamAlias("name")
    private String name;
    @XStreamAlias("addresses")
    private ArrayList<Address> addresses;
    @XStreamAlias("phonenumbers")
    private ArrayList<Phone> phoneNumbers;
    @XStreamAlias("points")
    double points;

    public Person(){
        phoneNumbers = new ArrayList<>();
        addresses = new ArrayList<>();
    }
    public Person(String name, Address address, Phone phone) {
        this.addresses = new ArrayList<Address>();
        this.phoneNumbers = new ArrayList<Phone>();
        this.name = name;
        this.addresses.add(address);
        this.phoneNumbers.add(phone);
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public ArrayList<Address> getAddresses() {
        return this.addresses;
    }

    public ArrayList<Phone> getPhoneNumbers() {
        return this.phoneNumbers;
    }

    public void setPhoneNumbers(ArrayList<Phone> phones){
        this.phoneNumbers = phones;
    }

    public Address getAddress(int index){
        return this.addresses.get(index);
    }

    public void addAddress(Address address) {
        if(this.addresses == null){
            this.addresses = new ArrayList<>();
        }
        this.addresses.add(address);
    }

    public void setAddresses(ArrayList<Address> addresses) {
        if(this.addresses == null){
            this.addresses = new ArrayList<>();
        }
        this.addresses = addresses;
    }

    public double getPoints() {
        return points;
    }

    public void setPoints(double points) {
        this.points = points;
    }

    public void addPhoneNumber(Phone p) {
        this.phoneNumbers.add(phoneNumbers.size() + 1, (p));
    }
}
