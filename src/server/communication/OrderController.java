package server.communication;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import org.codehaus.jackson.annotate.JsonIgnore;
import server.controllers.OrderListListener;
import server.objects.*;

import java.io.IOException;
import java.io.OutputStream;
import java.net.URI;
import java.rmi.RemoteException;
import java.util.ArrayList;

public class OrderController implements HttpHandler {
    @JsonIgnore
    Register register;
    public OrderController(Register reg) throws RemoteException {
        this.register = reg;
    }


    @Override
    public void handle(HttpExchange exchange) throws IOException {
        URI uri = exchange.getRequestURI();

        //send response with code 200 (A-OK)
        String[][] temp = parseRequest(uri.toString().replace("/order?", ""));
        Order order = null;
        System.out.println(temp);
        if (temp[0][0].equals("order")) { /*
                order= [0][0] , {order_num} [0][1] , name=  [1][0] , {name}[1][1] ,
                street=  [2][0] , {address-street}[2][1] ,
                city= [3][0] , {address-city} [3][1], state= [4][0],{address-state} [4][1],
                zip=  [5][0], {address-zip} [5][1] , phone= [6][0] , {phone} [6][1], type= [7][0] , {type} [7][1]
                CHECK [7][1] == ( pizza || item || drink )
                WHILE(more): {
                    IFF: [7][1] == pizza
                        BEGIN PIZZA PARSING:
                        cost= [8][0] , {cost} [8][1]
                        id= [9][0] , {id} [9][1]
                        size= [10][1] , {size}[10][1]   <---FULL NAME
                        sauce= [11][1], {sauce}[11][1]  <---FULL NAME
                        WHILE(more): {
                            top= [12+][0] , {longName} [13][1]
                            IFF: [12+][0] == PIZZADONE: CREATE&PARSENEXT   }
                    ELSEIF: [7][1] == item
                        BEGIN ITEM PARSING:
                        name= [10][0] , {name} [10][1]
                        ITEMDONE
                    ELSEIF: [7][1] == drink
                        BEGIN DRINK PARSING:
                        name= [9][0] , {name} [9][1]
            */
            boolean done = false;
            order = new Order(Integer.parseInt(temp[0][1]), new Person(temp[1][1], new Address(temp[2][1], temp[3][1], temp[4][1], temp[5][1]), new Phone(temp[6][1])), new ArrayList<Pizza>());
            int curplace = 7;
            while (!done) {
                if (curplace < temp.length) {
                    //next item a pizza
                    if (temp[curplace][0].equals("pizza")) {
                        curplace++;
                        int cost = Integer.parseInt(temp[curplace][1]);
                        curplace++;
                        int id = Integer.parseInt(temp[curplace][1]);
                        curplace++;
                        PizzaSize size = register.getCatalog().getSizeByFullName(temp[curplace][1]);
                        curplace++;
                        Sauce sauce = register.getCatalog().getSauceByFullName(temp[curplace][1]);
                        curplace++;
                        ArrayList<Topping> tList = new ArrayList<Topping>();
                        boolean okay = true;
                        while (okay) {
                            if (okay = temp[curplace][0].equals("top")) {
                                Topping top = register.getCatalog().getToppingByName(temp[curplace][1]);
                                tList.add(top);
                                curplace++;
                            } else if (temp[curplace][0].equals("PIZZA_DONE")) {
                                Pizza p = new Pizza(tList, sauce, size, PIZZA_STATUS.NEW, cost);
                                p.setOrderID(id);
                                order.addPizza(p);
                                okay = false;
                                curplace++;
                            }
                        }

                    } else if (temp[curplace][0].equals("item")) {
                        boolean okay = true;
                        while (okay) {
                            if (okay = temp[curplace][0].equals("item")) {
                                SideItem si = register.getCatalog().getSideItemByName(temp[curplace][1]);
                                order.addSide(si);
                                curplace++;
                            } else if (temp[curplace][0].equals("ITEM_DONE")) {
                                okay = false;
                                curplace++;
                            }
                        }
                    } else if (temp[curplace][0].equals("drink")) {
                        boolean okay = true;
                        while (okay) {
                            if (okay = temp[curplace][0].equals("drink")) {
                                Drink d = register.getCatalog().getDrinksByName(temp[curplace][1]);
                                order.addSide(d);
                                curplace++;
                            } else if (temp[curplace][0].equals("DRINK_DONE")) {
                                okay = false;
                                curplace++;
                            }
                        }
                    }
                }
            }
            order.setOrderType(ORDER_TYPE.DELIVERY);
            register.addOrder(order);
            order.sendPizzasToMakeLine();
            order.sendSidesToMakeLine();
            register.updateOrder(order.getOrderID(), order);
            ((OrderListListener) register.manager.getControllers().get("orderList")).resetView();
            //} else if (temp[0][0].equals("<customer>")) {

            String response = "Order received";
            exchange.sendResponseHeaders(200, response.length());
            OutputStream os = exchange.getResponseBody();
            os.write(response.getBytes());
            os.close();
        }

    }

    public String[][] parseRequest(String uri) {
        String[] subs = uri.split("&");
        String[][] temp = new String[subs.length][2];
        for (int i = 0; i < subs.length; i++) {
            temp[i][0] = subs[i].split("=")[0];
            temp[i][1] = subs[i].split("=")[1];
        }
        return temp;
    }
}
