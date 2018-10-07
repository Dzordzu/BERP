package business.payment.startegy;

import logic.valueobj.money.Money;

public interface PaymentStrategy {
	
	public String getExplanation();
	
//	public void setNetEmployerCost();
	public void setNetEmployeeSalary(Money salary);
	public void setGrossEmployerCost(Money cost);
//	public void setGrossEmployeeSalary();
	
//	public Money getNetEmployerCost();
	public Money getNetEmployeeSalary();
	public Money getGrossEmployerCost();
//	public Money getGrossEmployeeSalary();
}
