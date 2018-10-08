package logic.valueobj.money.tax;

import logic.valueobj.math.Percentage;
import logic.valueobj.money.Money;

import java.util.Currency;

public class PensionTax implements Tax {
    private static PensionTax ourInstance = new PensionTax();

    public static PensionTax getInstance() {
        return ourInstance;
    }

    private PensionTax() {}

    private Percentage percentage = new Percentage().setPercentage(82);

    @Override
    public String getDescription() {
        return "Pension tax is 18%. ";
    }

    @Override
    public Money applyTax(Money sum) {
        double value = sum.getAmount()*percentage.getFraction();
        return new Money(value, sum.getCurrency());
    }

    @Override
    public Money revertTax(Money sum) {
        double value = sum.getAmount()/percentage.getFraction();
        return new Money(value, sum.getCurrency());
    }
}
