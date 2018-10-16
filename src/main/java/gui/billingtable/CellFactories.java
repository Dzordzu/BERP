package gui.billingtable;

import business.Employee;
import business.EmployeeManager;
import gui.SceneSwitcher;
import gui.helper.EmployeeViewGenerator;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.TableColumn;
import javafx.util.Callback;
import lombok.Getter;

/**
 * Handles all CellFactories
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
                    SceneSwitcher.getInstance().switchScene(EmployeeViewGenerator.EDIT_MODE.generate(e));
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
                return e;
            })
    ),
    View(
            ActionButtonTableCell.<Employee>forTableColumn("View", e -> {
                try {
                    SceneSwitcher.getInstance().switchScene(EmployeeViewGenerator.VIEW_MODE.generate(e));
                } catch (Exception e1) {
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
