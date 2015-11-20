package client.views;

import server.objects.PizzaSize;
import server.objects.Special;

import javax.swing.*;
import java.awt.*;

/**
 * Created by darkbobo on 11/18/15.
 */
public class ComponentSpecial extends JLabel implements ListCellRenderer {
    public ComponentSpecial() {
        setOpaque(true);
    }

    @Override
    public JButton getListCellRendererComponent(JList jList, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        Special special = (Special) value;
        JButton button = new JButton();
        button.setPreferredSize(new Dimension(200, 60));
        button.setText(special.toString());
        return button;
    }
}