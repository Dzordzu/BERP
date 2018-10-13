package gui;

import javafx.scene.Node;
import javafx.scene.control.TableView;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

import java.io.IOException;

public class SceneSwitcher {

    private Node main = ElementsHandler.getInstance().getMain();

    private static SceneSwitcher ourInstance = new SceneSwitcher();
    public static SceneSwitcher getInstance() {
        return ourInstance;
    }
    private SceneSwitcher() {}

    private void removeScene() {
        ElementsHandler.getInstance().getMain().getChildren().remove(1);
    }

    private void loadTableView(TableView node) {
        ElementsHandler.getInstance().getMain().getChildren().add(1, node);
        VBox.setVgrow(node, Priority.ALWAYS);
    }

    public <T> void switchScene(T node) throws Exception {
        removeScene();
        if(node instanceof TableView) loadTableView((TableView) node);

        else throw new Exception("Unsuported type");
    }

    public <T> void switchScene(String path) throws Exception {
        T scene = (T)ContentLoader.getInstance().loadParent(path);
        this.<T>switchScene(scene);
    }

}
