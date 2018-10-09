package gui;

import business.Employee;
import business.EmployeeManager;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import seeder.job.EmployeeSeeder;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        /**
         * Fill employee manager with faked data
         */
        for(Employee e: EmployeeSeeder.getInstance().getEmployees()) {
            EmployeeManager.getInstance().hireEmployee(e);
        }

        /**
         * Prepare Elements handler that will pass global references to the FXML objects
         */
        ElementsHandler.getInstance();

        Parent root = FXMLLoader.load(getClass().getResource("/base.fxml"));
        primaryStage.setTitle("BERP");
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
