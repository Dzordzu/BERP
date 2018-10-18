package gui.employeeview;

import javafx.fxml.FXML;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import logic.place.Address;
import logic.place.AddressBuilder;
import logic.place.Country;
import lombok.Getter;
import lombok.Setter;

public class AddressController {

    @FXML
    HBox country, region, city, street, streetNumber, homeNumber, postalCode;
    @Getter @Setter
    Address address;

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
        ((MenuButton)country.getChildren().get(1)).setText(address.getCountry().getName());
        ((TextField)region.getChildren().get(1)).setText(address.getCity().getRegion());
        ((TextField)city.getChildren().get(1)).setText(address.getCity().getName());
        ((TextField)street.getChildren().get(1)).setText(address.getHome().getStreet());
        ((TextField)streetNumber.getChildren().get(1)).setText(address.getHome().getStreetNumber());
        ((TextField)homeNumber.getChildren().get(1)).setText(address.getHome().getHomeNumber());
        ((TextField)postalCode.getChildren().get(1)).setText(address.getHome().getPostalCode());

        changeCountryTOPOLAND();
        changeRegion();
        changeCity();
        changeStreet();
        changeStreetNumber();
        changeHomeNumber();
        changePostalCode();
    }

    public void changeRegion() {
        AddressBuilder.getInstance().setRegion(((TextField)region.getChildren().get(1)).getText());
    }

    public void changeCity() {
        AddressBuilder.getInstance().setCityName(((TextField)city.getChildren().get(1)).getText());
    }

    public void changeStreet() {
        AddressBuilder.getInstance().setStreet(((TextField)street.getChildren().get(1)).getText());
    }

    public void changeStreetNumber() {
        AddressBuilder.getInstance().setStreetNumber(((TextField)streetNumber.getChildren().get(1)).getText());
    }

    public void changeHomeNumber() {
        AddressBuilder.getInstance().setHomeNumber(((TextField)homeNumber.getChildren().get(1)).getText());
    }

    public void changePostalCode() {
        AddressBuilder.getInstance().setPostalCode(((TextField)postalCode.getChildren().get(1)).getText());
    }

    public void changeCountryTOPOLAND() {
        ((MenuButton)country.getChildren().get(1)).setText(Country.POLAND.getName());
        AddressBuilder.getInstance().setCountry(Country.POLAND); //xD
    }


}
