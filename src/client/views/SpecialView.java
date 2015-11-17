package client.views;

import server.objects.Special;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import java.awt.*;

/**
 * Created by darkbobo on 11/17/15.
 */
public class SpecialView extends MyJFrame {
    private JPanel viewContainer;
    private JComboBox itemTypeCombo;
    private JButton backButton;
    private JTextField priceEditText;
    private JComboBox sizeSideCombo;
    private JTextField numToppingsEditText;
    private JPanel numToppingsContainer;
    private JTextField nameEditText;
    private JButton deleteButton;
    private JButton cancelButton;
    private JButton saveButton;
    private JList specialList;

    public SpecialView() {
        viewContainer.setPreferredSize(new Dimension(getToolkit().getScreenSize().width, getToolkit().getScreenSize().height));
        setContentPane(viewContainer);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        Border border = BorderFactory.createBevelBorder(BevelBorder.RAISED, Color.BLUE, Color.BLACK);
        nameEditText.setBorder(border);
        numToppingsEditText.setBorder(border);
        priceEditText.setBorder(border);
    }
    public void addComponents(){
        controller.registerComponent("specialList", specialList);
        controller.registerComponent("nameEditText", nameEditText);
        controller.registerComponent("priceEditText", priceEditText);
        controller.registerComponent("cancelButton", cancelButton);
        controller.registerComponent("deleteButton", deleteButton);
        controller.registerComponent("saveButton", saveButton);
        controller.registerComponent("backButton", backButton);
        controller.registerComponent("itemTypeCombo", itemTypeCombo);

        specialList.addListSelectionListener(controller);
        specialList.setCellRenderer(new ComponentMenuEdit());
        cancelButton.addActionListener(controller);
        deleteButton.addActionListener(controller);
        saveButton.addActionListener(controller);
        backButton.addActionListener(controller);
/*
        typeComboBox.addItem("Topping");
        typeComboBox.addItem("Size");
        typeComboBox.addItem("Sauce");
        typeComboBox.addItem("Side");
        typeComboBox.addItem("Drink");
        typeComboBox.addActionListener(controller);
*/
    }
}
