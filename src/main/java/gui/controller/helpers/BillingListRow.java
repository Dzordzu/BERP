package gui.controller.helpers;

import business.Employee;

public class BillingListRow {

    String ID;
    String Name;
    String PaymentStrategy;
    String GrossCost;
    String EmployeeNetSalary;

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPaymentStrategy() {
        return PaymentStrategy;
    }

    public void setPaymentStrategy(String paymentStategy) {
        PaymentStrategy = paymentStategy;
    }

    public String getGrossCost() {
        return GrossCost;
    }

    public void setGrossCost(String grossCost) {
        GrossCost = grossCost;
    }

    public String getEmployeeNetSalary() {
        return EmployeeNetSalary;
    }

    public void setEmployeeNetSalary(String employeeNetSalary) {
        EmployeeNetSalary = employeeNetSalary;
    }

    public BillingListRow(Employee e) {
        ID = e.getId().getValue();
        Name = e.getPerson().getName().toString();
        PaymentStrategy = e.getJob().getSalary().getPaymentName();
        GrossCost = e.getJob().getSalary().getGrossEmploymentCost().toString();
        EmployeeNetSalary = e.getJob().getSalary().getNetEmployeeSalary().toString();
    }
}
