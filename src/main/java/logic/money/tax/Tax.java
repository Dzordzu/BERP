package logic.money.tax;

import logic.money.Money;

public interface Tax {
    String getDescription();
    Money applyTax(Money sum);
    Money revertTax(Money sum);
}
