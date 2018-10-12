package gui;

import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import lombok.Getter;
import lombok.Setter;

public class ElementsHandler {

    @Getter @Setter private Scene primaryScene;
    @Getter @Setter private VBox main;

    private static ElementsHandler ourInstance = new ElementsHandler();
    public static ElementsHandler getInstance() {
        return ourInstance;
    }
    private ElementsHandler() {}
}
