package gui.helper;

import business.Employee;
import gui.ContentGenerator;
import gui.controller.EmployeeController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

import java.io.IOException;

public enum EmployeeViewGenerator implements ContentGenerator<Parent> {

    VIEW_MODE,
    CREATE_MODE,
    EDIT_MODE
    ;

    public Parent generate(Employee e) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("fxml/employee.fxml"));
        Parent result = loader.load();
        EmployeeController resultController = loader.getController();
        resultController.setEmployee(e);
        resultController.setMode(this.name());
        return result;
    }

    public Parent generate() {

        /*
         * @NOTE We could not use here ContentLoader. We have to gain access to the employee.fxml
         *  controller. It's why we are using manual method
         */
        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("fxml/employee.fxml"));
        Parent result = null;
        try {
            result = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        EmployeeController resultController = loader.getController();
        resultController.setMode(this.name());
        return result;
    }
}
