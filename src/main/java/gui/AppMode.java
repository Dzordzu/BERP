package gui;

import lombok.Getter;
import lombok.Setter;

enum APP_MODE {
    DEBUG,
    NORMAL
}

/**
 * Predefines mode of the app
 */

public class AppMode {

    @Getter @Setter
    APP_MODE mode;

    private static AppMode ourInstance = new AppMode();
    public static AppMode getInstance() {
        return ourInstance;
    }
    private AppMode() { this.mode = APP_MODE.NORMAL; }
}
