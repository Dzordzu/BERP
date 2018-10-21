package business;

public interface ServiceLocator<Type> {
    ServiceLocatorEntries getValues();
    ServiceLocatorEntries getDefault();
    Boolean exists(String name);
    Class getMatching(String name);
}
