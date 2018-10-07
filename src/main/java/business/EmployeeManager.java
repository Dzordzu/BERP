package business;

import java.util.Vector;

/**
 * @AggregateRoot EmployeeManager - singleton
 */
public class EmployeeManager {
	
	private static EmployeeManager singleton = null;
	Vector<Employee> employees;
	
	private EmployeeManager() {}
	
	public static EmployeeManager getInstance() {
        if (singleton == null) 
            singleton = new EmployeeManager(); 
        return singleton; 
	}
	
	public void hireEmployee() {}
	public void fireEmployee() {}
}
