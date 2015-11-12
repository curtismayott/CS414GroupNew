package client.views;

import client.views.ComponentEmployeeEdit;
import client.views.MyJFrame;
import server.objects.ROLE;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import java.awt.*;

/**
 * Created by darkbobo on 10/27/15.
 */
public class EmployeeEditView extends MyJFrame {
    private JPanel viewContainer;
    private JList employeeList;
    private JTextArea nameEditText;
    private JTextArea phoneEditText;
    private JTextArea streetEditText;
    private JTextArea cityEditText;
    private JTextArea stateEditText;
    private JTextArea zipEditText;
    private JButton cancelButton;
    private JButton saveButton;
    private JButton deleteButton;
    private JButton backButton;
    private JButton setAuthenticationCodeButton;
    private JComboBox roleComboBox;
    private JTextArea usernameEditText;

    public EmployeeEditView(){
        viewContainer.setPreferredSize(new Dimension(getToolkit().getScreenSize().width, getToolkit().getScreenSize().height));
        setContentPane(viewContainer);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        Border border = BorderFactory.createBevelBorder(BevelBorder.RAISED, Color.BLUE, Color.BLACK);
        nameEditText.setBorder(border);
        phoneEditText.setBorder(border);
        streetEditText.setBorder(border);
        cityEditText.setBorder(border);
        stateEditText.setBorder(border);
        zipEditText.setBorder(border);
        usernameEditText.setBorder(border);
    }
    public void addComponents(){
        controller.registerComponent("employeeList", employeeList);
        controller.registerComponent("nameEditText", nameEditText);
        controller.registerComponent("phoneEditText", phoneEditText);
        controller.registerComponent("streetEditText", streetEditText);
        controller.registerComponent("cityEditText", cityEditText);
        controller.registerComponent("roleComboBox", roleComboBox);
        controller.registerComponent("stateEditText", stateEditText);
        controller.registerComponent("zipEditText", zipEditText);
        controller.registerComponent("cancelButton", cancelButton);
        controller.registerComponent("saveButton", saveButton);
        controller.registerComponent("deleteButton", deleteButton);
        controller.registerComponent("backButton", backButton);
        controller.registerComponent("setAuthenticationCodeButton", setAuthenticationCodeButton);
        controller.registerComponent("usernameEditText", usernameEditText);

        employeeList.setCellRenderer(new ComponentEmployeeEdit());
        employeeList.addListSelectionListener(controller);


        roleComboBox.addItem(ROLE.MANAGER);
        roleComboBox.addItem(ROLE.CHEF);
        roleComboBox.addItem(ROLE.CASHIER);

        cancelButton.addActionListener(controller);
        saveButton.addActionListener(controller);
        deleteButton.addActionListener(controller);
        backButton.addActionListener(controller);
        setAuthenticationCodeButton.addActionListener(controller);
    }
}
