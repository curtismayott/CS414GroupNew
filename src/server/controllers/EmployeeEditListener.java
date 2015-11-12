package server.controllers;

import server.objects.Address;
import server.objects.Employee;
import server.objects.Phone;
import server.objects.ROLE;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by darkbobo on 10/27/15.
 */
public class EmployeeEditListener extends MyActionListener {
    private Employee employee;

    public EmployeeEditListener(){
        components = new HashMap<>();
    }
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        String command = actionEvent.getActionCommand();
        switch (command){
            case "Back":
                manager.activateWindow(manager.EMPLOYEE_EDIT, manager.MANAGE_MAIN);
                resetView();
                break;
            case "Delete":
                if(employee != null) {
                    model.removeEmployee(employee);
                    resetView();
                }
                break;
            case "Set Authentication Code":
                if(employee == null){
                    JOptionPane.showMessageDialog(view,
                            "Must save user first",
                            "Error",
                            JOptionPane.PLAIN_MESSAGE);
                }else{
                    String authenticationKey = (String)JOptionPane.showInputDialog(
                            view,
                            "Enter Authentication Code",
                            "Code",
                            JOptionPane.PLAIN_MESSAGE,
                            null,
                            null,
                            null);
                    employee.setAuthentication(authenticationKey);
                    model.updateEmployee(employee.getUserID(), employee);
                }
                break;
            case "Cancel":
                resetView();
                break;
            case "Save":
                Address address = new Address();
                address.setCity(((JTextArea) components.get("cityEditText")).getText());
                address.setState(((JTextArea) components.get("stateEditText")).getText());
                address.setStreetAddress(((JTextArea) components.get("streetEditText")).getText());
                address.setZipcode(((JTextArea) components.get("zipEditText")).getText());
                ArrayList<Address> addresses = new ArrayList<>();
                addresses.add(address);

                Phone phone = new Phone(((JTextArea)components.get("phoneEditText")).getText());
                ArrayList<Phone> phones = new ArrayList<>();
                phones.add(phone);

                boolean isNew = false;
                if(employee == null){
                    // add new employee
                    employee = new Employee();
                    isNew = true;
                }
                employee.setAddresses(addresses);
                employee.setPhoneNumbers(phones);
                employee.setName(((JTextArea) components.get("nameEditText")).getText());
                employee.setUsername(((JTextArea) components.get("usernameEditText")).getText());

                switch ((ROLE)((JComboBox)components.get("roleComboBox")).getSelectedItem()){
                    case MANAGER:
                        employee.setRole(ROLE.MANAGER);
                        break;
                    case CASHIER:
                        employee.setRole(ROLE.CASHIER);
                        break;
                    case CHEF:
                        employee.setRole(ROLE.CHEF);
                        break;
                }

                if(isNew) {
                    model.addEmployee(employee);
                }else{
                    // save existing
                    model.updateEmployee(employee.getUserID(), employee);
                }
                resetView();
                break;
        }
    }
    @Override
    public void valueChanged(ListSelectionEvent event) {
        System.out.println(event.toString());
        JList list = (JList) event.getSource();
        if(list.getSelectedValue() != null) {
            String employeeButtonText = list.getSelectedValue().toString();
            employee = null;
            for (Employee emp : model.getEmployees()) {
                System.out.println(emp.toString());
                if (emp.toString().equals(employeeButtonText)) {
                    employee = emp;
                }
            }
            if (employee != null) {
                ((JTextArea) components.get("nameEditText")).setText(employee.getName());
                ((JTextArea) components.get("phoneEditText")).setText(employee.getPhoneNumbers().get(0).getNumber());
                ((JTextArea) components.get("streetEditText")).setText(employee.getAddress(0).getStreetAddress());
                ((JTextArea) components.get("cityEditText")).setText(employee.getAddress(0).getCity());
                ((JTextArea) components.get("stateEditText")).setText(employee.getAddress(0).getState());
                ((JTextArea) components.get("zipEditText")).setText(employee.getAddress(0).getZipcode());
                ((JTextArea) components.get("usernameEditText")).setText(employee.getUsername());
                ((JComboBox) components.get("roleComboBox")).setSelectedItem(employee.getRole());
            }
        }
    }

    public void resetView(){
        ((JList)components.get("employeeList")).setListData(model.getEmployees().toArray());
        clearEditTextFields();
        employee = null;
    }
    public void clearEditTextFields(){
        ((JTextArea)components.get("nameEditText")).setText("");
        ((JTextArea)components.get("phoneEditText")).setText("");
        ((JTextArea)components.get("streetEditText")).setText("");
        ((JTextArea)components.get("cityEditText")).setText("");
        ((JTextArea)components.get("stateEditText")).setText("");
        ((JTextArea)components.get("zipEditText")).setText("");
        ((JTextArea)components.get("usernameEditText")).setText("");
    }
}
