package gui.controller;

import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.MenuButton;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import lombok.Getter;
import lombok.Setter;
import logic.human.IDType;

import java.time.LocalDate;

public class PersonalController {

    @FXML
    HBox personIDType, personID, firstname, surname, sex, birthdate;
    @Getter
    @Setter
    private String personIDValue, firstnameValue, surnameValue, sexValue;
    @Getter
    @Setter
    private IDType personIDTypeValue;
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
        // @NOTE @XXX Dangerous zone
        ((SplitMenuButton)personIDType.getChildren().get(1)).setText(/*personIDTypeValue.name()*/"PESEL");
        ((TextField)personID.getChildren().get(1)).setText(personIDValue);
        ((TextField)firstname.getChildren().get(1)).setText(firstnameValue);
        ((TextField)surname.getChildren().get(1)).setText(surnameValue);
        ((MenuButton)sex.getChildren().get(1)).setText(sexValue);
        ((DatePicker)birthdate.getChildren().get(1)).setValue(birthdateValue);
    }

    public void changeFirstname() {
        firstnameValue = ((TextField)firstname.getChildren().get(1)).getText();
    }

    public void changeSurname() {
       surnameValue = ((TextField)surname.getChildren().get(1)).getText();
    }

    public void changePersonID() {
        personIDValue = ((TextField)personID.getChildren().get(1)).getText();
    }

    public void changeMale() {
        String value = "male";
        ((MenuButton)(sex.getChildren().get(1))).setText(value);
        sexValue = value;
    }

    public void changeFemale() {
        String value = "female";
        ((MenuButton)(sex.getChildren().get(1))).setText(value);
        sexValue = value;
    }

    public void changeBirthdate() {
        birthdateValue = ((DatePicker)birthdate.getChildren().get(1)).getValue();
    }


}
