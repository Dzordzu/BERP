package gui.helper;

import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class BillingTableGenerator {
    private static BillingTableGenerator ourInstance = new BillingTableGenerator();
    public static BillingTableGenerator getInstance() {
        return ourInstance;
    }
    private BillingTableGenerator() {}

    private <T> TableColumn column(String propVal, String text) {
        TableColumn<EmployeeRow,T> prop = new TableColumn<>(text);
        prop.setCellValueFactory(new PropertyValueFactory(propVal));
        return prop;
    }

    public TableView generate() {

        TableView<EmployeeRow> tableView = new TableView<>();
        tableView.setItems(EmployeeManagerWrapper.getInstance().getEmployees());

        tableView.getColumns().setAll(
                column("employeeId", "ID"),
                column("fullnameShort", "Name"),
                column("jobTitle", "Position"),
                column("paymentStrategy", "Payment Strategy"),
                column("netEmployeeSalary", "Net Employee Salary"),
                column("grossEmploymentCost", "Gross Employment Cost"),
                column("paymentCurrency", "Currency")
        );

        tableView.setTableMenuButtonVisible(true);
        tableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        return tableView;

    }
}
