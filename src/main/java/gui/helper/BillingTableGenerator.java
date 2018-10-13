package gui.helper;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
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

    private TableColumn<EmployeeRow, Button> fireColumn() {
        TableColumn<EmployeeRow, Button> fireColumn = new TableColumn<>("Fire");
        fireColumn.setCellFactory(ActionButtonTableCell.forTableColumn("Remove", (EmployeeRow p) -> {
            EmployeeManagerWrapper.getInstance().fireEmployee(p);
            return p;
        }));

        fireColumn.visibleProperty().setValue(false);

        return fireColumn;
    }

    public TableView generate() {

        TableView<EmployeeRow> tableView = new TableView<>();
        tableView.setItems(EmployeeManagerWrapper.getInstance().getEmployees());

        TableColumn paymentDiff = column("paymentDiff", "NES/GEC (%)");
        paymentDiff.visibleProperty().setValue(false);

        tableView.getColumns().setAll(
                column("employeeId", "ID"),
                column("fullnameShort", "Name"),
                column("jobTitle", "Position"),
                column("paymentStrategy", "Payment Strategy"),
                column("netEmployeeSalary", "Net Employee Salary"),
                column("grossEmploymentCost", "Gross Employment Cost"),
                column("paymentCurrency", "Currency"),
                paymentDiff,
                fireColumn()
        );

        tableView.setTableMenuButtonVisible(true);
        tableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        return tableView;

    }
}
