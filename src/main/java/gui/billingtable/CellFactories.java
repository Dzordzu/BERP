package gui.billingtable;

import business.Employee;
import business.EmployeeManager;
import gui.helper.EmployeeViewGenerator;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.TableColumn;
import javafx.util.Callback;
import lombok.Getter;

import java.io.IOException;

/**
 * Handles all the cell factories
 */

public enum CellFactories {
    Fire(
            ActionButtonTableCell.<Employee>forTableColumn("Fire", e -> {
                EmployeeManager.getInstance().fireEmployee(e);
                return e;
            })
    ),
    Edit(
            ActionButtonTableCell.<Employee>forTableColumn("Edit", e -> {
                try {
                    EmployeeViewGenerator.EDIT_MODE.generate(e);
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                return e;
            })
    ),
    View(
            ActionButtonTableCell.<Employee>forTableColumn("View", e -> {
                try {
                    EmployeeViewGenerator.VIEW_MODE.generate(e);
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                return e;
            })
    ),
    ;

    @Getter
    Callback<TableColumn.CellDataFeatures, ObservableValue> value;

    CellFactories(Callback callback) {
        this.value = callback;
    }
}
