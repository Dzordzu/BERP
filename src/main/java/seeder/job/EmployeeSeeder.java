package seeder.job;

import business.Employee;
import business.jobs.Job;
import business.person.Person;
import logic.valueobj.human.ID;
import seeder.Seeder;
import seeder.people.PeopleSeeder;

import java.util.List;
import java.util.Vector;

public class EmployeeSeeder implements Seeder {
    private static EmployeeSeeder ourInstance;

    static {
        try {
            ourInstance = new EmployeeSeeder();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static EmployeeSeeder getInstance() {
        return ourInstance;
    }

    List<Employee> employees;

    private EmployeeSeeder() throws Exception {
        List<Person> people = PeopleSeeder.getInstance().getPeople();
        List<ID> ids = IDCompanyFileReader.getInstance().getList();
        List<Job> job = JobFileReader.getInstance().getList();

        Vector<Employee> employees = new Vector<>();

        for(int i=0; i<100; i++) {
            employees.add(new Employee(ids.get(i), people.get(i), job.get(i)));
        }

        this.employees = employees;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void seed(){}
}
