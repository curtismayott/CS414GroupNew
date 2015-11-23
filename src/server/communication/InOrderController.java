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
    public void handle(HttpExchange exchange) throws IOException {
        URI uri = exchange.getRequestURI();
        String in = uri.getQuery();
        if (in != null) {
            parseOrder(in);
        }
        String response = "Order Received.";
        exchange.sendResponseHeaders(200, response.length());
        OutputStream os = exchange.getResponseBody();
        os.write(response.getBytes());
        os.close();
    }

    private void parseOrder(String in) {
        Scanner sc = new Scanner(in);
        //System.out.println(in);
        String temp;
        ArrayList<Drink> drink = new ArrayList<>();
        ArrayList<Address> add = new ArrayList<>();
        ArrayList<Phone> phones = new ArrayList<>();
        ArrayList<Topping> tops = new ArrayList<>();
        Order order = new Order();
        double points;
        Sauce sauce;
        String fullSizeName = "";
        String customerName = "";
        Sauce tempSauce;
        double itemPrice;
        PizzaSize ps = null;
        while (sc.hasNextLine()) {
            temp = sc.nextLine();
            while (!temp.contains("objects.Address")) {
                if (temp.contains("city")) {
                    temp = temp.replaceAll("\\+", "");
                    temp = temp.replaceAll("<.*?>", "");
                    System.out.println(temp);
                    temp = temp.replaceAll("<.*?>", "");
                    String city = temp;
                    temp = sc.nextLine().trim().replaceAll("<.*?>", "");
                    String state = temp;
                    temp = sc.nextLine().trim().replaceAll("<.*?>", "");
                    String streetAddress = temp;
                    temp = sc.nextLine().trim().replaceAll("<.*?>", "");
                    String zipcode = temp;
                    add.add(new Address(streetAddress, city, state, zipcode));
                }
                temp = sc.nextLine();
            }/*
            if (temp.contains("name")) {
                temp = temp.trim().replaceAll("<.*?>", "");
                customerName = temp;
                temp = sc.nextLine();
                temp = sc.nextLine();
                temp = sc.nextLine();
            }
            if (temp.contains("number")) {
                temp = temp.trim().replaceAll("<.*?>", "");
                String number = temp;
                Phone p = new Phone(number);
                phones.add(p);
                Person person = new Person();
                person.setName(customerName);
                person.setAddresses(add);
                person.addPhoneNumber(p);
                temp = sc.nextLine();
                temp = sc.nextLine();
                temp = sc.nextLine();
                points = Double.parseDouble(temp.trim().replaceAll("<.*?>", ""));
            }
            temp = sc.nextLine();
            temp = sc.nextLine();
            if (temp.contains("isPaidFor")) {
                String paidFor = temp.trim().replaceAll("<.*?>", "");
                temp = sc.nextLine();
            }
            if (temp.contains("orderID")) {
                int orderID = Integer.parseInt(temp.trim().replaceAll("<.*?>", ""));
                temp = sc.nextLine();
                String orderType = temp.trim().replaceAll("<.*?>", "");
                temp = sc.nextLine();
                temp = sc.nextLine();
                temp = sc.nextLine();
            }
            while (!temp.contains("pizzas")) {
                if (temp.contains("itemID")) {
                    int itemID = Integer.parseInt(temp.trim().replaceAll("<.*?>", ""));
                    temp = sc.nextLine();
                    temp = sc.nextLine();
                    temp = sc.nextLine();
                    temp = sc.nextLine();
                    temp = sc.nextLine();
                    double pizPrice = Double.parseDouble(temp.trim().replaceAll("<.*?>", ""));
                    temp = sc.nextLine();
                    temp = sc.nextLine();
                    String sauceFull = temp.trim().replaceAll("<.*?>", "");
                    tempSauce = model.getCatalog().getSauceByName(sauceFull);
                    temp = sc.nextLine();
                    temp = sc.nextLine();
                    temp = sc.nextLine();
                    temp = sc.nextLine();
                    temp = sc.nextLine();
                    if (temp.contains("fullName")) {
                        fullSizeName = temp.trim().replaceAll("<.*?>", "");
                        temp = sc.nextLine();
                        temp = sc.nextLine();
                        temp = sc.nextLine();
                        temp = sc.nextLine();
                        temp = sc.nextLine();
                        temp = sc.nextLine();
                        temp = sc.nextLine();

                    }
                    while (!temp.contains("toppings")) {
                        if (temp.contains("fullName")) {
                            String toppingFullName = temp.trim().replaceAll("<.*?>", "");
                            temp = sc.nextLine();
                            temp = sc.nextLine();
                            temp = sc.nextLine();
                            ps = model.getCatalog().getSizeByFullName(fullSizeName);
                            Topping top = model.getCatalog().getToppingByName(toppingFullName);
                            tops.add(top);
                        }
                        temp = sc.nextLine();
                    }
                    temp = sc.nextLine();
                    Pizza pizza = new Pizza(tops, tempSauce, ps, PIZZA_STATUS.NEW, pizPrice);
                    order.addPizza(pizza);
                }
                temp = sc.nextLine();

            }
            temp = sc.nextLine();
            temp = sc.nextLine();
            temp = sc.nextLine();
            temp = sc.nextLine();
            temp = sc.nextLine();
            while (!temp.contains("objects.OrderItem")) {
                temp = sc.nextLine();
                temp = sc.nextLine();
                temp = sc.nextLine();
                String drinkName = temp.replaceAll("<.*?>", "").trim();
                temp = sc.nextLine();
                Double drinkPrice = Double.parseDouble(temp.replaceAll("<.*?>", ""));
                temp = sc.nextLine();
                temp = sc.nextLine();
                temp = sc.nextLine();
                Drink tempDrink = model.getCatalog().getDrinksByName(drinkName);
                tempDrink.setPrice(drinkPrice);
                order.addSide(tempDrink);
            }
            temp = sc.nextLine();
            temp = sc.nextLine();
            temp = sc.nextLine();
            temp = sc.nextLine();
            temp = sc.nextLine();
            temp = sc.nextLine();
            while (!temp.contains("sides")) {
                String itemName = temp.replaceAll("<.*?>", "");
                temp = sc.nextLine();
                itemPrice = Double.parseDouble(temp.replaceAll("<.*?>", ""));
                temp = sc.nextLine();
                temp = sc.nextLine();
            }
            temp = sc.nextLine();
            temp = sc.nextLine();*/
        }
    }
}

