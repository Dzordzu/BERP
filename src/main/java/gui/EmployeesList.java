package gui;

import business.person.Person;
import seeder.people.PeopleSeeder;

import java.util.List;
import java.util.Observable;

public class EmployeesList extends Observable {
    private static EmployeesList ourInstance = new EmployeesList();
    public static EmployeesList getInstance() {
        return ourInstance;
    }


    static List<Person> employees;

    private EmployeesList() {
    }

    public static List<Person> getEmployees() {
        return employees;
    }

    public void initialize() {
        employees = PeopleSeeder.getInstance().getPeople();
    }
}
