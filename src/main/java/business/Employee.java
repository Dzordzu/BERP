package business;

import business.jobs.Job;
import business.person.Person;
import logic.identity.ID;
import lombok.Getter;

/**
 * Employee entity. Identified by ID class. <br />
 * Employee has two unmodifiable properties - id and person - and the one that can be changed - job
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
