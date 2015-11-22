package server.controllers;

import org.codehaus.jackson.annotate.JsonIgnore;
import server.objects.Register;
import client.views.MyJFrame;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

/**
 * Created by darkbobo on 10/25/15.
 */
public class MyActionListener implements ActionListener, ListSelectionListener {
    public int orderID;
    @JsonIgnore
    public Register model;
    HashMap<String, JComponent> components;
    WindowManager manager;
    MyJFrame view;
    @Override
    public void actionPerformed(ActionEvent actionEvent) {

    }

    public void setOrderID(int orderID){
        this.orderID = orderID;
    }

    public void addModel(Register model){
        this.model = model;
    }

    public void addView(MyJFrame view){
        this.view = view;
    }

    public void addWindowManager(WindowManager manager){
        this.manager = manager;
    }

    public void registerComponent(String labelID, JComponent component){
        components.put(labelID, component);
    }

    public int getOrderID(){
        return orderID;
    }

    @Override
    public void valueChanged(ListSelectionEvent listSelectionEvent) {

    }

    public void resetView(){

    }
}
