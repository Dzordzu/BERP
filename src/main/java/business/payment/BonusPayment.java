package business.payment;

import valueobj.money.Money;

public class BonusPayment implements PaymentStrategy{

    public BonusPayment() {
    }

    @Override
    public String getPaymentName() {
        return "Bonus Payment";
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
    public void setNetEmploymentCost(Money cost) {

    }

    @Override
    public void setGrossEmployeeSalary(Money salary) {

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
