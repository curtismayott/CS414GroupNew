package server.communication;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.thoughtworks.xstream.XStream;
import server.objects.PizzaSize;
import server.objects.Register;
import server.objects.Topping;

import java.io.IOException;
import java.io.OutputStream;
import java.net.URI;
import java.rmi.RemoteException;

/**
 * Created by Jim on 11/22/2015.
 */
public class SizePushController implements HttpHandler {
    Register register;
    public SizePushController(Register reg) throws RemoteException {
        this.register = reg;
    }


    @Override
    public void handle(HttpExchange exchange) throws IOException {
        URI uri = exchange.getRequestURI();
        String response = "";
        XStream x = new XStream();
        x.autodetectAnnotations(true);
        x.setClassLoader(ToppingsHolder.class.getClassLoader());
        x.addImplicitCollection(PizzaSizesHolder.class, "sizes", PizzaSize.class);
        try {
            response = x.toXML(new PizzaSizesHolder(register.getCatalog().getSizes()));
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