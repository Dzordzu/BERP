package business.locators;


/**
 * Dedicated for enums or lists handling info about registered services
 */
public interface ServiceLocatorEntries extends LocatorEntries {
    /**
     * UI name is the main identifier of the service within GUI, API etc.
     * @return UIName
     */
    String getUIName();

    /**
     * UI name is the main identifier of the service within GUI, API etc.
     * @return UIName
     */
    String getServiceName();

    /**
     * Class reference can be used to generate new instances of the class service.
     * <br>Example :
     * <code>
     * serviceLocatorEntryInstance.getClassRef().getConstructor().newInstance();
     *  </code>
     * @return UIName
     */
    Class getClassRef();
}
