package business;

public interface ServiceLocator {
    ServiceLocatorEntries[] getValues();
    ServiceLocatorEntries getDefault();
    Boolean exists(String name);
    ServiceLocatorEntries getMatching(String name);
}
