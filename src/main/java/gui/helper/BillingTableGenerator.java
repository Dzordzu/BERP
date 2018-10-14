package gui.helper;

import gui.SceneSwitcher;
import javafx.scene.control.Button;
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

    private TableColumn<EmployeeRow, Button> fireColumn() {
        TableColumn<EmployeeRow, Button> fireColumn = new TableColumn<>("Fire");
        fireColumn.setCellFactory(ActionButtonTableCell.forTableColumn("Remove", (EmployeeRow p) -> {
            EmployeeManagerWrapper.getInstance().fireEmployee(p);
            return p;
        }));

        fireColumn.visibleProperty().setValue(false);

        return fireColumn;
    }

    private TableColumn<EmployeeRow, Button> editColumn() {
        TableColumn<EmployeeRow, Button> editColumn = new TableColumn<>("Edit");
        editColumn.setCellFactory(ActionButtonTableCell.forTableColumn("Edit", (EmployeeRow p) -> {
            try {
                SceneSwitcher.getInstance().switchScene(EmployeeViewGenerator.EDIT_MODE.generate(p));
            } catch (Exception e) {
                e.printStackTrace();
            }
            return p;
        }));

        editColumn.visibleProperty().setValue(false);

        return editColumn;
    }

    private TableColumn<EmployeeRow, Button> viewColumn() {
        TableColumn<EmployeeRow, Button> viewColumn = new TableColumn<>("View");
        viewColumn.setCellFactory(ActionButtonTableCell.forTableColumn("View", (EmployeeRow p) -> {
            try {
                SceneSwitcher.getInstance().switchScene(EmployeeViewGenerator.VIEW_MODE.generate(p));
            } catch (Exception e) {
                e.printStackTrace();
            }
            return p;
        }));

        viewColumn.visibleProperty().setValue(false);

        return viewColumn;
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
                fireColumn(),
                editColumn(),
                viewColumn()
        );

        tableView.setTableMenuButtonVisible(true);
        tableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        return tableView;

    }
}
