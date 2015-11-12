package client.views;

import server.objects.Sauce;

import javax.swing.*;
import java.awt.*;

/**
 * Created by darkbobo on 9/28/15.
 */
public class ComponentSauce extends JLabel implements ListCellRenderer {
    public ComponentSauce(){
        setOpaque(true);

    }
    @Override
    public JButton getListCellRendererComponent(JList jList, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        Sauce sauce = (Sauce)value;
        final JButton button = new JButton(sauce.toString());
        button.setPreferredSize(new Dimension(200, 60));
        button.setText(sauce.toString());
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
