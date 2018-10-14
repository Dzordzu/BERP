package gui;

import gui.helper.BillingTableGenerator;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import seeder.job.EmployeeSeeder;

public class App extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        EmployeeSeeder.getInstance().seed();

        VBox scene = new VBox();
        scene.setAlignment(Pos.TOP_CENTER);

        Parent topBar = ContentLoader.getInstance().loadParent("fxml/topbar.fxml");
        Parent about = ContentLoader.getInstance().loadParent("fxml/about.fxml");

        scene.getChildren().add(topBar);
        scene.getChildren().add(about);
        scene.setVgrow(about, Priority.ALWAYS);

        ElementsHandler.getInstance().setMain(scene);
        Scene primaryScene = new Scene(scene);
        ElementsHandler.getInstance().setPrimaryScene(primaryScene);
        primaryStage.setScene(primaryScene);
        SceneSwitcher.getInstance().switchScene(BillingTableGenerator.getInstance().generate());

        primaryStage.setTitle("BERP");
        primaryStage.show();

    }
}
