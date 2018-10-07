package business;

import logic.valueobj.human.ID;

import java.util.List;
import java.util.Observable;
import java.util.Vector;

/**
 * @AggregateRoot EmployeeManager
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

    private EmployeeManager(List<Employee> employees) {
        this.employees = (Vector<Employee>)employees;
    }

    public List<Employee> getEmployees() {
        return (List<Employee>)employees;
    }

    public Employee getEmployee(String id) {
        return employees.stream().filter(e -> e.getId().getValue() == id).findFirst().get();
    }
    public Employee getEmployee(ID id) {
        return employees.stream().filter(e -> e.getId() == id).findFirst().get();
    }

    public void hireEmployee(Employee employee) {
        employees.add(employee);
    }

    public void fireEmployee(String id) {
        employees.remove(this.getEmployee(id));
    }

    public void fireEmployee(ID id) {
        employees.remove(this.getEmployee(id));
    }


}
