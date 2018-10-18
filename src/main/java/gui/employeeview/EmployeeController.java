package gui.employeeview;

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
import logic.money.Money;
import logic.place.AddressBuilder;

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
        personalController.setPerson(e.getPerson());
        personalController.applyValues();

        addressController.setAddress(e.getPerson().getHomeAddress());
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

        PersonBuilder.getInstance().setId(new ID(personalController.getIdType(), personalController.getId()));
        PersonBuilder.getInstance().setName(NameBuilder.getInstance().buildAndClear());
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
