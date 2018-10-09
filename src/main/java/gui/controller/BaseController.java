package gui.controller;

import business.Employee;
import business.EmployeeManager;
import gui.ElementsHandler;
import gui.SourceLoader;
import gui.controller.helpers.BillingListRow;
import gui.controller.helpers.EmployeesListRow;
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

        TableColumn<BillingListRow,String> paymentCol = new TableColumn<BillingListRow,String>("Payment Strategy");
        paymentCol.setCellValueFactory(new PropertyValueFactory("PaymentStrategy"));

        TableColumn<BillingListRow,Double> grossCol = new TableColumn<BillingListRow,Double>("Gross Employment Cost ");
        grossCol.setCellValueFactory(new PropertyValueFactory("GrossCost"));

        TableColumn<BillingListRow,Double> salaryCol = new TableColumn<BillingListRow,Double>("Employee Net Salary");
        salaryCol.setCellValueFactory(new PropertyValueFactory("EmployeeNetSalary"));

        TableColumn<BillingListRow,Double> currencyCol = new TableColumn<BillingListRow,Double>("Currency");
        currencyCol.setCellValueFactory(new PropertyValueFactory("Currency"));

        table.getColumns().setAll(idCol, nameCol, paymentCol, grossCol, salaryCol, currencyCol);

        ElementsHandler.getInstance().getMainContent().getChildren().add(table);
    }

    public void loadEmployees() throws IOException {
        SourceLoader.getInstance().loadMain("/employees.fxml");
        VBox employeesList = ElementsHandler.getInstance().getEmployeesList();

        for(Employee e:EmployeeManager.getInstance().getEmployees()) {
            EmployeesListRow row = new EmployeesListRow(e);
            employeesList.getChildren().add(row.getFXML());
        }
    }

    public void loadAbout() throws IOException {
        SourceLoader.getInstance().loadMain("/about.fxml");
    }



}
