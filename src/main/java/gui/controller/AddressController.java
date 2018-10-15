package gui.controller;

import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

public class AddressController {

    @FXML
    HBox country, region, city, street, streetNumber, homeNumber, postalCode;
    @Getter
    @Setter
    private String countryValue, regionValue, cityValue, streetValue, streetNumberValue, homeNumberValue, postalCodeValue;

    public void setMode(String mode) {
        switch (mode) {
            case "EDIT_MODE":
                break;
            case "VIEW_MODE":
                country.setDisable(true);
                region.setDisable(true);
                city.setDisable(true);
                street.setDisable(true);
                streetNumber.setDisable(true);
                homeNumber.setDisable(true);
                postalCode.setDisable(true);
        }
    }

    public void applyValues() {
        ((SplitMenuButton)country.getChildren().get(1)).setText(countryValue);
        ((TextField)region.getChildren().get(1)).setText(regionValue);
        ((TextField)city.getChildren().get(1)).setText(cityValue);
        ((TextField)street.getChildren().get(1)).setText(streetValue);
        ((TextField)streetNumber.getChildren().get(1)).setText(streetNumberValue);
        ((TextField)homeNumber.getChildren().get(1)).setText(homeNumberValue);
        ((TextField)postalCode.getChildren().get(1)).setText(postalCodeValue);
    }

    public void changeRegion() {
        regionValue = ((TextField)region.getChildren().get(1)).getText();
    }

    public void changeCity() {
        cityValue = ((TextField)city.getChildren().get(1)).getText();
    }

    public void changeStreet() {
        streetValue = ((TextField)street.getChildren().get(1)).getText();
    }

    public void changeStreetNumber() {
        streetNumberValue = ((TextField)streetNumber.getChildren().get(1)).getText();
    }

    public void changeHomeNumber() {
        homeNumberValue = ((TextField)homeNumber.getChildren().get(1)).getText();
    }

    public void changePostalCode() {
        postalCodeValue = ((TextField)postalCode.getChildren().get(1)).getText();
    }


}
