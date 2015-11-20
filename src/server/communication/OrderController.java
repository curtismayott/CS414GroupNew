package server.communication;

import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import server.objects.*;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;
import java.rmi.RemoteException;

public class OrderController implements HttpHandler {

    Register register;

    public OrderController(Register reg) throws RemoteException{ this.register = reg; }


    @Override
    public void handle(HttpExchange exchange) throws IOException {
        URI uri = exchange.getRequestURI();
        String response = "Order received";

        System.out.println(parseRequest(uri.toString().replace("/order?", "")));
        //send response with code 200 (A-OK)
        exchange.sendResponseHeaders(200, response.length());

        OutputStream os = exchange.getResponseBody();
        os.write(response.getBytes());
        os.close();
    }

    public String parseRequest(String uri){
        String temp = "";
        String[] subs = uri.split("&");
        for (String parameter : subs) {
            //key is on the left and value is on the right, so we split this
            String[] values = parameter.split("=");
            temp += values[0] + '=' + values[1];
        }
        return temp;
    }
}
