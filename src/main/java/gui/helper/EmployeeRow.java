package gui.helper;

import business.Employee;
import lombok.Getter;

public class EmployeeRow {

    @Getter String fullnameLong, fullnameShort, humanId;
    @Getter String employeeId, paymentStrategy, paymentCurrency, jobTitle;
    @Getter double netEmployeeSalary, grossEmploymentCost;

    public EmployeeRow(Employee employee) {
        fullnameLong = employee.getPerson().getName().getFullName();
        fullnameShort = employee.getPerson().getName().toString();
        employeeId = employee.getId().getValue();
        paymentStrategy = employee.getJob().getSalary().getPaymentName();
        paymentCurrency = employee.getJob().getSalary().getNetEmploymentCost().getCurrency().getCurrencyCode();
        jobTitle = employee.getJob().getJobTitle();
        netEmployeeSalary = employee.getJob().getSalary().getNetEmployeeSalary().getAmount();
        grossEmploymentCost = employee.getJob().getSalary().getGrossEmploymentCost().getAmount();
    }
}
