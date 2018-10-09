package business.payment;

import valueobj.money.Money;
import valueobj.money.tax.Assurances;
import valueobj.money.tax.PensionTax;
import valueobj.money.tax.Tax;

/**
 * @Facade
 */
public class StandardPayment implements PaymentStrategy {

	Money netEmploymentCost;
	Tax pensionTax = PensionTax.getInstance();
	Tax assurances = Assurances.getInstance();


	@Override
	public String getPaymentName() {
		return "Standard Payment";
	}

	@Override
	public void setNetEmployeeSalary(Money salary) {
		this.netEmploymentCost = pensionTax.revertTax(salary);
	}

	@Override
	public void setGrossEmploymentCost(Money cost) {
		this.netEmploymentCost = assurances.revertTax(cost);
	}

	@Override
	public Money getNetEmployeeSalary() {
		return pensionTax.applyTax(this.netEmploymentCost);
	}

	@Override
	public Money getGrossEmploymentCost() {
		return assurances.applyTax(this.netEmploymentCost);
	}

	@Override
	public void setNetEmploymentCost(Money cost) {
		this.netEmploymentCost = cost;
	}

	@Override
	public void setGrossEmployeeSalary(Money salary) {
		this.netEmploymentCost = salary;
	}

	@Override
	public Money getNetEmploymentCost() {
		return this.netEmploymentCost;
	}

	@Override
	public Money getGrossEmployeeSalary() {
		return this.netEmploymentCost;
	}


}
