package business.jobs;

import logic.valueobj.money.Money;

public abstract class Job {
	
	protected String jobName;
	private Money basePayment;
	
	Job(Money basePayment) {
		this.basePayment = basePayment;
	}
	
	public String getName() {
		return this.jobName;
	}
	public Money getBasePayment() {
		return this.basePayment;
	}
}
