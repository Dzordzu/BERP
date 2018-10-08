package gui;

import javafx.scene.layout.Pane;
import lombok.Getter;
import lombok.Setter;

public class ElementsHandler {
    private static ElementsHandler ourInstance = new ElementsHandler();
    public static ElementsHandler getInstance() {
        return ourInstance;
    }
    private ElementsHandler() {}

    @Getter @Setter private Pane mainContent;
}
