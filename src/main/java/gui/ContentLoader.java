package gui;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;

public class ContentLoader {
    private static ContentLoader ourInstance = new ContentLoader();
    public static ContentLoader getInstance() {
        return ourInstance;
    }
    private ContentLoader() {}

    public Parent loadParent(String path) throws IOException {
        URL url = this.getClass().getClassLoader().getResource(path);
        return FXMLLoader.load(Objects.requireNonNull(url));
    }
}
