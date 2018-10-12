package gui.controller;

import business.EmployeeManager;
import gui.ElementsHandler;
import gui.SourceLoader;
import javafx.fxml.FXML;
import javafx.scene.text.Text;

import java.io.IOException;

public class EmployeeListRowController {

    @FXML Text id;

    public void getEmployeeDetails() throws IOException {
        SourceLoader.getInstance().loadMain("/employee.fxml");
    }
    public void fireEmployee() {
        EmployeeManager.getInstance().fireEmployee(id.getText());
        ElementsHandler.getInstance().getMainContent().getChildren().remove(this);
        //System.out.println(id.getText());
    }
}
