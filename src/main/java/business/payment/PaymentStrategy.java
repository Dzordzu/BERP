package business.payment;

import logic.money.Money;

public interface PaymentStrategy {

	String getPaymentName();

	void setNetEmployeeSalary(Money salary);
	void setGrossEmploymentCost(Money cost);

	Money getNetEmployeeSalary();
	Money getGrossEmploymentCost();


	/*
	 * They are the same value
	 */
	void setNetEmploymentCost(Money cost);
	void setGrossEmployeeSalary(Money salary);

	Money getNetEmploymentCost();
	Money getGrossEmployeeSalary();


}
