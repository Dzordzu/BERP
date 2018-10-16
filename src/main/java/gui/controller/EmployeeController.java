package gui.controller;

import business.Employee;
import business.EmployeeBuilder;
import business.EmployeeManager;
import business.jobs.Job;
import business.jobs.JuniorDev;
import business.jobs.Manager;
import business.payment.BonusPayment;
import business.payment.PaymentStrategy;
import business.payment.StandardPayment;
import business.payment.TestPeriodPayment;
import business.person.PersonBuilder;
import gui.SceneSwitcher;
import gui.billingtable.BillingTableGenerator;
import javafx.fxml.FXML;
import javafx.scene.text.Text;
import logic.identity.ID;
import logic.identity.IDType;
import logic.human.NameBuilder;
import logic.human.Sex;
import logic.money.Money;
import logic.place.AddressBuilder;
import logic.place.Country;
import logic.time.Age;

import java.time.LocalTime;
import java.util.Random;

public class EmployeeController {

    @FXML Text id;
    @FXML PersonalController personalController;
    @FXML AddressController addressController;
    @FXML JobController jobController;

    public void setMode(String mode) {

        if(mode == "CREATE_MODE") {

            // @TODO Prepare idGeneratorClass
            Random idGenerator = new Random();
            idGenerator.setSeed(LocalTime.now().toNanoOfDay());
            long symbolCode = ((idGenerator.nextInt() & 0xffffffffL)%24)+97;
            long number = ((idGenerator.nextInt() & 0xffffffffL)%90)+10;
            long idnum = ((idGenerator.nextInt() & 0xffffffffL)%9000)+1000;
            id.setText(number + "" + (char)symbolCode + "-" + idnum);
        }

        personalController.setMode(mode);
        addressController.setMode(mode);
        jobController.setMode(mode);
    }

    public void setEmployee(Employee e) {
        personalController.setFirstnameValue(e.getPerson().getName().getFirstname());
        personalController.setSurnameValue(e.getPerson().getName().getSurname());
        personalController.setBirthdateValue(e.getPerson().getAge().getBirthDate());
        personalController.setPersonIDTypeValue(e.getPerson().getId().getType());
        personalController.setPersonIDValue(e.getPerson().getId().getValue());
        personalController.setSexValue(e.getPerson().getSex().toString());
        personalController.applyValues();

        addressController.setCountryValue(e.getPerson().getHomeAddress().getCountry().getName());
        addressController.setRegionValue(e.getPerson().getHomeAddress().getCity().getRegion());
        addressController.setCityValue(e.getPerson().getHomeAddress().getCity().getName());
        addressController.setStreetValue(e.getPerson().getHomeAddress().getHome().getStreet());
        addressController.setStreetNumberValue(e.getPerson().getHomeAddress().getHome().getStreetNumber());
        addressController.setHomeNumberValue(e.getPerson().getHomeAddress().getHome().getHomeNumber());
        addressController.setPostalCodeValue(e.getPerson().getHomeAddress().getHome().getPostalCode());
        addressController.applyValues();

        jobController.setPaymentValue(e.getJob().getSalary().getNetEmploymentCost().getAmount());
        jobController.setJobTitleValue(e.getJob().getJobTitle());
        jobController.setPaymentStrategyValue(e.getJob().getSalary().getPaymentName());
        jobController.setPaymentCurrencyValue(e.getJob().getSalary().getGrossEmploymentCost().getCurrency().getCurrencyCode());
        jobController.setPaymentTypeValue("Net Employment Cost");
        jobController.applyValues();

        id.setText(e.getId().getValue());
    }

    public void save() throws Exception {

        NameBuilder.getInstance().clear();
        NameBuilder.getInstance().setFirstname(personalController.getFirstnameValue());
        NameBuilder.getInstance().setSurname(personalController.getSurnameValue());

        AddressBuilder.getInstance().clear();
        AddressBuilder.getInstance().setCountry(Country.POLAND); //xD
        AddressBuilder.getInstance().setRegion(addressController.getRegionValue());
        AddressBuilder.getInstance().setCityName(addressController.getCityValue());
        AddressBuilder.getInstance().setStreet(addressController.getStreetValue());
        AddressBuilder.getInstance().setStreetNumber(addressController.getStreetNumberValue());
        AddressBuilder.getInstance().setHomeNumber(addressController.getHomeNumberValue());
        AddressBuilder.getInstance().setPostalCode(addressController.getPostalCodeValue());

        PersonBuilder.getInstance().clear();
        PersonBuilder.getInstance().setId(new ID(personalController.getPersonIDTypeValue(), personalController.getPersonIDValue()));
        PersonBuilder.getInstance().setName(NameBuilder.getInstance().buildAndClear());
        PersonBuilder.getInstance().setSex(new Sex(personalController.getSexValue()));
        PersonBuilder.getInstance().setAge(new Age(personalController.getBirthdateValue()));
        PersonBuilder.getInstance().setHomeAddress(AddressBuilder.getInstance().buildAndClear());

        EmployeeBuilder.clear();
        EmployeeBuilder.setId(new ID(IDType.COMPANYID, id.getText()));
        EmployeeBuilder.setPerson(PersonBuilder.getInstance().buildAndClear());

        PaymentStrategy strategy;

        switch(jobController.getPaymentStrategyValue()) {
            case "Bonus Payment":
            case "Bonus":
                strategy = new BonusPayment();
                break;
            case "Test Period":
            case "Test Period Payment":
                strategy = new TestPeriodPayment();
                break;
            case "Standard":
            case "Standard Payment":
                strategy = new StandardPayment();
                break;
            default:
                throw new Exception("Chose no payment strategy");
        }

        // @NOTE @XXX Dangerous zone
        Money salary = new Money(jobController.getPaymentValue(), /*jobController.getPaymentCurrencyValue()*/"PLN");

        switch(jobController.getPaymentTypeValue()) {
            case "Net Employment Cost":
                strategy.setNetEmploymentCost(salary);
                break;
            case "Gross Employment Cost":
                strategy.setGrossEmploymentCost(salary);
                break;
            case "Net Employee Salary":
                strategy.setNetEmployeeSalary(salary);
                break;
            default:
                throw new Exception("Chose no payment type");
        }

        Job job;

        switch(jobController.getJobTitleValue()) {
            case "Manager":
                job = new Manager(strategy);
                break;
            case "JuniorDev":
                job = new JuniorDev(strategy);
                break;
            default:
                throw new Exception("Chose no job");

        }

        EmployeeBuilder.setJob(job);
        EmployeeManager.getInstance().updateEmployee(EmployeeBuilder.buildAndClear());
        SceneSwitcher.getInstance().switchScene(BillingTableGenerator.getInstance().generate());
    }

    public void cancel() throws Exception {
        SceneSwitcher.getInstance().switchScene(BillingTableGenerator.getInstance().generate());
    }
}
