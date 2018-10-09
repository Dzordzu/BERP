package gui.controller;

import gui.ElementsHandler;
import gui.SourceLoader;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;

import java.io.IOException;

public class BaseController {

    @FXML VBox mainContent;

    public void initialize() {
        ElementsHandler.getInstance().setMainContent(mainContent);
    }

    public void loadBillings() throws IOException {
        SourceLoader.getInstance().loadMain("/billings.fxml");
    }

    public void loadEmployees() throws IOException {
        SourceLoader.getInstance().loadMain("/employees.fxml");
    }

    public void loadAbout() throws IOException {
        SourceLoader.getInstance().loadMain("/about.fxml");
    }



}
