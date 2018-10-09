package gui.controller.helpers;

import business.Employee;

public class BillingListRow {

    String ID, Name, PaymentStategy, GrossCost, EmployeeNetSalary;

    public BillingListRow(Employee e) {
        ID = e.getId().getValue();
        Name = e.getPerson().getName().toString();
        PaymentStategy = e.getJob().getSalary().getPaymentName();
        GrossCost = e.getJob().getSalary().getGrossEmploymentCost().toString();
        EmployeeNetSalary = e.getJob().getSalary().getNetEmployeeSalary().toString();
    }
}
