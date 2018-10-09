package gui.controller.helpers;

import business.Employee;

public class EmployeesListRow {

    public String id;
    public String name;

    public EmployeesListRow(Employee e) {
        id = e.getId().getValue();
        name = e.getPerson().getName().toString();
    }
}
