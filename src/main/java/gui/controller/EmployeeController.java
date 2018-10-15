package gui.controller;

import gui.SceneSwitcher;
import gui.helper.BillingTableGenerator;
import gui.helper.EmployeeRow;
import javafx.fxml.FXML;
import javafx.scene.text.Text;

public class EmployeeController {

    @FXML Text id;
    @FXML PersonalController personalController;
    @FXML AddressController addressController;
    @FXML JobController jobController;

    public void setMode(String mode) {
        personalController.setMode(mode);
        addressController.setMode(mode);
        jobController.setMode(mode);
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

        jobController.setPaymentValue(e.getNetEmploymentCost());
        jobController.setJobTitleValue(e.getJobTitle());
        jobController.setPaymentStrategyValue(e.getPaymentStrategy());
        jobController.setPaymentCurrencyValue(e.getPaymentCurrency());
        jobController.setPaymentTypeValue("Net Employment Cost");
        jobController.applyValues();

        id.setText(e.getEmployeeId());
    }

    public void save() {
        System.out.println("TODO");
    }

    public void cancel() throws Exception {
        SceneSwitcher.getInstance().switchScene(BillingTableGenerator.getInstance().generate());
    }
}
