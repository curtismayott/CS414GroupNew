package server.communication;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.thoughtworks.xstream.XStream;
import server.objects.*;

import java.io.IOException;
import java.io.OutputStream;
import java.net.URI;
import java.rmi.RemoteException;

public class ToppingsController implements HttpHandler {
    Register register;

    public ToppingsController(Register reg) throws RemoteException { this.register = reg; }

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        URI uri = exchange.getRequestURI();
        String response = "";
        XStream x = new XStream();
        x.autodetectAnnotations(true);
        x.setClassLoader(ToppingsHolder.class.getClassLoader());
        x.addImplicitCollection(ToppingsHolder.class, "toppings", Topping.class);
        try {
            response = x.toXML(new ToppingsHolder(register.getCatalog().getToppings()));
        } catch (Exception e){
            System.out.println(e.toString());
        }
        //send response with code 200 (A-OK)
        exchange.sendResponseHeaders(200, response.length());
        OutputStream os = exchange.getResponseBody();
        os.write(response.getBytes());
        os.close();
    }
}
