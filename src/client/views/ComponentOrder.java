package client.views;

import server.objects.Order;

import javax.swing.*;
import java.awt.*;

/**
 * Created by darkbobo on 10/25/15.
 */
public class ComponentOrder extends JLabel implements ListCellRenderer {
    public ComponentOrder(){
        setOpaque(true);
    }
    @Override
    public Component getListCellRendererComponent(JList jList, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        Order order = (Order)value;
        JButton button = new JButton(order.toString());
        return button;
    }
}
