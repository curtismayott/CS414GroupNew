package server.controllers;

import server.objects.*;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import java.awt.event.ActionEvent;
import java.util.HashMap;

/**
 * Created by darkbobo on 11/17/15.
 */
public class SpecialListener extends MyActionListener {
    Special special;

    public SpecialListener() {
        components = new HashMap<>();
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        String command = actionEvent.getActionCommand();
        System.out.println(command);
        switch (command) {
            case "comboBoxChanged":
                if(components.get("itemTypeCombo").equals(actionEvent.getSource())) {
                    if(((JComboBox)components.get("itemTypeCombo")).getSelectedItem().equals("Side")){
                        setSideCombo();
                    }else{
                        setPizzaCombo();
                    }
                }else{

                }
                break;
            case "Back":
                manager.activateWindow(manager.SPECIALS_EDIT, manager.MANAGE_MAIN);
                break;
            case "Delete":
                if (special != null) {
                    model.getCatalog().deleteSpecial(special);
                }
                resetView();
                break;
            case "Cancel":
                resetView();
                break;
            case "Save":
                String specialName = ((JTextField) components.get("nameEditText")).getText();
                String priceString = ((JTextField) components.get("priceEditText")).getText();
                String numToppings = ((JTextField) components.get("numToppingsEditText")).getText();
                String itemType = ((JComboBox)components.get("itemTypeCombo")).getSelectedItem().toString();
                try {
                    if (!model.getCatalog().getSpecials().contains(special)) {
                        special = new Special();
                    }
                    special.setDiscountedPrice(Double.parseDouble(priceString));
                    special.setItemType(itemType);
                    special.setName(specialName);

                    if(((JComboBox)components.get("itemTypeCombo")).getSelectedItem().toString().equals("Pizza")){
                        special.setSize(model.getCatalog().getSizeByFullName(((JComboBox)components.get("sizeSideCombo")).getSelectedItem().toString()));
                        special.setNumToppings(Integer.parseInt(numToppings));
                    }else{
                        special.setSideItem(model.getCatalog().getSideItemByName(((JComboBox)components.get("sizeSideCombo")).getSelectedItem().toString()));
                    }
                    if(model.getCatalog().getSpecials().contains(special)){
                        model.getCatalog().updateSpecial(special);
                    }else{
                        model.getCatalog().addSpecial(special);
                    }
                    resetView();
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(view,
                            "Price/NumToppings must be a number",
                            "Error",
                            JOptionPane.PLAIN_MESSAGE);
                }
                break;
        }
    }

    @Override
    public void valueChanged(ListSelectionEvent event) {
        System.out.println(event.toString());
        JList list = (JList) event.getSource();
        if (list.getSelectedValue() != null) {
            // check
            special = (Special)list.getSelectedValue();
            setView();
        }
    }

    public void setView() {
        ((JComboBox) components.get("itemTypeCombo")).setSelectedItem(special.getItemType());
        ((JTextField)components.get("priceEditText")).setText(Double.toString(special.getDiscountedPrice()));
        ((JTextField) components.get("nameEditText")).setText(special.getName());
        if(special.getItemType().equals("Pizza")){
            components.get("numToppingsContainer").setVisible(true);
            ((JTextField) components.get("numToppingsEditText")).setText(Integer.toString(special.getNumToppings()));
        }else if(special.getItemType().equals("Side")){
            components.get("numToppingsContainer").setVisible(false);
        }
        if(special.getSideItem() != null){
            ((JComboBox) components.get("sizeSideCombo")).setSelectedItem(special.getSideItem().getName());
        }else {
            ((JComboBox) components.get("sizeSideCombo")).setSelectedItem(special.getSize().getFullName());
        }
    }

    public void resetView() {
        ((JTextField) components.get("priceEditText")).setText("");
        ((JTextField) components.get("numToppingsEditText")).setText("");
        ((JTextField) components.get("nameEditText")).setText("");
        ((JList) components.get("specialList")).setListData(model.getCatalog().getSpecials().toArray());
        components.get("itemTypeCombo").setEnabled(true);
        ((JComboBox)components.get("itemTypeCombo")).setSelectedItem("Pizza");
        components.get("numToppingsContainer").setVisible(true);
        setPizzaCombo();
        special = null;
    }

    public void setPizzaCombo(){
        ((JComboBox)components.get("sizeSideCombo")).removeAllItems();
        for(PizzaSize size : model.getCatalog().getSizes()){
            ((JComboBox)components.get("sizeSideCombo")).addItem(size.getFullName());
        }
        components.get("numToppingsContainer").setVisible(true);
    }

    public void setSideCombo(){
        ((JComboBox)components.get("sizeSideCombo")).removeAllItems();
        for(Side side : model.getCatalog().getSides()){
            ((JComboBox)components.get("sizeSideCombo")).addItem(side.getName());
        }
        for(Drink drink : model.getCatalog().getDrinks()){
            ((JComboBox)components.get("sizeSideCombo")).addItem(drink.getName());
        }
        components.get("numToppingsContainer").setVisible(false);
    }
}