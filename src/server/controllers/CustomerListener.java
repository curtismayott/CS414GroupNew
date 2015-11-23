package server.controllers;

import server.objects.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.HashMap;

/**
 * Created by darkbobo on 10/24/15.
 */
public class CustomerListener extends MyActionListener {
    Order order;
    public CustomerListener(){
        components = new HashMap<>();
        orderID = -1;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        String command = actionEvent.getActionCommand();
        System.out.println(command);
        System.out.println(actionEvent.paramString());
        // add order to register (model)
        // give ID so AddOrderView can access
        JComponent clicked = ((JComponent)actionEvent.getSource());
        if((components.get("cancelButton")).equals(clicked)) {
            clearEditTextFields();
            manager.activateWindow(manager.CUSTOMER, manager.ORDER_LIST);
        } else if((components.get("clearButton")).equals(clicked)) {
            clearEditTextFields();
        } else if((components.get("saveButton")).equals(clicked)) {
            Address address = new Address();
            address.setStreetAddress(((JTextArea) components.get("streetEditText")).getText());
            address.setCity(((JTextArea) components.get("cityEditText")).getText());
            address.setState(((JTextArea) components.get("stateEditText")).getText());
            address.setZipcode(((JTextArea) components.get("zipEditText")).getText());

            Phone phone = new Phone();
            phone.setNumber(((JTextArea) components.get("phoneEditText")).getText());

            Person person = new Person(((JTextArea) components.get("nameEditText")).getText(), address, phone);

            if (order == null) {
                order = new Order();
                order.setCustomer(person);
                orderID = model.addOrder(order);
            } else {
                System.out.println("CustomerListener OrderID about to send: " + order.getOrderID());
                order.setCustomer(person);
            }
            if(((JComboBox)components.get("orderTypeCombo")).getSelectedItem().equals("Pickup")){
                order.setOrderType(ORDER_TYPE.PICK_UP);
            }else if(((JComboBox)components.get("orderTypeCombo")).getSelectedItem().equals("Carry Out")){
                order.setOrderType(ORDER_TYPE.CARRY_OUT);
            }else if(((JComboBox)components.get("orderTypeCombo")).getSelectedItem().equals("Delivery")){
                order.setOrderType(ORDER_TYPE.DELIVERY);
            }
            if(!verifyFields()) {
                System.out.println("OrderID: " + orderID);
                manager.passOrderID(manager.ORDER_EDIT, orderID);
                manager.activateWindow(manager.CUSTOMER, manager.ORDER_EDIT);
                orderID = -1;
                order = null;
            }else{
                JOptionPane.showMessageDialog(view, "Error: must enter required information."); //default button title*/

            }
        }else if(actionEvent.getActionCommand().equals("comboBoxChanged")){
            System.out.println(clicked);
            if(((JComboBox)clicked).getSelectedItem().equals("Carry Out")){
                ((JTextArea)(components.get("phoneEditText"))).setEditable(true);
                ((JTextArea)(components.get("nameEditText"))).setEditable(true);
                ((JTextArea)(components.get("streetEditText"))).setEditable(false);
                ((JTextArea)(components.get("cityEditText"))).setEditable(false);
                ((JTextArea)(components.get("stateEditText"))).setEditable(false);
                ((JTextArea)(components.get("zipEditText"))).setEditable(false);
            }else if(((JComboBox)clicked).getSelectedItem().equals("Pickup")){
                ((JTextArea)(components.get("nameEditText"))).setEditable(true);
                ((JTextArea)(components.get("phoneEditText"))).setEditable(false);
                ((JTextArea)(components.get("streetEditText"))).setEditable(false);
                ((JTextArea)(components.get("cityEditText"))).setEditable(false);
                ((JTextArea)(components.get("stateEditText"))).setEditable(false);
                ((JTextArea)(components.get("zipEditText"))).setEditable(false);
            }else if(((JComboBox)clicked).getSelectedItem().equals("Delivery")){
                ((JTextArea)(components.get("nameEditText"))).setEditable(true);
                ((JTextArea)(components.get("phoneEditText"))).setEditable(true);
                ((JTextArea)(components.get("streetEditText"))).setEditable(true);
                ((JTextArea)(components.get("cityEditText"))).setEditable(true);
                ((JTextArea)(components.get("stateEditText"))).setEditable(true);
                ((JTextArea)(components.get("zipEditText"))).setEditable(true);
            }
        }
    }

    public void clearEditTextFields(){
        ((JTextArea) components.get("phoneEditText")).setText("");
        ((JTextArea) components.get("nameEditText")).setText("");
        ((JTextArea) components.get("streetEditText")).setText("");
        ((JTextArea) components.get("cityEditText")).setText("");
        ((JTextArea) components.get("stateEditText")).setText("");
        ((JTextArea) components.get("zipEditText")).setText("");
    }

    @Override
    public void setOrderID(int orderID){
        if(orderID >= 0) {
            order = model.getOrder(orderID);
            this.orderID = orderID;
            System.out.println("CustomerListener OrderID: " + order.getOrderID());
            ((JTextArea) components.get("phoneEditText")).setText(order.getCustomer().getPhoneNumbers().get(0).getNumber());
            ((JTextArea) components.get("nameEditText")).setText(order.getCustomer().getName());
            ((JTextArea) components.get("streetEditText")).setText(order.getCustomer().getAddress(0).getStreetAddress());
            ((JTextArea) components.get("cityEditText")).setText(order.getCustomer().getAddress(0).getCity());
            ((JTextArea) components.get("stateEditText")).setText(order.getCustomer().getAddress(0).getState());
            ((JTextArea) components.get("zipEditText")).setText(order.getCustomer().getAddress(0).getZipcode());
            if(order.getOrderType() == ORDER_TYPE.PICK_UP){
                ((JComboBox)components.get("orderTypeCombo")).setSelectedItem("Pickup");
                ((JTextArea)(components.get("nameEditText"))).setEditable(true);
                ((JTextArea)(components.get("phoneEditText"))).setEditable(false);
                ((JTextArea)(components.get("streetEditText"))).setEditable(false);
                ((JTextArea)(components.get("cityEditText"))).setEditable(false);
                ((JTextArea)(components.get("stateEditText"))).setEditable(false);
                ((JTextArea)(components.get("zipEditText"))).setEditable(false);
            }else if(order.getOrderType() == ORDER_TYPE.CARRY_OUT){
                ((JComboBox)components.get("orderTypeCombo")).setSelectedItem("Carry Out");
                ((JTextArea)(components.get("nameEditText"))).setEditable(true);
                ((JTextArea)(components.get("phoneEditText"))).setEditable(true);
                ((JTextArea)(components.get("streetEditText"))).setEditable(false);
                ((JTextArea)(components.get("cityEditText"))).setEditable(false);
                ((JTextArea)(components.get("stateEditText"))).setEditable(false);
                ((JTextArea)(components.get("zipEditText"))).setEditable(false);
            }else if(order.getOrderType() == ORDER_TYPE.DELIVERY){
                ((JComboBox)components.get("orderTypeCombo")).setSelectedItem("Delivery");
                ((JTextArea)(components.get("nameEditText"))).setEditable(true);
                ((JTextArea)(components.get("phoneEditText"))).setEditable(true);
                ((JTextArea)(components.get("streetEditText"))).setEditable(true);
                ((JTextArea)(components.get("cityEditText"))).setEditable(true);
                ((JTextArea)(components.get("stateEditText"))).setEditable(true);
                ((JTextArea)(components.get("zipEditText"))).setEditable(true);
            }
        }else{
            clearEditTextFields();
        }
        components.get("phoneEditText").requestFocus();
    }
    public boolean verifyFields(){
        boolean showDialog = false;
        if(order.getOrderType() == ORDER_TYPE.CARRY_OUT &&
                (order.getCustomer().getName().equals("")
                        || order.getCustomer().getPhoneNumbers().get(0).getNumber().equals(""))
                ){
            showDialog = true;
        }else if(order.getOrderType() == ORDER_TYPE.DELIVERY &&
                (order.getCustomer().getName().equals("")
                        || order.getCustomer().getAddress(0).getCity().equals("")
                        || order.getCustomer().getAddress(0).getState().equals("")
                        || order.getCustomer().getAddress(0).getZipcode().equals("")
                        || order.getCustomer().getAddress(0).getStreetAddress().equals("")
                )
                ){
            showDialog = true;
        }else if(order.getOrderType() == ORDER_TYPE.PICK_UP && order.getCustomer().getName().equals("")){
            showDialog = true;
        }
        return showDialog;
    }
}
