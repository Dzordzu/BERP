package business.locators;

public class PaymentTypeServiceLocator implements ServiceLocator<SimpleLocatorEntries> {

    private static PaymentTypeServiceLocator ourInstance = new PaymentTypeServiceLocator();
    public static PaymentTypeServiceLocator getInstance() {
        return ourInstance;
    }
    private PaymentTypeServiceLocator() {}

    enum VALUES implements SimpleLocatorEntries {


        ;

        @Override
        public String getName() {
            return this.name();
        }
    }

    @Override
    public SimpleLocatorEntries[] getValues() {
        return new SimpleLocatorEntries[0];
    }

    @Override
    public SimpleLocatorEntries getDefault() {
        return null;
    }

    @Override
    public Boolean exists(String name) {
        return null;
    }

    @Override
    public SimpleLocatorEntries getMatching(String name) {
        return null;
    }
}
