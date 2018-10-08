package logic.valueobj.money.tax;

import logic.valueobj.math.Percentage;
import logic.valueobj.money.Money;

import java.util.Currency;

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
        long value = (long)(sum.getAmount()*percentage.getFraction()) + 500;
        return new Money(value, Currency.getInstance("PLN"));
    }

    @Override
    public Money revertTax(Money sum) {
        long value = (long)((sum.getAmount() - 500)/percentage.getFraction());
        return new Money(value, Currency.getInstance("PLN"));
    }
}
