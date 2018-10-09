package gui;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Region;

import java.io.IOException;

public class SourceLoader {
    private static SourceLoader ourInstance = new SourceLoader();

    public static SourceLoader getInstance() {
        return ourInstance;
    }

    private SourceLoader() {}

    /**
     * Simple aliases
     */
    public Region getRegion(String source) throws IOException {
        return FXMLLoader.load(getClass().getResource(source));
    }

    public void clearMain() {
        ElementsHandler.getInstance().getMainContent().getChildren().clear();
    }

    public void loadMain(String source) throws IOException {
        Region newLoadedPane =  FXMLLoader.load(getClass().getResource(source));

        ElementsHandler.getInstance().getMainContent().getChildren().add(newLoadedPane);
    }
}
