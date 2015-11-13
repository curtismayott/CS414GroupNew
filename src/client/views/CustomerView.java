package client.views;

import client.controllers.WindowManager;
import server.objects.Order;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import java.awt.*;
import java.util.Observable;

/**
 * Created by darkbobo on 10/24/15.
 */
public class CustomerView extends MyJFrame {
    private JPanel customerContainer;
    private JTextArea phoneEditText;
    private JTextArea nameEditText;
    private JTextArea streetEditText;
    private JTextArea cityEditText;
    private JTextArea stateEditText;
    private JTextArea zipEditText;
    private JButton cancelButton;
    private JButton saveButton;
    private JButton clearButton;
    private JComboBox orderTypeCombo;
    private Order order;
    public CustomerView(){
        customerContainer.setPreferredSize(new Dimension(getToolkit().getScreenSize().width, getToolkit().getScreenSize().height));
        setContentPane(customerContainer);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        pack();

        Border border = BorderFactory.createBevelBorder(BevelBorder.RAISED, Color.BLUE, Color.BLACK);
        phoneEditText.setBorder(border);
        nameEditText.setBorder(border);
        streetEditText.setBorder(border);
        cityEditText.setBorder(border);
        stateEditText.setBorder(border);
        zipEditText.setBorder(border);
    }

    @Override
    public void update(Observable observable, Object o) {

    }

    public void addWindowManager(WindowManager manager){
        this.manager = manager;
    }

    public void addComponents(){
        controller.registerComponent("phoneEditText", phoneEditText);
        controller.registerComponent("nameEditText", nameEditText);
        controller.registerComponent("streetEditText", streetEditText);
        controller.registerComponent("cityEditText", cityEditText);
        controller.registerComponent("stateEditText", stateEditText);
        controller.registerComponent("zipEditText", zipEditText);
        controller.registerComponent("cancelButton", cancelButton);
        controller.registerComponent("clearButton", clearButton);
        controller.registerComponent("saveButton", saveButton);
        controller.registerComponent("orderTypeCombo", orderTypeCombo);
        orderTypeCombo.addItem("Delivery");
        orderTypeCombo.addItem("Pickup");
        orderTypeCombo.addItem("Carry Out");
        cancelButton.addActionListener(controller);
        clearButton.addActionListener(controller);
        saveButton.addActionListener(controller);
        orderTypeCombo.addActionListener(controller);
    }
}
