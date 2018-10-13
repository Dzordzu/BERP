package gui.helper;

import business.Employee;
import lombok.Getter;
import valueobj.math.Percentage;

public class EmployeeRow {

    @Getter String fullnameLong, fullnameShort, humanId;
    @Getter String employeeId, paymentStrategy, paymentCurrency, jobTitle;
    @Getter double netEmployeeSalary, grossEmploymentCost;
    Percentage paymentDiff;

    public EmployeeRow(Employee employee) {
        fullnameLong = employee.getPerson().getName().getFullName();
        fullnameShort = employee.getPerson().getName().toString();
        employeeId = employee.getId().getValue();
        paymentStrategy = employee.getJob().getSalary().getPaymentName();
        paymentCurrency = employee.getJob().getSalary().getNetEmploymentCost().getCurrency().getCurrencyCode();
        jobTitle = employee.getJob().getJobTitle();
        netEmployeeSalary = employee.getJob().getSalary().getNetEmployeeSalary().getAmount();
        grossEmploymentCost = employee.getJob().getSalary().getGrossEmploymentCost().getAmount();
        paymentDiff = new Percentage().setFraction(netEmployeeSalary/grossEmploymentCost);
    }

    public final double getPaymentDiff() {
        return paymentDiff.getPercentage();
    }
}
