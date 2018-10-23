package gui;

import lombok.Getter;
import lombok.Setter;


/**
 * Predefines mode of the app
 */

public class AppMode {

    public enum APP_MODE {
        DEBUG,
        NORMAL
    }

    @Getter @Setter
    APP_MODE mode;

    private static AppMode ourInstance = new AppMode();
    public static AppMode getInstance() {
        return ourInstance;
    }
    private AppMode() { this.mode = APP_MODE.NORMAL; }
}
