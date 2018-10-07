package business;

import business.jobs.Job;
import business.person.Person;
import logic.valueobj.human.ID;

public class EmployeeBuilder {
	
	private static ID id;
	private static Person person;
	private static Job job;

	public static void setId(ID id) {
		EmployeeBuilder.id = id;
	}


	public static void setPerson(Person person) {
		EmployeeBuilder.person = person;
	}


	public static void setJob(Job job) {
		EmployeeBuilder.job = job;
	}
	
	public static void clear() {
		id = null;
		person = null;
		job = null;
	}

	public static Employee build() {
		return new Employee(id, person, job);
	}
	
	public static Employee buildAndClear() {
		Employee result = build();
		clear();
		return result;
	}
}
