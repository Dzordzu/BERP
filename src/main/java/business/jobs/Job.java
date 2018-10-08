package business.jobs;

import business.payment.PaymentStrategy;
import lombok.Getter;

public abstract class Job {

	@Getter protected String jobTitle;
	@Getter protected PaymentStrategy salary;

	Job(String jobTitle, PaymentStrategy salary) {
		this.jobTitle = jobTitle;
		this.salary = salary;
	}
}
