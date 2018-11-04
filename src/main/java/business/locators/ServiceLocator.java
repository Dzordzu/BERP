package business.locators;

/**
 * Provides info about registered services.
 */

public interface ServiceLocator {
    /**
     * @return values List of the registered services.
     */
    LocatorEntries[] getValues();

    /**
     * @return defaultService
     */
    LocatorEntries getDefault();

    /**
     * Checks if service with given name (registered within ServiceLocator implementation) exists
     * @param name
     */
    Boolean exists(String name);

    /**
     * Gets service with given name (registered within ServiceLocator implementation)
     * @param name
     * @return
     */
    LocatorEntries getMatching(String name);
}
