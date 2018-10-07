package gui.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.io.IOException;

public class EmployeesController {

    @FXML VBox employeesList;

    public void sayTest() {
        employeesList.getChildren().add(new Text("XD"));
        System.out.println("TEST");
    }

    public void loadSingleEmployee() throws IOException {
        Pane newLoadedPane =  FXMLLoader.load(getClass().getResource("/employee.fxml"));
        BaseController.mainContentS.getChildren().clear();
        BaseController.mainContentS.getChildren().add(newLoadedPane);
    }



}