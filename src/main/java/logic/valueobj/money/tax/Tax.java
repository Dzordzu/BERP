package logic.valueobj.money.tax;

import logic.valueobj.money.Money;

public interface Tax {
    String getDescription();
    Money applyTax(Money sum);
    Money revertTax(Money sum);
}
