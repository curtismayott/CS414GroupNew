package controllers;

import java.awt.event.ActionEvent;
import java.util.HashMap;

/**
 * Created by darkbobo on 10/27/15.
 */
public class ManagerMainListener extends MyActionListener {

    public ManagerMainListener(){
        components = new HashMap<>();

    }
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        String command = actionEvent.getActionCommand();
        switch (command) {
            case "Manage Users":
                manager.activateWindow(manager.MANAGE_MAIN, manager.EMPLOYEE_EDIT);
                break;
            case "Manage Menu":
                manager.activateWindow(manager.MANAGE_MAIN, manager.MENU_EDIT);
                break;
            case "Back":
                manager.activateWindow(manager.MANAGE_MAIN, manager.MAIN_MENU);
                break;
        }
    }
}
