package logic.valueobj.money.tax;

import logic.valueobj.math.Percentage;
import logic.valueobj.money.Money;

import java.util.Currency;

public class IncomeTax implements Tax {
    private static IncomeTax ourInstance = new IncomeTax();

    public static IncomeTax getInstance() {
        return ourInstance;
    }

    private IncomeTax() {}

    private Percentage percentage = new Percentage().setPercentage(118);

    @Override
    public String getDescription() {
        return "Income tax is 18%";
    }

    @Override
    public Money applyTax(Money sum) {
        long value = (long)(sum.getUnscaledAmmount()*percentage.getFraction());
        return new Money(value, Currency.getInstance("PLN"));
    }

    @Override
    public Money revertTax(Money sum) {
        long value = (long)(sum.getUnscaledAmmount()/percentage.getFraction());
        return new Money(value, Currency.getInstance("PLN"));
    }
}
