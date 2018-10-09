package business.payment;

import valueobj.money.Money;
import valueobj.money.tax.Assurances;
import valueobj.money.tax.PensionTax;
import valueobj.money.tax.Tax;
import valueobj.money.tax.TestPeriod;

public class BonusPayment implements PaymentStrategy{

    Money netEmploymentCost;
    Tax pensionTax = PensionTax.getInstance();
    Tax assurances = Assurances.getInstance();
    Tax testPeriod = TestPeriod.getInstance();

    @Override
    public String getPaymentName() {
        return "Standard Payment";
    }

    @Override
    public void setNetEmployeeSalary(Money salary) {
        salary = pensionTax.revertTax(salary);
        this.netEmploymentCost = testPeriod.applyTax(salary);
    }

    @Override
    public void setGrossEmploymentCost(Money cost) {
        this.netEmploymentCost = assurances.revertTax(cost);
    }

    @Override
    public Money getNetEmployeeSalary() {
        return pensionTax.applyTax(
                testPeriod.revertTax(this.netEmploymentCost)
        );
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
