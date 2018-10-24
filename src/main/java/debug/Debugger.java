package debug;

import java.io.PrintStream;

public class Debugger {

    String name;
    PrintStream stream;

    public Debugger(String name, PrintStream stream) {
        this.name = name;
        this.stream = stream;
    }

    public void debug(Exception e) {
        stream.println("ERROR in " + name);
        stream.println("Details: ");
        stream.println(e.getClass().getName());
        for(StackTraceElement el: e.getStackTrace()) {
            stream.println(el.getFileName());
            stream.println(el.getMethodName());
            stream.println(el.getLineNumber());
            stream.println(" --- ");
        }
    }
}
