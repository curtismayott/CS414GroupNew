package server.communication;

import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import org.apache.velocity.tools.generic.ValueParser;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.map.ObjectMapper;
import server.objects.*;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;
import java.rmi.RemoteException;
import java.util.Map;

public class MenuController implements HttpHandler {
    @JsonIgnore
    Register register;

    public MenuController(Register reg) throws RemoteException { this.register = reg; }

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        URI uri = exchange.getRequestURI();
        String call = uri.toString().replace("/menu/", "");
        System.out.println(call);
        String response = "";
        ObjectMapper mapper = new ObjectMapper();
        try {
            response = mapper.writeValueAsString(register.getCatalog());
            System.out.println(response);
        } catch (Exception e){
            System.out.println(e.toString());
        }
        //send response with code 200 (A-OK)
        exchange.sendResponseHeaders(200, response.length());
        OutputStream os = exchange.getResponseBody();
        os.write(response.getBytes());
        os.close();
    }

    private String getSizesXML() {
        StringBuffer buff = new StringBuffer();
        buff.append("<sizesList>");
        for (PizzaSize ps : register.getCatalog().getSizes()) {
            buff.append("<size>");
            buff.append("<id>");
            buff.append(ps.getItemID());
            buff.append("</id>");
            buff.append("<short>");
            buff.append(ps.getShortName().replaceAll(" ", ""));
            buff.append("</short>");
            buff.append("<long>");
            buff.append(ps.getFullName().replaceAll(" ", ""));
            buff.append("</long>");
            buff.append("<price>");
            buff.append(ps.getPrice());
            buff.append("</price>");
            buff.append("</size>");
        }
        buff.append("</sizesList>");
        System.out.println(buff.toString());
        return buff.toString();
    }

    private String getSpecialsXML() {
        StringBuffer buff = new StringBuffer();
        buff.append("<specialsList>");
        for (Special ps : register.getCatalog().getSpecials()) {
            buff.append(getSpecialXML(ps));
        }
        buff.append("</specialsList>");
        System.out.println(buff.toString());
        return buff.toString();
    }

    private String getItemXML(SideItem sideItem) {
        StringBuffer buff = new StringBuffer();
        buff.append("<item>");
        buff.append("<name>");
        buff.append(sideItem.getName());
        buff.append("</name>");
        buff.append("<o_id>");
        buff.append(sideItem.getOrderID());
        buff.append("</o_id>");
        buff.append("<i_id>");
        buff.append(sideItem.getItemID());
        buff.append("</i_id>");
        buff.append("<price>");
        buff.append(sideItem.getPrice());
        buff.append("</price>");
        buff.append("<spec>");
        buff.append(getSpecialXML(sideItem.getSpecial()));
        buff.append("</spec>");
        buff.append("<stat>");
        buff.append(sideItem.getStatus());
        buff.append("</stat>");
        buff.append("</item>");
        System.out.println(buff.toString());
        return buff.toString();
    }

    private String getToppingsXML() {
        StringBuffer buff = new StringBuffer();
        buff.append("<toppingList>");
        for (Topping t : register.getCatalog().getToppings()) {
            buff.append("<topping>");
            buff.append("<id>");
            buff.append(t.getItemID());
            buff.append("</id>");
            buff.append("<short>");
            buff.append(t.getShortName());
            buff.append("</short>");
            buff.append("<full>");
            buff.append(t.getFullName());
            buff.append("</full>");
            buff.append("</topping>");
        }
        buff.append("</toppingList>");
        System.out.println(buff.toString());
        return buff.toString();
    }

    private String getSaucesXML() {
        StringBuffer buff = new StringBuffer();
        buff.append("<sauceList>");
        for (Sauce s : register.getCatalog().getSauces()) {
            buff.append("<sauce>");
            buff.append("<id>");
            buff.append(s.getItemID());
            buff.append("</id>");
            buff.append("<short>");
            buff.append(s.getShortName());
            buff.append("</short>");
            buff.append("<full>");
            buff.append(s.getFullName());
            buff.append("</full>");
            buff.append("</sauce>");
        }
        buff.append("</sauceList>");
        System.out.println(buff.toString());
        return buff.toString();
    }

    private String getSideItemXML() {
        StringBuffer buff = new StringBuffer();
        buff.append("<s_itemList>");
        for (Side i : register.getCatalog().getSides()) {
            buff.append("<s_item>");
            buff.append("<id>");
            buff.append(i.getItemID());
            buff.append("</id>");
            buff.append("<oid>");
            buff.append(i.getOrderID());
            buff.append("</oid>");
            buff.append("<name>");
            buff.append(i.getName());
            buff.append("</name>");
            buff.append("<price>");
            buff.append(i.getPrice());
            buff.append("</price>");
            buff.append("<spec>");
            buff.append(getSpecialXML(i.getSpecial()));
            buff.append("</spec>");
            buff.append("<stat>");
            buff.append(i.getStatus());
            buff.append("</stat>");
            buff.append("</s_item>");
        }
        buff.append("</s_itemList>");
        System.out.println(buff.toString());
        return buff.toString();
    }

    private StringBuffer getSpecialXML(Special ps) {
        StringBuffer buff = new StringBuffer();
        if (ps != null) {
            buff.append("<special>");
            buff.append("<disc_pr>");
            double temp2 = ps.getDiscountedPrice();
            buff.append(ps.getDiscountedPrice());

            buff.append("</disc_pr>");
            buff.append("<short>");
            buff.append("<i_type>");
            String temp = ps.getItemType();
            if (!(temp == null))
                //buff.append(ps.getItemType());
                buff.append("</i_type>");
            buff.append("</short>");
            buff.append("<n_top>");
            Integer temp1 = ps.getNumToppings();
            if (!(temp1 == null))
                //buff.append(ps.getNumToppings());
                buff.append("</n_top>");
            buff.append("<s_item>");
            SideItem temp3 = ps.getSideItem();
            if (!(temp3 == null))
                //buff.append(getItemXML(ps.getSideItem()));
                buff.append("</s_item>");
            buff.append("</special>");
            System.out.println(buff.toString());
        }
        return buff;
    }
}
