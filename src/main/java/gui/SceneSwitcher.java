package gui;

import javafx.scene.Node;

import java.nio.file.Path;

public class SceneSwitcher {

    private Node main = ElementsHandler.getInstance().getMain();

    private static SceneSwitcher ourInstance = new SceneSwitcher();
    public static SceneSwitcher getInstance() {
        return ourInstance;
    }
    private SceneSwitcher() {}

    public void removeScene() {
        ElementsHandler.getInstance().getMain().getChildren().remove(1);
    }

    public void switchScene(Path path) {}
    public void switchScene(Node node) {}

}
