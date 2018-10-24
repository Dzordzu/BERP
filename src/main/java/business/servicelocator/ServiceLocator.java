package business.servicelocator;

/**
 * Provides info about registered services.
 */

public interface ServiceLocator {
    /**
     * @return values List of the registered services.
     */
    ServiceLocatorEntries[] getValues();

    /**
     * @return defaultService
     */
    ServiceLocatorEntries getDefault();

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
    ServiceLocatorEntries getMatching(String name);
}
