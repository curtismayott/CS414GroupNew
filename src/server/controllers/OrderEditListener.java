package server.controllers;

import server.objects.*;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by darkbobo on 10/14/15.
 */
public class OrderEditListener extends MyActionListener implements ListSelectionListener {
    Order order;

    public OrderEditListener(){
        components = new HashMap<>();
    }

    public void setOrderID(int orderID){
        order = model.getOrder(orderID);
        this.orderID = orderID;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        String command = actionEvent.getActionCommand();
        System.out.println(command);
        System.out.println(actionEvent.paramString());
        Pizza pizza = new Pizza();
        switch (actionEvent.getActionCommand()){
            case "Add":
            case "Update":
                ArrayList<Topping> selectedToppings = new ArrayList<>();
                int[] tmpSelectedToppings = ((JList)components.get("pizzaToppingsList")).getSelectedIndices();
                for (int i = 0; i < tmpSelectedToppings.length; i++) {
                    selectedToppings.add(model.getCatalog().getToppings().get(tmpSelectedToppings[i]));
                }
                // add new pizza to order
                pizza.setToppingList(selectedToppings);
                pizza.setSauce(model.getCatalog().getSauces().get(((JList) components.get("pizzaSaucesList")).getSelectedIndex()));
                pizza.setSize(model.getCatalog().getSizes().get(((JList) components.get("pizzaSizesList")).getSelectedIndex()));
                pizza.setSpecial(model.getCatalog().getSpecials());
                pizza.calculatePrice();
                if (((JButton)components.get("addPizzaButton")).getText().equals("Add")) {
                    order.addPizza(pizza);
                } else {
                    // update pizza
                    int selectedIndex = ((JList)components.get("pizzaList")).getSelectedIndex();
                    order.updatePizza(selectedIndex, pizza);
                }
                resetView();
                clearPizzaSelections();
                ((JTextField)components.get("totalDisplay")).setText(model.TOTAL_TEXT + order.getOrderTotal());
                break;
            case "Cancel Item":
                if(((JButton)components.get("addPizzaButton")).getText().equals("Update")) {
                    int delete = JOptionPane.showConfirmDialog(view,
                            "Remove Item?",
                            "Remove",
                            JOptionPane.YES_NO_OPTION,
                            JOptionPane.QUESTION_MESSAGE);
                    if (delete == 0) {
                        ((JButton) components.get("addPizzaButton")).setText("Add");

                        Pizza removedPizza = null;
                        for (Pizza p : order.getPizzas()) {
                            if (p.toString().equals(((JList) components.get("pizzaList")).getSelectedValue().toString())) {
                                removedPizza = p;
                            }
                        }
                        if (removedPizza != null) {
                            order.removePizza(removedPizza);

                            resetView();
                            System.out.println(order.getPizzas().size());
                        }
                    }
                    ((JList) components.get("pizzaList")).setListData(order.getOrderItems().toArray());
                    clearPizzaSelections();
                }
                break;
            case "Cancel":
                clearPizzaSelections();
                break;
            case "Cancel Order":
                clearPizzaSelections();
                // clear pizzaList
                ((JList)components.get("pizzaList")).setListData(new String[0]);
                order.removeAllPizzas();
                if(model.getOrders().contains(order)){
                    model.getOrders().remove(order);
                }
                order = null;
                ((JTextField)components.get("totalDisplay")).setText(model.TOTAL_TEXT);
                break;
            case "Send To Makeline":
                order.sendPizzasToMakeLine();
                order.sendSidesToMakeLine();
                model.updateOrder(orderID, order);
                order = null;
                manager.activateWindow(manager.ORDER_EDIT, manager.ORDER_LIST);
                break;
            case "Exit":
                for(OrderItem o : order.getOrderItems()){
                    if(o.getStatus() == PIZZA_STATUS.NEW){
                        o.setStatus(PIZZA_STATUS.MAKELINE);
                    }
                }
                Object[] exitOptions = {"Exit",
                        "Cancel"}   ;
                int n = JOptionPane.showOptionDialog(view,
                        "If updating order, changes will be saved.\n"
                            + "If new order, the order will be removed.",
                        "Confirm",
                        JOptionPane.YES_NO_CANCEL_OPTION,
                        JOptionPane.QUESTION_MESSAGE,
                        null,     //do not use a custom Icon
                        exitOptions,  //the titles of buttons
                        exitOptions[0]); //default button title
                if(n == JOptionPane.YES_OPTION){
                    model.removeOrder(order.getOrderID());
                    order = null;
                    resetView();
                    manager.activateWindow(manager.ORDER_EDIT, manager.ORDER_LIST);
                }else{
                    // do nothing
                }
                manager.activateWindow(manager.ORDER_EDIT, manager.ORDER_LIST);
                break;
            case "Sides":
                ArrayList<Side> sides = model.getCatalog().getSides();
                int sideSelection = JOptionPane.showOptionDialog(view,
                        "Select a Side",
                        "Sides",
                        JOptionPane.YES_NO_CANCEL_OPTION,
                        JOptionPane.QUESTION_MESSAGE,
                        null,     //do not use a custom Icon
                        sides.toArray(),  //the titles of buttons
                        sides.toArray()[0]); //default button title*/
                Side side = sides.get(sideSelection);
                side.setSpecial(model.getCatalog().getSpecials());
                order.addSide(side);
                resetView();
                break;
            case "Drinks":
                ArrayList<Drink> drinks = model.getCatalog().getDrinks();
                int drinkSelection = JOptionPane.showOptionDialog(view,
                        "Select a Drink",
                        "Drinks",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE,
                        null,     //do not use a custom Icon
                        drinks.toArray(),  //the titles of buttons
                        drinks.toArray()[0]); //default button title*/
                Drink drink = drinks.get(drinkSelection);
                drink.setSpecial(model.getCatalog().getSpecials());
                order.addSide(drink);
                resetView();
                break;
            case "Collect Order":
                order.sendPizzasToMakeLine();
                order.sendSidesToMakeLine();
                model.updateOrder(orderID, order);
                order = null;
                manager.passOrderID(manager.COLLECT_PAYMENT, orderID);
                manager.activateWindow(manager.ORDER_EDIT, manager.COLLECT_PAYMENT);
                break;
        }
    }

    public void clearPizzaSelections(){
        ((JList)components.get("pizzaToppingsList")).clearSelection();
        ((JList)components.get("pizzaSizesList")).clearSelection();
        ((JList)components.get("pizzaSaucesList")).clearSelection();
        //((JList)components.get("pizzaList")).clearSelection();
        ((JButton)components.get("addPizzaButton")).setText("Add");
    }

    @Override
    public void valueChanged(ListSelectionEvent event) {
        System.out.println(event.toString());
        JList list = (JList) event.getSource();

        if(list.equals(components.get("pizzaList"))) {

            ((JButton)components.get("addPizzaButton")).setText("Update");
            String buttonText = "";
            try {
                buttonText = list.getSelectedValue().toString();
            } catch (NullPointerException e) {
                ((JButton)components.get("addPizzaButton")).setText("Add");
            }
            Pizza pizza = null;
            for (Pizza p : order.getPizzas()) {
                if (p.toString().equals(buttonText)) {
                    pizza = p;
                }
            }
            if (pizza != null) {
                ((JList)components.get("pizzaSaucesList")).setSelectedValue(pizza.getSauce(), true);
                ((JList)components.get("pizzaSizesList")).setSelectedValue(pizza.getSize(), true);

                ArrayList<Integer> indicies = new ArrayList<>();
                for (Topping t : pizza.getToppingList()) {
                    for (int i = 0; i < model.getCatalog().getToppings().size(); i++) {
                        if (model.getCatalog().getToppings().get(i).equals(t)) {
                            indicies.add(i);
                        }
                    }
                }
                int[] tmpIndicies = new int[indicies.size()];
                for (int i = 0; i < indicies.size(); i++) {
                    tmpIndicies[i] = indicies.get(i);
                }
                ((JList)components.get("pizzaToppingsList")).setSelectedIndices(tmpIndicies);
            }else{

                //resetView();
            }
        }
    }
    public void resetView(){
        ((JList) components.get("pizzaSizesList")).setListData(model.getCatalog().getSizes().toArray());
        ((JList) components.get("pizzaSaucesList")).setListData(model.getCatalog().getSauces().toArray());
        ((JList) components.get("pizzaToppingsList")).setListData(model.getCatalog().getToppings().toArray());
        if(order != null) {
            if (order.getOrderItems().size() != 0) {
                ((JList) components.get("pizzaList")).setListData(order.getOrderItems().toArray());
                ((JTextField) components.get("totalDisplay")).setText(model.TOTAL_TEXT + order.getOrderTotal());
            } else {
                ((JList) components.get("pizzaList")).setListData(new String[0]);
                ((JTextField) components.get("totalDisplay")).setText("");
            }
        }
    }
}
