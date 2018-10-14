package gui.controller;

import business.Employee;
import gui.SceneSwitcher;
import gui.helper.BillingTableGenerator;
import gui.helper.EmployeeRow;
import javafx.fxml.FXML;

public class EmployeeController {

    @FXML PersonalController personalController;

    public void setMode(String mode) {
        switch(mode) {
            case "EDIT_MODE":
                personalController.setMode(mode);
                System.out.println(personalController);
                break;
        }
    }

    public void setEmployee(EmployeeRow e) {
        //personalController.setBirthdateValue(;
    }

    public void save() {
        System.out.println("TODO");
    }

    public void cancel() throws Exception {
        SceneSwitcher.getInstance().switchScene(BillingTableGenerator.getInstance().generate());
    }
}
