package server.communication;

import com.sun.javafx.css.converters.BooleanConverter;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import server.objects.*;

import java.io.IOException;
import java.io.OutputStream;
import java.net.URI;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Jim on 11/22/2015.
 */
public class InOrderController implements HttpHandler {
    Register model;

    public InOrderController(Register register) {
        this.model = register;
    }

    @Override
    public void handle(HttpExchange exchange){
        URI uri = exchange.getRequestURI();
        String in = uri.getQuery();
        if (in != null) {
            parseOrder(in);
        }
        String response = "Order Received.";
        try {
            exchange.sendResponseHeaders(200, response.length());
            OutputStream os = exchange.getResponseBody();
            os.write(response.getBytes());
            os.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void parseOrder(String in) {
        Scanner sc = new Scanner(in);
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
            String[] line;
            if (temp.contains("amountPaid")) {
                amountPaid = Double.parseDouble(temp.replaceAll("<.*?>", "").replaceAll("\\+", "") + 0);
                order.setAmountPaid(amountPaid);
            }
            if (temp.contains("<com.android.cs414groupnewandroid.objects.Address")) {
                do {
                    line = new String[6];
                    line[0] = sc.nextLine();
                    String city = line[0].replaceAll("<.*?>", "").replaceAll("\\+", "") + "";
                    line[1] = sc.nextLine();
                    String state = line[1].replaceAll("<.*?>", "").replaceAll("\\+", "") + "";
                    line[2] = sc.nextLine();
                    String address = line[2].replaceAll("<.*?>", "").replaceAll("\\+", "") + "";
                    line[3] = sc.nextLine();
                    String zip = line[3].replaceAll("<.*?>", "").replaceAll("\\+", "") + "";
                    line[4] = sc.nextLine();
                    line[5] = sc.nextLine();
                    addy.add(new Address(address, city, state, zip));
                }while (!line[5].contains("/addresses"));
            }
            if (temp.contains("<name>")){
                person.setName(temp.replaceAll("<.*?>", "").replaceAll("\\+", "") + "");
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
                points = Double.parseDouble(temp.replaceAll("<.*?>", "").replaceAll("\\+", "") + "");
                person.setPoints(points);
            }
            if (temp.contains("isPaidFor")) {
                String isPaidFor = temp.replaceAll("<.*?>", "").replaceAll("\\+", "") + "";
                order.setIsPaidFor(isPaidFor.equals("true"));
            }
            if (temp.contains("orderID")){
                order.setOrderID(Integer.parseInt(temp.replaceAll("<.*?>", "").replaceAll("\\+", "") + ""));
            }
            if (temp.contains("<com.android.cs414groupnewandroid.objects.Pizza>")) {
                toppings = new ArrayList<>();
                line = new String[20];
                for (int i = 0; i < 20; i++) {
                    line[i] = sc.nextLine();//.replaceAll("<.*?>", "");
                    //System.out.println(line[i]);
                }
                pizza.setItemID(Integer.parseInt(line[0].replaceAll("<.*?>", "").replaceAll("\\+", "")));
                pizza.setPrice(Double.parseDouble(line[5].replaceAll("<.*?>", "").replaceAll("\\+", "")));
                pizza.setSauce(new Sauce(line[9].replaceAll("<.*?>", "").replaceAll("\\+", "").replaceAll("\\+", ""), line[7].replaceAll("<.*?>", "").replaceAll("\\+", "")));
                pizza.getSauce().setItemID(Integer.parseInt(line[13].replaceAll("<.*?>", "").replaceAll("\\+", "")));
                pizza.setSize(new PizzaSize(line[14].replaceAll("<.*?>", "").replaceAll("\\+", ""), line[12].replaceAll("<.*?>", "").replaceAll("\\+", ""), Double.parseDouble(line[15].replaceAll("<.*?>", "").replaceAll("\\+", ""))));
                if (line[19].contains("<com.android.cs414groupnewandroid.objects.Topping>")) {
                    do {
                        line = new String[6];
                        for (int i = 0; i < 6; i++) {
                            line[i] = sc.nextLine();
                        }
                        Topping top = new Topping(line[2].replaceAll("<.*?>", "").replaceAll("\\+", ""), line[0].replaceAll("<.*?>", "").replaceAll("\\+", ""));
                        top.setItemID(Integer.parseInt(line[1].replaceAll("<.*?>", "").replaceAll("\\+", "")));
                        toppings.add(top);
                    } while (!line[5].contains("</com.android.cs414groupnewandroid.objects.Pizza>"));
                    pizza.setToppingList(toppings);
                }
            }
            if (temp.contains("<com.android.cs414groupnewandroid.objects.Drink>")){
                do {
                    line = new String[8];
                    for (int i = 0; i < 8; i++) {
                        line[i] = sc.nextLine();
                    }
                    Drink drink = new Drink(line[6].replaceAll("<.*?>", "").replaceAll("\\+", "") + " ", Double.parseDouble(line[7].replaceAll("<.*?>", "").replaceAll("\\+", "") + 0));
                    order.addSide(drink);
                } while (!line[7].contains("</com.android.cs414groupnewandroid.objects.Drink>"));
            }
            if (temp.contains("<com.android.cs414groupnewandroid.objects.Side>")){
                do {
                    line = new String[8];
                    for (int i = 0; i < 8; i++){
                        line[i] = sc.nextLine();
                    }
                    Side side = new Side(line[6].replaceAll("<.*?>", "").replaceAll("\\+", "") + " ", Double.parseDouble(line[7].replaceAll("<.*?>", "").replaceAll("\\+", "") + 0));
                    order.addSide(side);
                } while (!line[7].contains("</com.android.cs414groupnewandroid.objects.Side>"));
            }
        }
        model.addOrder(order);
        System.out.println("Order added");
    }
}

