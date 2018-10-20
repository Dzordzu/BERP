package business.jobs;

import business.Registry;

/**
 * Enum where all jobs have to be registered
 */

public enum JobsRegistry implements Registry {
    Manager,
    JuniorDev
    ;

    String displayName;

    JobsRegistry(){}
    JobsRegistry(String displayName){ this.displayName = displayName; }

    public static JobsRegistry getDefault() {
        return JobsRegistry.JuniorDev;
    }

    public String toString() {
        return displayName == null ? this.name() : displayName;
    }
}
