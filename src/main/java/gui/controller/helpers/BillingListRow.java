package gui.controller.helpers;

import business.Employee;

public class BillingListRow {

    String ID;
    String Name;
    String PaymentStrategy;
    double GrossCost;
    double EmployeeNetSalary;

    public void setGrossCost(double grossCost) {
        GrossCost = grossCost;
    }

    public void setEmployeeNetSalary(double employeeNetSalary) {
        EmployeeNetSalary = employeeNetSalary;
    }

    public String getCurrency() {
        return Currency;
    }

    public void setCurrency(String currency) {
        Currency = currency;
    }

    String Currency;

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

    public double getGrossCost() {
        return GrossCost;
    }

    public double getEmployeeNetSalary() {
        return EmployeeNetSalary;
    }


    public BillingListRow(Employee e) {
        ID = e.getId().getValue();
        Name = e.getPerson().getName().toString();
        PaymentStrategy = e.getJob().getSalary().getPaymentName();
        GrossCost = e.getJob().getSalary().getGrossEmploymentCost().getAmount();
        EmployeeNetSalary = e.getJob().getSalary().getNetEmployeeSalary().getAmount();
        Currency = e.getJob().getSalary().getGrossEmployeeSalary().getCurrency().getCurrencyCode();
    }
}
