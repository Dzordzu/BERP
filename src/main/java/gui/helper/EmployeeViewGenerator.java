package gui.helper;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Control;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class EmployeeViewGenerator {

    private static EmployeeViewGenerator ourInstance = new EmployeeViewGenerator();
    public static EmployeeViewGenerator getInstance() {
        return ourInstance;
    }
    private EmployeeViewGenerator() {}

    private Text createTextLabel() {
        return new Text("STH1: ");
    }

    private TextField createFieldInput() {
        return new TextField("STH");
    }

    private HBox createRow(String id, Text label, Control value) {
        HBox result = new HBox();
        result.setId(id);
        result.getChildren().add(label);
        result.getChildren().add(value);
        result.setPadding(new Insets(10));
        return result;
    }

    public VBox generate() {
        VBox vbox = new VBox();
        vbox.getChildren().add(
                createRow(
                        "NAME", createTextLabel(), createFieldInput()
                )
        );
        vbox.setAlignment(Pos.TOP_CENTER);
        vbox.setPadding(new Insets(20));
        return vbox;
    }
}
