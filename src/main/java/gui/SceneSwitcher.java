package gui;

import javafx.scene.Node;
import javafx.scene.layout.Priority;

import java.io.IOException;

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

    public void switchScene(Node node) {
        removeScene();
        ElementsHandler.getInstance().getMain().getChildren().add(1, node);
        ElementsHandler.getInstance().getMain().setVgrow(node, Priority.ALWAYS);
    }

    public void switchScene(String path) throws IOException {
        Node scene = ContentLoader.getInstance().loadParent(path);
        this.switchScene(scene);
    }

}
