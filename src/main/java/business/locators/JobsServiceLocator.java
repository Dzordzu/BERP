package business.locators;

import lombok.Getter;

public class JobsServiceLocator implements ServiceLocator {
    private static JobsServiceLocator ourInstance = new JobsServiceLocator();
    public static JobsServiceLocator getInstance() {
        return ourInstance;
    }
    private JobsServiceLocator() {}

    enum VALUES implements NormalLocatorEntries {
        JuniorDev("Junior Dev", "JuniorDev", business.jobs.JuniorDev.class),
        Manager("Manager", "Manager", business.jobs.Manager.class)
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
            if(v.getUIName().equals(UIName)) return true;
        }

        return false;
    }

    @Override
    public NormalLocatorEntries getMatching(String UIName) {
        for(VALUES v: VALUES.values()) {
            if(v.getUIName().equals(UIName)) return v;
        }

        return null;
    }
}
