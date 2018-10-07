package business;

import business.jobs.Job;
import business.person.Person;
import logic.valueobj.human.ID;

/**
 * @Entity Employee
 */
public class Employee {
	
	private ID id;
	private Person person;
	private Job job;

	public Employee(ID id, Person person, Job job) {
		this.id = id;
		this.person = person;
		this.job = job;
	}
	
	public ID getId() {
		return id;
	}
	
	public Job getJob() {
		return job;
	}

	public void changeJob(Job job) {
		this.job = job;
	}

	public Person getPerson() {
		return person;
	}
	
}
