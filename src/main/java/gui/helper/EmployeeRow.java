package gui.helper;

import business.Employee;
import lombok.Getter;
import valueobj.math.Percentage;

import java.time.LocalDate;

public class EmployeeRow {

    @Getter String fullnameLong, fullnameShort, humanId, humanIDType, firstname, surname, sex;
    @Getter String country, region, city, street, streetNumber, homeNumber, postalCode;
    @Getter String employeeId, paymentStrategy, paymentCurrency, jobTitle;
    @Getter double netEmployeeSalary, grossEmploymentCost;
    @Getter LocalDate birthdate;
    Percentage paymentDiff;

    public EmployeeRow(Employee employee) {
        country = employee.getPerson().getHomeAddress().getCountry().getFullName();
        region = employee.getPerson().getHomeAddress().getCity().getRegion();
        city = employee.getPerson().getHomeAddress().getCity().getName();
        street = employee.getPerson().getHomeAddress().getHome().getStreet();
        streetNumber = employee.getPerson().getHomeAddress().getHome().getStreetNumber();
        homeNumber = employee.getPerson().getHomeAddress().getHome().getNumber();
        postalCode = employee.getPerson().getHomeAddress().getHome().getPostalCode();

        humanIDType = employee.getPerson().getId().getType().name();
        humanId = employee.getPerson().getId().getValue();
        firstname = employee.getPerson().getName().getFirstname();
        surname = employee.getPerson().getName().getSurname();
        sex = employee.getPerson().getSex().toString();
        birthdate = employee.getPerson().getAge().getBirthDate();
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
