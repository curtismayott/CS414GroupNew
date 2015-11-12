package server.controllers;

import server.objects.*;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import java.awt.event.ActionEvent;
import java.util.HashMap;

/**
 * Created by darkbobo on 10/27/15.
 */
public class MenuEditListener extends MyActionListener {
    Object item;
    public MenuEditListener(){
        components = new HashMap<>();
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        String command = actionEvent.getActionCommand();
        System.out.println(command);
        switch (command){
            case "comboBoxChanged":
                if(((JComboBox)components.get("typeComboBox")).getSelectedItem().equals("Side")
                        || ((JComboBox)components.get("typeComboBox")).getSelectedItem().equals("Drink")){
                    components.get("priceContainer").setVisible(true);
                    components.get("shortnameContainer").setVisible(false);
                }else if(((JComboBox)components.get("typeComboBox")).getSelectedItem().equals("Size")) {
                    components.get("priceContainer").setVisible(true);
                    components.get("shortnameContainer").setVisible(true);
                }else{
                    components.get("priceContainer").setVisible(false);
                    components.get("shortnameContainer").setVisible(true);
                }
                break;
            case "Back":
                manager.activateWindow(manager.MENU_EDIT, manager.MANAGE_MAIN);
                break;
            case "Delete":
                if(item != null){
                    model.getCatalog().deleteItem(item);
                }
                resetView();
                break;
            case "Cancel":
                resetView();
                break;
            case "Save":
                String itemName = ((JTextArea)components.get("itemNameEditText")).getText();
                String shortName = ((JTextArea)components.get("shortNameEditText")).getText();
                String priceString = ((JTextArea)components.get("priceEditText")).getText();
                double price;
                try {
                    switch (((JComboBox) components.get("typeComboBox")).getSelectedItem().toString()) {
                        case "Topping":
                            if (model.getCatalog().getEntireCatalog().contains(item)) {
                                ((Topping)item).setFullName(itemName);
                                ((Topping)item).setShortName(shortName);
                                model.getCatalog().updateItem(((Topping) item).getItemID());
                            } else {
                                item = new Topping(shortName, itemName);
                                model.getCatalog().addItem(item);
                            }
                            break;
                        case "Size":
                            price = Double.parseDouble(priceString);
                            if (model.getCatalog().getEntireCatalog().contains(item)) {
                                ((PizzaSize)item).setFullName(itemName);
                                ((PizzaSize)item).setShortName(shortName);
                                ((PizzaSize)item).setPrice(price);
                                model.getCatalog().updateItem(((PizzaSize) item).getItemID());
                            } else {
                                item = new PizzaSize(shortName, itemName, price);
                                model.getCatalog().addItem(item);
                            }
                            break;
                        case "Sauce":
                            if (model.getCatalog().getEntireCatalog().contains(item)) {
                                ((Sauce)item).setFullName(itemName);
                                ((Sauce)item).setShortName(shortName);
                                model.getCatalog().updateItem(((Sauce) item).getItemID());
                            } else {
                                item = new Sauce(shortName, itemName);
                                model.getCatalog().addItem(item);
                            }
                            break;
                        case "Side":
                            price = Double.parseDouble(priceString);
                            if (model.getCatalog().getEntireCatalog().contains(item)) {
                                ((Side)item).setName(itemName);
                                ((Side)item).setPrice(price);
                                model.getCatalog().updateItem(((Side) item).getItemID());
                            } else {
                                item = new Side(itemName, price);
                                model.getCatalog().addItem(item);
                            }
                            break;
                        case "Drink":
                            price = Double.parseDouble(priceString);
                            if (model.getCatalog().getEntireCatalog().contains(item)) {
                                ((Drink)item).setName(itemName);
                                ((Drink)item).setPrice(price);
                                model.getCatalog().updateItem(((Drink) item).getItemID());
                            } else {
                                item = new Drink(itemName, price);
                                model.getCatalog().addItem(item);
                            }
                            break;
                    }

                    resetView();
                }catch(NumberFormatException e){
                    JOptionPane.showMessageDialog(view,
                            "Price must be a number",
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
        if(list.getSelectedValue() != null){
            // check
            String buttonText = list.getSelectedValue().toString();
            item = model.getCatalog().getItem(buttonText);
            if(item instanceof PizzaSize){
                setView("Size", ((PizzaSize) item).getFullName(), ((PizzaSize) item).getShortName(), ((PizzaSize) item).getPrice());
            }else if(item instanceof Sauce){
                setView("Sauce", ((Sauce) item).getFullName(), ((Sauce) item).getShortName(), -1.0);
            }else if(item instanceof Topping){
                setView("Topping", ((Topping) item).getFullName(), ((Topping) item).getShortName(), -1.0);
            }else  if(item instanceof Side){
                setView("Side", ((SideItem) item).getName(), null, ((SideItem)item).getPrice());
            }else if(item instanceof Drink){
                setView("Drink", ((SideItem) item).getName(), null, ((SideItem) item).getPrice());
            }
            components.get("typeComboBox").setEnabled(false);
        }
    }

    public void setView(String type, String itemName, String shortName, double price){
        ((JComboBox)components.get("typeComboBox")).setSelectedItem(type);
        if(itemName != null) {
            ((JTextArea) components.get("itemNameEditText")).setText(itemName);
        }
        if(shortName != null) {
            ((JTextArea) components.get("shortNameEditText")).setText(shortName);
        }
        if(price != -1.0) {
            ((JTextArea) components.get("priceEditText")).setText(Double.toString(price));
        }
    }

    public void resetView(){
        ((JTextArea)components.get("itemNameEditText")).setText("");
        ((JTextArea)components.get("shortNameEditText")).setText("");
        ((JTextArea)components.get("priceEditText")).setText("");
        ((JList)components.get("menuItemList")).setListData(model.getCatalog().getEntireCatalog().toArray());
        components.get("typeComboBox").setEnabled(true);
        item = null;
    }
}
