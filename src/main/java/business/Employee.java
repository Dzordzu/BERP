package business;

import business.jobs.Job;
import business.person.Person;
import logic.valueobj.human.ID;
import lombok.Getter;

/**
 * @Entity Employee
 */
public class Employee {
	
	@Getter private ID id;
	@Getter private Person person;
	@Getter private Job job;

	public Employee(ID id, Person person, Job job) {
		this.id = id;
		this.person = person;
		this.job = job;
	}

	public void changeJob(Job job) {
		this.job = job;
	}
	
}
