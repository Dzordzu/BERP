package gui.controller;

import gui.ElementsHandler;
import gui.SourceLoader;
import javafx.fxml.FXML;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.io.IOException;

public class EmployeesController {

    @FXML VBox employeesList;

    public void initialize() {
        ElementsHandler.getInstance().setEmployeesList(employeesList);
    }

    public void sayTest() {
        employeesList.getChildren().add(new Text("XD"));
        System.out.println("TEST");
    }

    public void loadSingleEmployee() throws IOException {
        SourceLoader.getInstance().loadMain("/employee.fxml");
    }



}