package business.jobs;

import business.payment.PaymentStrategy;

public class JuniorDev extends Job {
	
	public JuniorDev(PaymentStrategy salary) {
		super("Junior Dev", salary);
	}
	
	/*
	 * Example methods that differ each Job 
	 */
	public String getRepositoryLink() {return "Example.com";}
	public String getProgressData() {return "chart.jpg";}
	public String getTestResults() {return "testResult";}
	
	/*
	 * ...
	 */
	
	
	
	
	
}
