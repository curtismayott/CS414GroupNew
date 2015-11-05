package controllers;

import objects.Employee;
import objects.ROLE;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.HashMap;

/**
 * Created by darkbobo on 10/25/15.
 */
public class MainMenuListener extends MyActionListener {
    public MainMenuListener(){
        components = new HashMap<>();
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent){
        System.out.println(actionEvent.getActionCommand());
        String authenticationKey;
        Employee e;
        switch (actionEvent.getActionCommand()){
            case "Orders":
                authenticationKey = (String)JOptionPane.showInputDialog(
                        view,
                        "Enter Authentication Code",
                        "Login",
                        JOptionPane.PLAIN_MESSAGE,
                        null,
                        null,
                        null);
                e = model.getEmployeeByAuth(authenticationKey);
                if (e != null) {
                    if (e.getRole() == ROLE.CASHIER || e.getRole() == ROLE.MANAGER) {
                        model.setLoggedInEmployee(e);
                        manager.activateWindow(manager.MAIN_MENU, manager.ORDER_LIST);
                        return;
                    }
                }
                break;

            case "Make Line View":
                authenticationKey = (String)JOptionPane.showInputDialog(
                        view,
                        "Enter Authentication Code",
                        "Login",
                        JOptionPane.PLAIN_MESSAGE,
                        null,
                        null,
                        null);
                e = model.getEmployeeByAuth(authenticationKey);
                if (e != null) {
                    if (e.getRole() == ROLE.CHEF || e.getRole() == ROLE.MANAGER) {
                        model.setLoggedInEmployee(e);
                        manager.activateWindow(manager.MAIN_MENU, manager.MAKE_LINE);
                        return;
                    }
                }
                break;

            case "Manager Controls":
                authenticationKey = (String)JOptionPane.showInputDialog(
                        view,
                        "Enter Authentication Code",
                        "Login",
                        JOptionPane.PLAIN_MESSAGE,
                        null,
                        null,
                        null);
                e = model.getEmployeeByAuth(authenticationKey);
                if (e != null) {
                    if (e.getRole() == ROLE.MANAGER) {
                        model.setLoggedInEmployee(e);
                        manager.activateWindow(manager.MAIN_MENU, manager.MANAGE_MAIN);
                        return;
                    }
                }
                break;

            default: break;
        }
    }
    public void clearEmployee() {
        //breaking MVC pattern... sorry
        model.clearLoggedInEmployee();
    }
}
