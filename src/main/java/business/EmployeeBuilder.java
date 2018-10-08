package business;

import business.jobs.Job;
import business.person.Person;
import logic.valueobj.human.ID;
import lombok.Setter;

public class EmployeeBuilder {
	
	@Setter private static ID id;
	@Setter private static Person person;
	@Setter private static Job job;
	
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
