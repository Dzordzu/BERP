package valueobj.money.tax;

import valueobj.money.Money;

public interface Tax {
    String getDescription();
    Money applyTax(Money sum);
    Money revertTax(Money sum);
}
