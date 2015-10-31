package views;

import objects.Pizza;

import javax.swing.*;

/**
 * Created by Tyler on 10/25/15.
 */
public class ComponentMakline extends JLabel implements ListCellRenderer {

    public ComponentMakline(){
        setOpaque(true);

    }


    @Override
    public JCheckBox getListCellRendererComponent(JList jList, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        Pizza pizza = (Pizza)value;
        JCheckBox button = new JCheckBox(pizza.makelineToString());
        return button;
    }


}
