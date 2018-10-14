package gui.controller;

import javafx.fxml.FXML;
import javafx.scene.layout.HBox;
import lombok.Getter;
import lombok.Setter;

public class PersonalController {

    @FXML HBox personIDType, personID, firstname, surname, sex, birthdate;
    @Getter @Setter private String personIDTypeValue, personIDValue, firstnameValue, surnameValue, sexValue, birthdateValue;

    public void setMode(String mode) {
        switch(mode) {
            case "EDIT_MODE":
                birthdate.setDisable(true);
                sex.setDisable(true);
                break;
        }
    }


}
