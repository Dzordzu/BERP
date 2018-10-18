package business.payment;

import business.Registry;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Place where all payments have to be registered
 */

public enum PaymentsRegistry implements Registry {
    StandardPayment,
    BonusPayment,
    TestPeriodPayment
    ;

    PaymentsRegistry(){}

    public static Registry getDefault() {
        return PaymentsRegistry.StandardPayment;
    }

    public String toString() {
        String result;
        Pattern p = Pattern.compile("[A-Z][a-z]+");
        Matcher m = p.matcher(this.name());
        result = m.replaceAll("$1 ");
        return result.substring(0, result.length()-1);
    }
}
