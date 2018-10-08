package gui.controller;

import gui.ElementsHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import java.io.IOException;

public class BaseController {

    @FXML VBox mainContent;

    public void initialize() {
        ElementsHandler.getInstance().setMainContent(mainContent);
    }


    public void loadBillings() throws IOException {
        TableView newLoadedPane =  FXMLLoader.load(getClass().getResource("/billings.fxml"));
        mainContent.getChildren().clear();
        mainContent.getChildren().add(newLoadedPane);
    }

    public void loadEmployees() throws IOException {
        ScrollPane newLoadedPane =  FXMLLoader.load(getClass().getResource("/employees.fxml"));
        mainContent.getChildren().clear();
        mainContent.getChildren().add(newLoadedPane);
    }


    public void loadAbout() throws IOException {
        Pane newLoadedPane =  FXMLLoader.load(getClass().getResource("/about.fxml"));
        mainContent.getChildren().clear();
        mainContent.getChildren().add(newLoadedPane);
    }



}
