package controllers;

import objects.*;
import views.AddOrderView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
        switch (actionEvent.getActionCommand()){
            case "Cancel":
                clearEditTextFields();
                manager.activateWindow("customer", "orderList");
                break;
            case "Clear":
                clearEditTextFields();
                break;
            case "Save":
                Address address = new Address();
                address.setStreetAddress(((JTextArea) components.get("streetEditText")).getText());
                address.setCity(((JTextArea) components.get("cityEditText")).getText());
                address.setState(((JTextArea) components.get("stateEditText")).getText());
                address.setZipcode(((JTextArea) components.get("zipEditText")).getText());

                Phone phone = new Phone();
                phone.setNumber(((JTextArea) components.get("phoneEditText")).getText());

                Person person = new Person(((JTextArea) components.get("nameEditText")).getText(), address, phone);

                if(order == null){
                    order = new Order();
                    order.setCustomer(person);
                    orderID = model.addOrder(order);
                }
                else{
                    System.out.println("CustomerListener OrderID about to send: " + order.getOrderID());
                    order.setCustomer(person);
                }

                System.out.println("OrderID: " + orderID);
                manager.passOrderID(manager.ORDER_EDIT, orderID);
                manager.activateWindow(manager.CUSTOMER, manager.ORDER_EDIT);
                orderID = -1;
                order = null;
                break;
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
        }else{
            clearEditTextFields();
        }
    }
}
