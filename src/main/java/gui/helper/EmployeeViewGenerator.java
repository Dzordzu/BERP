package gui.helper;

public class EmployeeViewGenerator {
    private static EmployeeViewGenerator ourInstance = new EmployeeViewGenerator();

    public static EmployeeViewGenerator getInstance() {
        return ourInstance;
    }

    private EmployeeViewGenerator() {
    }
}
