package gui.helper;

import gui.ContentLoader;
import javafx.geometry.Pos;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;

import java.io.IOException;

public class EmployeeViewGenerator {

    private static EmployeeViewGenerator ourInstance = new EmployeeViewGenerator();
    public static EmployeeViewGenerator getInstance() {
        return ourInstance;
    }
    private EmployeeViewGenerator() {}

    public ScrollPane generate() throws IOException {

        ScrollPane result = new ScrollPane();
        result.setFitToHeight(true);
        result.setFitToWidth(true);

        VBox wrapper = new VBox();
        wrapper.setAlignment(Pos.CENTER);

        wrapper.getChildren().addAll(
                ContentLoader.getInstance().loadParent("fxml/employee-topbar.fxml"),
                ContentLoader.getInstance().loadParent("fxml/employee-personal.fxml"),
                ContentLoader.getInstance().loadParent("fxml/employee-address.fxml"),
                ContentLoader.getInstance().loadParent("fxml/employee-job.fxml")
        );

        result.setContent(wrapper);

        return result;

    }
}
