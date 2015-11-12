package client.views;

import javax.swing.*;
import java.awt.*;

/**
 * Created by darkbobo on 10/27/15.
 */
public class ComponentMenuEdit extends JLabel implements ListCellRenderer {
    public ComponentMenuEdit(){
        setOpaque(true);
    }
    @Override
    public Component getListCellRendererComponent(JList jList, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        JButton button = new JButton(value.toString());
        return button;
    }
}
