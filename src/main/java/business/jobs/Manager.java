package business.jobs;

import logic.valueobj.money.Money;

public class Manager extends Job {
	
	public Manager(Money basePayment) {
		super(basePayment);
		super.jobName = "Manager";
	}
	
	/*
	 * Example methods that differ each Job 
	 */
	public String[] getSubordinates() {return new String[] {"John", "Martin"};}
	public String getManagedBranch() {return "Killing Customers";}
	public void sendToTrainingCourse() {/*...*/}
	
	/*
	 * ...
	 */
	
}
