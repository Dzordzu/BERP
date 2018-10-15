package business;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import valueobj.human.ID;

import java.util.List;
import java.util.Vector;

/**
 * @AggregateRoot EmployeeManager
 * There should be the only one instance in the whole app
 */

public class EmployeeManager {
    private static EmployeeManager ourInstance = new EmployeeManager();

    public static EmployeeManager getInstance() {
        return ourInstance;
    }

    Vector<Employee> employees;

    private EmployeeManager() {
        this.employees = new Vector<Employee>();
    }

    public Vector<Employee> getEmployees() {
        return employees;
    }

    public Employee getEmployee(String id) {
        return employees.stream().filter(e -> e.getId().getValue() == id).findFirst().get();
    }
    public Employee getEmployee(ID id) {
        try {
            return employees.stream().filter(e -> e.getId().getValue() == id.getValue()).findFirst().get();
        } catch(Exception e) {
            return null;
        }
    }

    public void hireEmployee(Employee employee) {
        employees.add(employee);
    }

    public void fireEmployee(String id) {
        employees.remove(this.getEmployee(id));
    }
    public void fireEmployee(ID id) {
        Employee e = this.getEmployee(id);
        if(e != null) employees.remove(e);
    }

    public void updateEmployee(Employee employee) {
        fireEmployee(employee.getId());
        hireEmployee(employee);
    }


}
