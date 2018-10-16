package logic.money.tax;

import logic.money.Money;

public interface Tax {
    /**
     * @return description String with basic tax implementation description. Can contain references to
     * external sources
     */
    String getDescription();

    /**
     * Applying taxes is never beneficial to the person. After using that method money has to be change in favour of
     * publican.
     * @param sum
     * @return sum New sum of Money that is worse for the tax target (payer);
     */
    Money applyTax(Money sum);

    /**
     * Reverting taxes should be beneficial for the tax payer. Ex. Employee will gain money, Employer will have lower costs of the employment
     * @param sum
     * @return New sum of Money that is better for the tax target (payer);
     */
    Money revertTax(Money sum);
}
