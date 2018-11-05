package business.locators;

public class PaymentTypeServiceLocator implements ServiceLocator<SimpleLocatorEntries> {

    private static PaymentTypeServiceLocator ourInstance = new PaymentTypeServiceLocator();
    public static PaymentTypeServiceLocator getInstance() {
        return ourInstance;
    }
    private PaymentTypeServiceLocator() {}

    enum VALUES implements SimpleLocatorEntries {
        NetEmploymentCost("Net Employment Cost"),
        GrossEmploymentCost("Gross Employment Cost"),
        NetEmployeeSalary("Net Employee Salary"),
        ;

        String name;

        VALUES(String name) {
            this.name = name;
        }

        @Override
        public String getServiceName() {
            return this.name();
        }

        @Override
        public String getUIName() {
            return this.name;
        }
    }

    VALUES defaultValue = VALUES.NetEmploymentCost;

    @Override
    public SimpleLocatorEntries[] getValues() {
        return VALUES.values();
    }

    @Override
    public SimpleLocatorEntries getDefault() {
        return defaultValue;
    }

    @Override
    public Boolean exists(String name) {
        return getMatching(name) != null;
    }

    @Override
    public SimpleLocatorEntries getMatching(String name) {
        for(VALUES v: VALUES.values()) {
            if(v.getUIName() == name) return v;
        }

        return null;
    }
}
