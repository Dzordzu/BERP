package business.jobs;

import business.ServiceLocator;
import business.ServiceLocatorEntries;
import lombok.Getter;

public class JobsServiceLocator implements ServiceLocator {
    private static JobsServiceLocator ourInstance = new JobsServiceLocator();
    public static JobsServiceLocator getInstance() {
        return ourInstance;
    }
    private JobsServiceLocator() {}

    enum VALUES implements ServiceLocatorEntries {
        JuniorDev("Junior Dev", "JuniorDev", JuniorDev.class),
        Manager("Manager", "Manager", Manager.class)
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

    VALUES defaultValue = VALUES.JuniorDev;

    @Override
    public ServiceLocatorEntries[] getValues() {
        return VALUES.values();
    }

    @Override
    public ServiceLocatorEntries getDefault() {
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
    public ServiceLocatorEntries getMatching(String UIName) {
        for(VALUES v: VALUES.values()) {
            if(v.getUIName() == UIName) return v;
        }

        return null;
    }
}
