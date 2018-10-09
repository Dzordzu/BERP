package gui.controller;

import business.Employee;
import business.EmployeeManager;
import gui.ElementsHandler;
import gui.SourceLoader;
import gui.controller.helpers.BillingListRow;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.util.Vector;

public class BaseController {

    @FXML VBox mainContent;

    public void initialize() {
        ElementsHandler.getInstance().setMainContent(mainContent);
    }

    public void loadBillings() throws IOException {
        //SourceLoader.getInstance().loadMain("/billings.fxml");
        SourceLoader.getInstance().clearMain();

        Vector<BillingListRow> blrv = new Vector<>();

        TableView<BillingListRow> table = new TableView<BillingListRow>();
        for(Employee e:EmployeeManager.getInstance().getEmployees()) {
            blrv.add(new BillingListRow(e));
        }

        ObservableList<BillingListRow> oblrv = FXCollections.observableList(blrv);
        table.setItems(oblrv);

        TableColumn<BillingListRow,String> idCol = new TableColumn<BillingListRow,String>("ID");
        idCol.setCellValueFactory(new PropertyValueFactory("ID"));

        TableColumn<BillingListRow,String> nameCol = new TableColumn<BillingListRow,String>("Name");
        nameCol.setCellValueFactory(new PropertyValueFactory("Name"));

        TableColumn<BillingListRow,String> paymentCol = new TableColumn<BillingListRow,String>("Payment Startegy");
        paymentCol.setCellValueFactory(new PropertyValueFactory("PaymentStrategy"));
//
//        TableColumn<BillingListRow,String> idCol = new TableColumn<BillingListRow,String>("ID");
//        idCol.setCellValueFactory(new PropertyValueFactory("ID"));
//
//        TableColumn<BillingListRow,String> idCol = new TableColumn<BillingListRow,String>("ID");
//        idCol.setCellValueFactory(new PropertyValueFactory("ID"));

        table.getColumns().setAll(idCol, nameCol, paymentCol);

        ElementsHandler.getInstance().getMainContent().getChildren().add(table);
    }

    public void loadEmployees() throws IOException {
        SourceLoader.getInstance().loadMain("/employees.fxml");
    }

    public void loadAbout() throws IOException {
        SourceLoader.getInstance().loadMain("/about.fxml");
    }



}
