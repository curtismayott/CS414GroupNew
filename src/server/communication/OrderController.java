package server.communication;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.thoughtworks.xstream.XStream;
import server.objects.*;

import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URLDecoder;
import java.rmi.RemoteException;

public class OrderController implements HttpHandler {
    Register register;
    public OrderController(Register reg) throws RemoteException {
        this.register = reg;
    }

    @Override
    public void handle(HttpExchange exchange){
        URI uri = exchange.getRequestURI();
        String response = "Order received";
        try {
            exchange.sendResponseHeaders(200, response.length());
            OutputStream os = exchange.getResponseBody();
            os.write(response.getBytes());
            os.close();
        } catch (IOException e) {
            System.out.println(e.toString());
        }
        //send response with code 200 (A-OK)
        String temp = uri.toString();
        try {
            temp = URLDecoder.decode(temp, "UTF-8");
            temp = temp.replaceAll("/order/", "");
        } catch (UnsupportedEncodingException e) {
            System.out.println(e.toString());
        }
        Order order = null;
        XStream x = new XStream();
        x.autodetectAnnotations(true);
        order = (Order)x.fromXML(temp);
        System.out.println(order.getDrinks());
        register.addOrder(order);
        order.sendPizzasToMakeLine();
        order.sendSidesToMakeLine();
        register.updateOrder(order.getOrderID(), order);
        register.manager.getControllers().get("orderList").resetView();
    }
}
