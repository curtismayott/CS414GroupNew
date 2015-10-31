package views;

import objects.Topping;

import javax.swing.*;
import java.awt.*;

/**
 * Created by darkbobo on 9/28/15.
 */
public class ComponentTopping extends JLabel implements ListCellRenderer {
    public ComponentTopping(){
        setOpaque(true);
    }
    @Override
    public JButton getListCellRendererComponent(JList jList, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        Topping size = (Topping)value;
        JButton button = new JButton();
        button.setPreferredSize(new Dimension(200, 60));
        button.setText(size.toString());
        if(isSelected){
            button.setSelected(true);
            button.setBackground(Color.CYAN);
        }else{
            button.setSelected(false);
            button.setBackground(Color.LIGHT_GRAY);
        }
        return button;
    }
}
