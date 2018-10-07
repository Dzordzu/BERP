package gui;

import business.Employee;
import business.EmployeeBuilder;
import business.person.PersonBuilder;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.io.IOException;
import java.util.List;

public class EmployeesController {

    @FXML VBox employeesList;

    public void initialize() {
    }

    public void sayTest() {
        employeesList.getChildren().add(new Text("XD"));
        System.out.println("TEST");
    }

    public void loadSingleEmployee() throws IOException {
        Pane newLoadedPane =  FXMLLoader.load(getClass().getResource("employee.fxml"));
        Controller.mainContentS.getChildren().clear();
        Controller.mainContentS.getChildren().add(newLoadedPane);
    }



}