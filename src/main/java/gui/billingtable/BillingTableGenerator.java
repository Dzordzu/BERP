package gui.billingtable;

import business.Employee;
import business.EmployeeManager;
import gui.ContentGenerator;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableView;

public class BillingTableGenerator implements ContentGenerator<TableView> {
    private static BillingTableGenerator ourInstance = new BillingTableGenerator();
    public static BillingTableGenerator getInstance() {
        return ourInstance;
    }
    private BillingTableGenerator() {}

    public TableView generate() {

        TableView<Employee> tableView = new TableView<>();
        tableView.setItems(EmployeeManager.getInstance().getEmployees());

        for(Columns col: Columns.values()) {
            tableView.getColumns().add(col.getColumn());
        }

        tableView.setTableMenuButtonVisible(true);
        tableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        return tableView;

    }
}
