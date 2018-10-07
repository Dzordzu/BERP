package business.payment;

import logic.valueobj.money.Money;

public interface PaymentStrategy {

	String getPaymentName();

	void setNetEmployeeSalary(Money salary);
	void setGrossEmploymentCost(Money cost);

	Money getNetEmployeeSalary();
	Money getGrossEmploymentCost();


	/**
	 * They are the same value
	 */
	void setNetEmploymentCost();
	void setGrossEmployeeSalary();

	Money getNetEmploymentCost();
	Money getGrossEmployeeSalary();


}
