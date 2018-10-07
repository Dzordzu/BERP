package business.payment;

import logic.valueobj.money.Money;
import logic.valueobj.money.tax.IncomeTax;
import logic.valueobj.money.tax.Tax;

public class StandardPayment implements PaymentStrategy {

	Money grossEmploymentCost;
	Tax incomeTax = IncomeTax.getInstance();


	@Override
	public String getPaymentName() {
		return null;
	}

	@Override
	public void setNetEmployeeSalary(Money salary) {

	}

	@Override
	public void setGrossEmploymentCost(Money cost) {

	}

	@Override
	public Money getNetEmployeeSalary() {
		return null;
	}

	@Override
	public Money getGrossEmploymentCost() {
		return null;
	}

	@Override
	public void setNetEmploymentCost() {

	}

	@Override
	public void setGrossEmployeeSalary() {

	}

	@Override
	public Money getNetEmploymentCost() {
		return null;
	}

	@Override
	public Money getGrossEmployeeSalary() {
		return null;
	}
}
