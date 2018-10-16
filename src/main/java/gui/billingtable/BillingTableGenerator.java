package gui.billingtable;

import gui.helper.EmployeeManagerWrapper;
import gui.helper.EmployeeRow;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableView;

public class BillingTableGenerator {
    private static BillingTableGenerator ourInstance = new BillingTableGenerator();
    public static BillingTableGenerator getInstance() {
        return ourInstance;
    }
    private BillingTableGenerator() {}

    public TableView generate() {

        TableView<EmployeeRow> tableView = new TableView<>();
        tableView.setItems(EmployeeManagerWrapper.getInstance().getEmployees());

        for(Columns col: Columns.values()) {
            tableView.getColumns().add(col.getTableViewColumn());
        }

        tableView.setTableMenuButtonVisible(true);
        tableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        return tableView;

    }
}
