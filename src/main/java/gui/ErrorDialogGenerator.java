package gui;

import javafx.scene.control.Alert;

public class ErrorDialogGenerator implements ContentGenerator<Alert> {

    String value;

    public ErrorDialogGenerator(String value) {
        this.value = value;
    }

    @Override
    public Alert generate() {
        return new Alert(Alert.AlertType.WARNING, value);
    }
}
