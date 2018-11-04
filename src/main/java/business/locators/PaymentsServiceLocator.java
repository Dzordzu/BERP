package business.locators;

import lombok.Getter;

public class PaymentsServiceLocator implements ServiceLocator {
    private static PaymentsServiceLocator ourInstance = new PaymentsServiceLocator();
    public static PaymentsServiceLocator getInstance() {
        return ourInstance;
    }
    private PaymentsServiceLocator() {}

    enum VALUES implements NormalLocatorEntries {
        StandardPayment("Standard Payment", "StandardPayment", business.payment.StandardPayment.class),
        TestPeriodPayment("Test Period Payment", "TestPeriodPayment", business.payment.TestPeriodPayment.class),
        BonusPayment("Bonus Payment", "BonusPayment", business.payment.BonusPayment.class),
        ;

        @Getter String UIName;
        @Getter String serviceName;
        @Getter Class classRef;

        VALUES(String UIName, String serviceName, Class classRef) {
            this.UIName = UIName;
            this.serviceName = serviceName;
            this.classRef = classRef;
        }
    }

    VALUES defaultValue = VALUES.StandardPayment;

    @Override
    public NormalLocatorEntries[] getValues() {
        return VALUES.values();
    }

    @Override
    public NormalLocatorEntries getDefault() {
        return defaultValue;
    }

    @Override
    public Boolean exists(String UIName) {
        for(VALUES v: VALUES.values()) {
            if(v.getUIName() == UIName) return true;
        }

        return false;
    }

    @Override
    public NormalLocatorEntries getMatching(String UIName) {
        for(VALUES v: VALUES.values()) {
            if(v.getUIName() == UIName) return v;
        }

        return null;
    }
}
