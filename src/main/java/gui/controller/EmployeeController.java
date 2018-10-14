package gui.controller;

import gui.SceneSwitcher;
import gui.helper.BillingTableGenerator;
import gui.helper.EmployeeRow;
import javafx.fxml.FXML;

public class EmployeeController {

    @FXML PersonalController personalController;

    public void setMode(String mode) {
        personalController.setMode(mode);
    }

    public void setEmployee(EmployeeRow e) {
        personalController.setFirstnameValue(e.getFirstname());
        personalController.setSurnameValue(e.getSurname());
        personalController.setBirthdateValue(e.getBirthdate());
        personalController.setPersonIDTypeValue(e.getHumanIDType());
        personalController.setPersonIDValue(e.getHumanId());
        personalController.setSexValue(e.getSex());
        personalController.applyValues();
    }

    public void save() {
        System.out.println("TODO");
    }

    public void cancel() throws Exception {
        SceneSwitcher.getInstance().switchScene(BillingTableGenerator.getInstance().generate());
    }
}
