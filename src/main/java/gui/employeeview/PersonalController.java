package gui.employeeview;

import business.person.Person;
import business.person.PersonBuilder;
import gui.ErrorDialogGenerator;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import logic.DataValidatorException;
import logic.human.NameBuilder;
import logic.human.Sex;
import logic.identity.IDType;
import logic.time.Age;
import lombok.Getter;
import lombok.Setter;

import java.util.zip.DataFormatException;

public class PersonalController {

    @FXML
    HBox personIDType, personID, firstname, surname, personSex, birthdate;
    @Getter
    @Setter
    private Person person;
    @Getter
    IDType idType;
    @Getter
    String id;

    public void setMode(String mode) {
        switch (mode) {
            case "EDIT_MODE":
                birthdate.setDisable(true);
                personSex.setDisable(true);
                break;
            case "VIEW_MODE":
                birthdate.setDisable(true);
                personSex.setDisable(true);
                firstname.setDisable(true);
                surname.setDisable(true);
                personIDType.setDisable(true);
                personID.setDisable(true);
        }
    }

    public void applyValues() throws Exception {
        ((MenuButton)personIDType.getChildren().get(1)).setText(person.getId().getType().toString());
        ((TextField)personID.getChildren().get(1)).setText(person.getId().getValue());
        ((TextField)firstname.getChildren().get(1)).setText(person.getName().getFirstname());
        ((TextField)surname.getChildren().get(1)).setText(person.getName().getSurname());
        ((MenuButton)personSex.getChildren().get(1)).setText(person.getSex().toString());
        ((DatePicker)birthdate.getChildren().get(1)).setValue(person.getAge().getBirthDate());

        changePersonIDType();
        changePersonID();
        changeFirstname();
        changeSurname();
        changeSex(person.getSex().toString());
        changeBirthdate();
    }

    public void changeFirstname() {
        NameBuilder.getInstance().setFirstname(((TextField)firstname.getChildren().get(1)).getText());
    }

    public void changeSurname() {
        NameBuilder.getInstance().setSurname(((TextField)surname.getChildren().get(1)).getText());
    }

    public void changePersonIDType() {
        ((MenuButton)personIDType.getChildren().get(1)).setText(IDType.PESEL.name());
        idType = IDType.PESEL;
    }

    public void changePersonID() {
        id = ((TextField)personID.getChildren().get(1)).getText();
    }

    public void changeSex(String value) {
        try {
            PersonBuilder.getInstance().setSex(Sex.get(value));
            ((MenuButton) (personSex.getChildren().get(1))).setText(value);
        } catch(DataValidatorException e) {
            ErrorDialogGenerator gen = new ErrorDialogGenerator(e.getMessage());
            gen.generate().showAndWait();
        }
    }

    public void changeMale() throws Exception {
        changeSex("male");
    }

    public void changeFemale() throws Exception {
        changeSex("female");
    }

    public void changeBirthdate() {
        PersonBuilder.getInstance().setAge(new Age(((DatePicker)birthdate.getChildren().get(1)).getValue()));
    }


}
