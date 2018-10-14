package gui.helper;

import gui.ContentLoader;
import javafx.scene.Parent;

import java.io.IOException;

public class EmployeeViewGenerator {

    private static EmployeeViewGenerator ourInstance = new EmployeeViewGenerator();
    public static EmployeeViewGenerator getInstance() {
        return ourInstance;
    }
    private EmployeeViewGenerator() {}

    public Parent generate() throws IOException {

        return ContentLoader.getInstance().loadParent("fxml/employee.fxml");

    }
}
