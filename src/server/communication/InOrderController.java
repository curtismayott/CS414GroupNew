package server.communication;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import server.objects.Register;

import java.io.IOException;
import java.io.OutputStream;
import java.net.URI;

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
        if (in != null){
            System.out.println(in);
            parseOrder(in);
        }
        String response = "Order Received.";
        exchange.sendResponseHeaders(200, response.length());
        OutputStream os = exchange.getResponseBody();
        os.write(response.getBytes());
        os.close();
    }

    private void parseOrder(String in) {
    }
}
