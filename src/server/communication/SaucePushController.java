package server.communication;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.thoughtworks.xstream.XStream;
import server.objects.*;

import java.io.IOException;
import java.io.OutputStream;
import java.net.URI;
import java.rmi.RemoteException;

public class SaucePushController implements HttpHandler {
    Register register;

    public SaucePushController(Register reg) throws RemoteException { this.register = reg; }

    @Override
    public void handle(HttpExchange exchange){
        URI uri = exchange.getRequestURI();
        String response = "";
        XStream x = new XStream();
        x.autodetectAnnotations(true);
        x.setClassLoader(SaucesHolder.class.getClassLoader());
        x.addImplicitCollection(SaucesHolder.class, "sauces", Sauce.class);
        try {
            response = x.toXML(new SaucesHolder(register.getCatalog().getSauces()));
            System.out.println(response.toString());
        } catch (Exception e){
            e.printStackTrace();
        }
        //send response with code 200 (A-OK)
        try {
            exchange.sendResponseHeaders(200, response.length());
            OutputStream os = exchange.getResponseBody();
            os.write(response.getBytes());
            os.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
