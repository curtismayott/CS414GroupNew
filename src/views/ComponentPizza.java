package views;

import objects.OrderItem;

import javax.swing.*;

/**
 * Created by darkbobo on 9/28/15.
 */
public class ComponentPizza extends JLabel implements ListCellRenderer {
    public ComponentPizza(){
        setOpaque(true);

    }
    @Override
    public JButton getListCellRendererComponent(JList jList, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        OrderItem item = (OrderItem)value;
        JButton button = new JButton(item.toString());
        return button;
    }
}
