package logic.money.tax;

import logic.money.Money;

public class TestPeriod implements Tax {

    private static TestPeriod ourInstance = new TestPeriod();

    public static TestPeriod getInstance() {
        return ourInstance;
    }

    private TestPeriod() {}

    @Override
    public String getDescription() {
        return "Simply descrease amount of the payment for the TestPeriod";
    }

    @Override
    public Money applyTax(Money sum) {
        return new Money(sum.getAmount()/2, sum.getCurrency());
    }

    @Override
    public Money revertTax(Money sum) {
        return new Money(sum.getAmount()*2, sum.getCurrency());
    }
}
