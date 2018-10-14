package gui.controller;

import gui.SceneSwitcher;
import gui.helper.BillingTableGenerator;
import gui.helper.EmployeeRow;
import javafx.fxml.FXML;

public class EmployeeController {

    @FXML PersonalController personalController;
    @FXML AddressController addressController;

    public void setMode(String mode) {
        personalController.setMode(mode);
        addressController.setMode(mode);
    }

    public void setEmployee(EmployeeRow e) {
        personalController.setFirstnameValue(e.getFirstname());
        personalController.setSurnameValue(e.getSurname());
        personalController.setBirthdateValue(e.getBirthdate());
        personalController.setPersonIDTypeValue(e.getHumanIDType());
        personalController.setPersonIDValue(e.getHumanId());
        personalController.setSexValue(e.getSex());
        personalController.applyValues();

        addressController.setCountryValue(e.getCountry());
        addressController.setRegionValue(e.getRegion());
        addressController.setCityValue(e.getCity());
        addressController.setStreetValue(e.getStreet());
        addressController.setStreetNumberValue(e.getStreetNumber());
        addressController.setHomeNumberValue(e.getHomeNumber());
        addressController.setPostalCodeValue(e.getPostalCode());
        addressController.applyValues();
    }

    public void save() {
        System.out.println("TODO");
    }

    public void cancel() throws Exception {
        SceneSwitcher.getInstance().switchScene(BillingTableGenerator.getInstance().generate());
    }
}
