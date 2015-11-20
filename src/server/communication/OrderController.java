package server.communication;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import server.controllers.OrderListListener;
import server.objects.*;

import java.io.IOException;
import java.io.OutputStream;
import java.net.URI;
import java.rmi.RemoteException;
import java.util.ArrayList;

public class OrderController implements HttpHandler {

    Register register;

    public OrderController(Register reg) throws RemoteException{ this.register = reg; }


    @Override
    public void handle(HttpExchange exchange) throws IOException {
        URI uri = exchange.getRequestURI();

        //send response with code 200 (A-OK)
        String[][] temp = parseRequest(uri.toString().replace("/order?", ""));
        Order order = null;
        if (temp[0][0].equals("order")){
            //TODO ADD GUI ORDERS REFRESH??
            System.out.println(temp[0][1]);
            int i = Integer.parseInt(temp[0][1]);
            System.out.println(i);
            order = new Order(i, new Person("555", new Address("555", "555", "555", "555"), new Phone("555")), new ArrayList<Pizza>());
            order.setOrderType(ORDER_TYPE.DELIVERY);
            register.addOrder(order);
            order.sendPizzasToMakeLine();
            order.sendSidesToMakeLine();
            register.updateOrder(order.getOrderID(), order);
            ((OrderListListener)register.manager.getControllers().get("orderList")).resetView();
        }
        else if (temp[0][0].equals("<customer>")){

        }


        String response = "Order received";
        exchange.sendResponseHeaders(200, response.length());
        OutputStream os = exchange.getResponseBody();
        os.write(response.getBytes());
        os.close();
    }

    public String[][] parseRequest(String uri){
        String[] subs = uri.split("&");
        String[][] temp = new String[subs.length][2];
        for (int i = 0; i < subs.length ; i++){
            temp[i][0] = subs[i].split("=")[0];
            temp[i][1] = subs[i].split("=")[1];
        }
        return temp;
    }
}
