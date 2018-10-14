package gui.controller;

import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.chrono.Chronology;

public class PersonalController {

    @FXML
    HBox personIDType, personID, firstname, surname, sex, birthdate;
    @Getter
    @Setter
    private String personIDTypeValue, personIDValue, firstnameValue, surnameValue, sexValue;
    @Getter
    @Setter
    private LocalDate birthdateValue;

    public void setMode(String mode) {
        switch (mode) {
            case "EDIT_MODE":
                birthdate.setDisable(true);
                sex.setDisable(true);
                break;
            case "VIEW_MODE":
                birthdate.setDisable(true);
                sex.setDisable(true);
                firstname.setDisable(true);
                surname.setDisable(true);
                personIDType.setDisable(true);
                personID.setDisable(true);
        }
    }

    public void applyValues() {
        ((SplitMenuButton)personIDType.getChildren().get(1)).setText(personIDTypeValue);
        ((TextField)personID.getChildren().get(1)).setText(personIDValue);
        ((TextField)firstname.getChildren().get(1)).setText(firstnameValue);
        ((TextField)surname.getChildren().get(1)).setText(surnameValue);
        ((SplitMenuButton)sex.getChildren().get(1)).setText(sexValue);
        ((DatePicker)birthdate.getChildren().get(1)).setValue(birthdateValue);
    }


}
