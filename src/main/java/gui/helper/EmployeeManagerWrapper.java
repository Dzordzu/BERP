package gui.helper;

import business.Employee;
import business.EmployeeManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.Vector;


/**
 * Converts Employee to EmployeeRow and creates list of it
 */
public class EmployeeManagerWrapper {

    private ObservableList<EmployeeRow> employees;

    private static EmployeeManagerWrapper ourInstance = new EmployeeManagerWrapper();
    public static EmployeeManagerWrapper getInstance() {
        return ourInstance;
    }
    private EmployeeManagerWrapper() {
        refresh();
    }

    public void refresh() {
        Vector<EmployeeRow> result = new Vector<>();
        for(Employee e: EmployeeManager.getInstance().getEmployees()) {
            result.add(new EmployeeRow(e));
        }

        this.employees = FXCollections.observableList(result);
    }

    public ObservableList<EmployeeRow> getEmployees() {
        return employees;
    }
    public void fireEmployee(EmployeeRow employee) {
        EmployeeManager.getInstance().fireEmployee(employee.getEmployeeId());
        employees.remove(employee);
    }
}
