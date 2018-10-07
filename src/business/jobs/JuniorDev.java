package business.jobs;

import logic.valueobj.money.Money;

public class JuniorDev extends Job {
	
	public JuniorDev(Money basePayment) {
		super(basePayment);
		super.jobName = "JuniorDev";
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
