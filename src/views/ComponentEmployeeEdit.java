package views;

import objects.Employee;

import javax.swing.*;
import java.awt.*;

/**
 * Created by darkbobo on 10/27/15.
 */
public class ComponentEmployeeEdit extends JLabel implements ListCellRenderer {
        public ComponentEmployeeEdit(){
            setOpaque(true);
        }
        @Override
        public Component getListCellRendererComponent(JList jList, Object value, int index, boolean isSelected, boolean cellHasFocus) {
            Employee employee = (Employee)value;
            JButton button = new JButton(employee.toString());
            return button;
        }
}
