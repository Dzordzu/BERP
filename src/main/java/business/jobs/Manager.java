package business.jobs;

import business.payment.PaymentStrategy;

public class Manager extends Job {
	
	public Manager(PaymentStrategy salary) {
		super("Manager", salary);
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
