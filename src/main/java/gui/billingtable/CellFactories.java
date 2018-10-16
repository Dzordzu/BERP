package gui.billingtable;

import business.Employee;
import gui.helper.EmployeeManagerWrapper;
import gui.helper.EmployeeViewGenerator;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.TableColumn;
import javafx.util.Callback;
import lombok.Getter;

/**
 * Handles all the cell factories
 */

public enum CellFactories {
    Fire(
            ActionButtonTableCell.<Employee>forTableColumn("Fire", e -> {
                EmployeeManagerWrapper.getInstance().fireEmployee(e);
                return e;
            })
    ),
    Edit(
            ActionButtonTableCell.<Employee>forTableColumn("Edit", e -> {
                EmployeeViewGenerator.EDIT_MODE.generate(e);
                return e;
            })
    ),
    View(
            ActionButtonTableCell.<Employee>forTableColumn("View", e -> {
                EmployeeViewGenerator.VIEW_MODE.generate(e);
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
