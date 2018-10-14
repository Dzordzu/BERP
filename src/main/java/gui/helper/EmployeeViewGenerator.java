package gui.helper;

import gui.ContentLoader;
import javafx.scene.control.ScrollPane;

import java.io.IOException;

public class EmployeeViewGenerator {

    private static EmployeeViewGenerator ourInstance = new EmployeeViewGenerator();
    public static EmployeeViewGenerator getInstance() {
        return ourInstance;
    }
    private EmployeeViewGenerator() {}

    public ScrollPane generate() throws IOException {
        return (ScrollPane) ContentLoader.getInstance().loadParent("fxml/employee.fxml");

    }
}
