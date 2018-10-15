package gui.helper;

import gui.controller.EmployeeController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

import java.io.IOException;

public enum EmployeeViewGenerator {

    VIEW_MODE,
    CREATE_MODE,
    EDIT_MODE
    ;

    public Parent generate(EmployeeRow e) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("fxml/employee.fxml"));
        Parent result = loader.load();
        EmployeeController resultController = loader.getController();
        resultController.setEmployee(e);
        resultController.setMode(this.name());
        return result;
    }

    public Parent generate() throws IOException {

        /*
         * @NOTE We could not use here ContentLoader. We have to gain access to the employee.fxml
         *  controller. It's why we are using manual method
         */
        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("fxml/employee.fxml"));
        Parent result = loader.load();
        EmployeeController resultController = loader.getController();
        resultController.setMode(this.name());
        return result;
    }
}
