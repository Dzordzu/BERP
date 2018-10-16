package logic.money.tax;

import logic.math.Percentage;
import logic.money.Money;

public class Assurances implements Tax {
    private static Assurances ourInstance = new Assurances();

    public static Assurances getInstance() {
        return ourInstance;
    }

    private Assurances() {}

    private Percentage percentage = new Percentage().setPercentage(122);

    @Override
    public String getDescription() {
        return "Income tax is 22% + 500PLN";
    }

    @Override
    public Money applyTax(Money sum) {
        double value = sum.getAmount()*percentage.getFraction() + 500;
        return new Money(value, sum.getCurrency());
    }

    @Override
    public Money revertTax(Money sum) {
        double value = (sum.getAmount() - 500)/percentage.getFraction();
        return new Money(value, sum.getCurrency());
    }
}
