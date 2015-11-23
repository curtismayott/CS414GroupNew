package server.communication;

import server.objects.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created by Jim on 11/22/2015.
 */
public class tst {


    public static void main(String[] args) throws FileNotFoundException {

        File file = new File("src\\test\\1.txt");
        Scanner sc = new Scanner(file);
        String temp = sc.nextLine();
        Order order = new Order();
        Person person = new Person();
        double points = 0;
        ArrayList<Topping> toppings = new ArrayList<>();
        ArrayList<Address> addy = new ArrayList<Address>();
        person.setAddresses(addy);
        double amountPaid;
        Pizza pizza = new Pizza();
        while (sc.hasNext()) {
            temp = sc.nextLine();
            System.out.println(temp);
            String[] line;
            if (temp.contains("amountPaid")) {
                amountPaid = Double.parseDouble(temp.replaceAll("<.*?>", "") + 0);
                order.setAmountPaid(amountPaid);
            }
            if (temp.contains("<com.android.cs414groupnewandroid.objects.Address")) {
                do {
                    line = new String[6];
                    line[0] = sc.nextLine();
                    String city = line[0].replaceAll("<.*?>", "") + "";
                    line[1] = sc.nextLine();
                    String state = line[1].replaceAll("<.*?>", "") + "";
                    line[2] = sc.nextLine();
                    String address = line[2].replaceAll("<.*?>", "") + "";
                    line[3] = sc.nextLine();
                    String zip = line[3].replaceAll("<.*?>", "") + "";
                    line[4] = sc.nextLine();
                    line[5] = sc.nextLine();
                    addy.add(new Address(address, city, state, zip));
                }while (line[5].contains("/addresses"));
            }
            if (temp.contains("<name>")){
                person.setName(temp.replaceAll("<.*?>", "") + "");
            }
            if (temp.contains("<com.android.cs414groupnewandroid.objects.Phone>")) {
                do {
                    line = new String[3];
                    line[0] = sc.nextLine();
                    line[1] = sc.nextLine();
                    line[2] = sc.nextLine();
                    Phone ph = new Phone(line[0]);
                }while (!line[2].contains("/phoneNumbers"));
            }
            if (temp.contains("<points>")){
                points = Double.parseDouble(temp.replaceAll("<.*?>", "") + "");
                person.setPoints(points);
            }
            if (temp.contains("isPaidFor")) {
                String isPaidFor = temp.replaceAll("<.*?>", "") + "";
                order.setIsPaidFor(isPaidFor.equals("true"));
            }
            if (temp.contains("orderID")){
                order.setOrderID(Integer.parseInt(temp.replaceAll("<.*?>", "") + ""));
            }
            if (temp.contains("<com.android.cs414groupnewandroid.objects.Pizza>")) {
                toppings = new ArrayList<>();
                line = new String[17];
                for (int i = 0; i < 16; i++) {
                    line[i] = sc.nextLine().replaceAll("<.*?>", "");
                    //System.out.println(line[i]);
                }
                pizza.setItemID(Integer.parseInt(line[0]));
                pizza.setPrice(Double.parseDouble(line[5] + ""));
                pizza.setSauce(new Sauce(line[9], line[7]));
                pizza.getSauce().setItemID(Integer.parseInt(line[13]));
                pizza.setSize(new PizzaSize(line[14], line[12], Double.parseDouble(line[15] + "")));
                if (temp.contains("<com.android.cs414groupnewandroid.objects.Topping>")) {
                    do {
                        line = new String[6];
                        for (int i = 0; i < 6; i++) {
                            line[i] = sc.nextLine().replaceAll("<.*?>", "");
                            //System.out.println(line[i]);
                        }
                        Topping top = new Topping(line[2], line[0]);
                        top.setItemID(Integer.parseInt(line[1]));
                        toppings.add(top);
                    } while (!line[5].contains("</com.android.cs414groupnewandroid.objects.Pizza>"));
                    pizza.setToppingList(toppings);
                }
            }
            if (temp.contains("<com.android.cs414groupnewandroid.objects.Drink>")){
                do {
                    line = new String[8];
                    for (int i = 0; i < 8; i++){
                        line[i] = sc.nextLine().replaceAll("<.*?>", "");
                        //System.out.println(line[i]);
                    }

                } while (!line[7].contains("</com.android.cs414groupnewandroid.objects.Drink>"));
            }
        }
    }
}
