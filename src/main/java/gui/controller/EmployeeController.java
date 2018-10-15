package gui.controller;

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
import gui.helper.BillingTableGenerator;
import gui.helper.EmployeeManagerWrapper;
import gui.helper.EmployeeRow;
import javafx.fxml.FXML;
import javafx.scene.text.Text;
import valueobj.human.ID;
import valueobj.human.IDType;
import valueobj.human.NameBuilder;
import valueobj.human.Sex;
import valueobj.money.Money;
import valueobj.place.AddressBuilder;
import valueobj.place.Country;
import valueobj.time.Age;

public class EmployeeController {

    @FXML Text id;
    @FXML PersonalController personalController;
    @FXML AddressController addressController;
    @FXML JobController jobController;

    public void setMode(String mode) {
        personalController.setMode(mode);
        addressController.setMode(mode);
        jobController.setMode(mode);
    }

    public void setEmployee(EmployeeRow e) {
        personalController.setFirstnameValue(e.getFirstname());
        personalController.setSurnameValue(e.getSurname());
        personalController.setBirthdateValue(e.getBirthdate());
        personalController.setPersonIDTypeValue(e.getHumanIDType());
        personalController.setPersonIDValue(e.getHumanId());
        personalController.setSexValue(e.getSex());
        personalController.applyValues();

        addressController.setCountryValue(e.getCountry());
        addressController.setRegionValue(e.getRegion());
        addressController.setCityValue(e.getCity());
        addressController.setStreetValue(e.getStreet());
        addressController.setStreetNumberValue(e.getStreetNumber());
        addressController.setHomeNumberValue(e.getHomeNumber());
        addressController.setPostalCodeValue(e.getPostalCode());
        addressController.applyValues();

        jobController.setPaymentValue(e.getNetEmploymentCost());
        jobController.setJobTitleValue(e.getJobTitle());
        jobController.setPaymentStrategyValue(e.getPaymentStrategy());
        jobController.setPaymentCurrencyValue(e.getPaymentCurrency());
        jobController.setPaymentTypeValue("Net Employment Cost");
        jobController.applyValues();

        id.setText(e.getEmployeeId());
    }

    public void save() throws Exception {

        NameBuilder.clear();
        System.out.println("Saved with firstname: " + personalController.getFirstnameValue());
        NameBuilder.setFirstname(personalController.getFirstnameValue());
        NameBuilder.setSurname(personalController.getSurnameValue());

        AddressBuilder.clear();
        AddressBuilder.setCountry(Country.POLAND); //xD
        AddressBuilder.setRegion(addressController.getRegionValue());
        AddressBuilder.setCityName(addressController.getCityValue());
        AddressBuilder.setStreet(addressController.getStreetValue());
        AddressBuilder.setStreetNumber(addressController.getStreetNumberValue());
        AddressBuilder.setHomeNumber(addressController.getHomeNumberValue());
        AddressBuilder.setPostalCode(addressController.getPostalCodeValue());

        PersonBuilder.clear();
        PersonBuilder.setId(new ID(personalController.getPersonIDTypeValue(), personalController.getPersonIDValue()));
        PersonBuilder.setName(NameBuilder.buildAndClear());
        PersonBuilder.setSex(new Sex(personalController.getSexValue()));
        PersonBuilder.setAge(new Age(personalController.getBirthdateValue()));
        PersonBuilder.setHomeAddress(AddressBuilder.buildAndClear());

        EmployeeBuilder.clear();
        EmployeeBuilder.setId(new ID(IDType.COMPANYID, id.getText()));
        EmployeeBuilder.setPerson(PersonBuilder.buildAndClear());

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

        Money salary = new Money(jobController.getPaymentValue(), jobController.getPaymentCurrencyValue());

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
        EmployeeManagerWrapper.getInstance().refresh();
        SceneSwitcher.getInstance().switchScene(BillingTableGenerator.getInstance().generate());
    }

    public void cancel() throws Exception {
        SceneSwitcher.getInstance().switchScene(BillingTableGenerator.getInstance().generate());
    }
}
