package client.views;

import client.views.ComponentMenuEdit;
import client.views.MyJFrame;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import java.awt.*;

/**
 * Created by darkbobo on 10/27/15.
 */
public class MenuEditView extends MyJFrame {

    private JPanel viewContainer;
    private JList menuItemList;
    private JTextArea itemNameEditText;
    private JTextArea shortNameEditText;
    private JTextArea priceEditText;
    private JButton cancelButton;
    private JButton deleteButton;
    private JButton saveButton;
    private JButton backButton;
    private JComboBox typeComboBox;
    private JPanel priceContainer;
    private JPanel shortnameContainer;

    public MenuEditView(){
        viewContainer.setPreferredSize(new Dimension(getToolkit().getScreenSize().width, getToolkit().getScreenSize().height));
        setContentPane(viewContainer);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        Border border = BorderFactory.createBevelBorder(BevelBorder.RAISED, Color.BLUE, Color.BLACK);
        itemNameEditText.setBorder(border);
        shortNameEditText.setBorder(border);
        priceEditText.setBorder(border);

    }

    public void addComponents(){
        controller.registerComponent("menuItemList", menuItemList);
        controller.registerComponent("itemNameEditText", itemNameEditText);
        controller.registerComponent("shortNameEditText", shortNameEditText);
        controller.registerComponent("priceEditText", priceEditText);
        controller.registerComponent("cancelButton", cancelButton);
        controller.registerComponent("deleteButton", deleteButton);
        controller.registerComponent("saveButton", saveButton);
        controller.registerComponent("backButton", backButton);
        controller.registerComponent("typeComboBox", typeComboBox);
        controller.registerComponent("priceContainer", priceContainer);
        controller.registerComponent("shortnameContainer", shortnameContainer);

        menuItemList.addListSelectionListener(controller);
        menuItemList.setCellRenderer(new ComponentMenuEdit());
        cancelButton.addActionListener(controller);
        deleteButton.addActionListener(controller);
        saveButton.addActionListener(controller);
        backButton.addActionListener(controller);

        typeComboBox.addItem("Topping");
        typeComboBox.addItem("Size");
        typeComboBox.addItem("Sauce");
        typeComboBox.addItem("Side");
        typeComboBox.addItem("Drink");
        typeComboBox.addActionListener(controller);
    }
}
