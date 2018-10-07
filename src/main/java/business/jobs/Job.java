package business.jobs;

import business.payment.PaymentStrategy;

public abstract class Job {

	protected String jobTitle;
	protected PaymentStrategy salary;

	Job(String jobTitle, PaymentStrategy salary) {
		this.jobTitle = jobTitle;
		this.salary = salary;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public PaymentStrategy getSalary() {
		return salary;
	}
}
