package server.communication;
import server.objects.*;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Jim on 11/22/2015.
 */
public class test {

    public static void main(String[] args) {
        Scanner sc = new Scanner("<server.communication.SideItemsHolder>\n" +
                "  <side>\n" +
                "    <server.objects.Side>\n" +
                "      <price defined-in=\"server.objects.OrderItem\">2.99</price>\n" +
                "      <orderID>0</orderID>\n" +
                "      <status>NEW</status>\n" +
                "      <itemID defined-in=\"server.objects.OrderItem\">0</itemID>\n" +
                "      <itemID>28</itemID>\n" +
                "      <name>Bread Stick</name>\n" +
                "      <price>2.99</price>\n" +
                "    </server.objects.Side>\n" +
                "    <server.objects.Side>\n" +
                "      <price defined-in=\"server.objects.OrderItem\">2.99</price>\n" +
                "      <orderID>0</orderID>\n" +
                "      <status>NEW</status>\n" +
                "      <itemID defined-in=\"server.objects.OrderItem\">0</itemID>\n" +
                "      <itemID>29</itemID>\n" +
                "      <name>Salad</name>\n" +
                "      <price>2.99</price>\n" +
                "    </server.objects.Side>\n" +
                "    <server.objects.Side>\n" +
                "      <price defined-in=\"server.objects.OrderItem\">4.99</price>\n" +
                "      <orderID>0</orderID>\n" +
                "      <status>NEW</status>\n" +
                "      <itemID defined-in=\"server.objects.OrderItem\">0</itemID>\n" +
                "      <itemID>30</itemID>\n" +
                "      <name>Ice Cream</name>\n" +
                "      <price>4.99</price>\n" +
                "    </server.objects.Side>\n" +
                "  </side>\n" +
                "</server.communication.SideItemsHolder>");
        String temp;
        ArrayList<Side> list = new ArrayList<Side>();
        while (sc.hasNextLine()) {
            temp = sc.nextLine();
            if (temp.contains("price defined-in")) {
                double Oprice = Double.parseDouble(temp.replaceAll("<.*?>", ""));
                temp = sc.nextLine().trim();
                int orderId = Integer.parseInt(temp.replaceAll("<.*?>", ""));
                temp = sc.nextLine().trim();
                temp = sc.nextLine().trim();
                int oId = Integer.parseInt(temp.replaceAll("<.*?>", ""));
                temp = sc.nextLine().trim();
                int iId = Integer.parseInt(temp.replaceAll("<.*?>", ""));
                temp = sc.nextLine().trim();
                String name = temp.replaceAll("<.*?>", "");
                temp = sc.nextLine().trim();
                double price = Double.parseDouble(temp.replaceAll("<.*?>", ""));
                temp = sc.nextLine().trim();
                Side s = new Side(name, price);
                s.setOrderID(orderId);
                OrderItem oi = (OrderItem) s;
                oi.setOrderID(iId);
                oi.setItemID(oId);
                oi.setPrice(Oprice);
                oi.setStatus(PIZZA_STATUS.NEW);
                list.add(s);
            }
        }
        System.out.println(list);
    }
}