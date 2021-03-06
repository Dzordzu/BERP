package gui.employeeview;

import business.Employee;
import business.EmployeeBuilder;
import business.EmployeeManager;
import business.jobs.Job;
import business.locators.PaymentTypeServiceLocator;
import business.payment.PaymentStrategy;
import business.person.PersonBuilder;
import business.locators.JobsServiceLocator;
import business.locators.PaymentsServiceLocator;
import debug.Debugger;
import gui.AppMode;
import gui.ErrorDialogGenerator;
import gui.SceneSwitcher;
import gui.billingtable.BillingTableGenerator;
import javafx.fxml.FXML;
import javafx.scene.text.Text;
import logic.DataValidatorException;
import logic.human.NameBuilder;
import logic.identity.ID;
import logic.identity.IDType;
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

        if(mode.equals("CREATE_MODE")) {

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

    public void setEmployee(Employee e) throws Exception {
        personalController.setPerson(e.getPerson());
        personalController.applyValues();

        addressController.setAddress(e.getPerson().getHomeAddress());
        addressController.applyValues();

        jobController.setPaymentValue(e.getJob().getSalary().getNetEmploymentCost().getAmount());
        jobController.setJobTitleValue(e.getJob().getJobTitle());
        jobController.setPaymentStrategyValue(e.getJob().getSalary().getPaymentName());
        jobController.setPaymentCurrencyValue(e.getJob().getSalary().getGrossEmploymentCost().getCurrency().getCurrencyCode());
        jobController.setPaymentTypeValue(PaymentTypeServiceLocator.getInstance().getDefault());
        jobController.applyValues();

        id.setText(e.getId().getValue());
    }

    public void save() {

        try {
            PersonBuilder.getInstance().setId(new ID(personalController.getIdType(), personalController.getId()));
            PersonBuilder.getInstance().setName(NameBuilder.getInstance().buildAndClear());

            PersonBuilder.getInstance().setHomeAddress(AddressBuilder.getInstance().buildAndClear());

            EmployeeBuilder.clear();
            EmployeeBuilder.setId(new ID(IDType.COMPANYID, id.getText()));
            EmployeeBuilder.setPerson(PersonBuilder.getInstance().buildAndClear());


            // @NOTE @TODO Check if code is valid and secure
            PaymentStrategy strategy;
            strategy = (PaymentStrategy) PaymentsServiceLocator.getInstance().getMatching(jobController.getPaymentStrategyValue()).getClassRef().getConstructor().newInstance();

            // @NOTE @XXX Dangerous zone
            Money salary = new Money(jobController.getPaymentValue(), /*jobController.getPaymentCurrencyValue()*/"PLN");

            if(jobController.getPaymentTypeValue() != null) {
                strategy
                        .getClass()
                        .getMethod("set" + jobController.getPaymentTypeValue().getServiceName(), Money.class)
                        .invoke(strategy, salary);
            }
            else {
                throw new Exception("Chose no payment type");
            }

            Job job;
            Class jobClass = JobsServiceLocator.getInstance().getMatching(jobController.getJobTitleValue()).getClassRef();
            job = (Job) jobClass.getConstructor(PaymentStrategy.class).newInstance(strategy);
            System.out.println(job.getSalary().getPaymentName());

            EmployeeBuilder.setJob(job);
            EmployeeManager.getInstance().updateEmployee(EmployeeBuilder.buildAndClear());
            SceneSwitcher.getInstance().switchScene(BillingTableGenerator.getInstance().generate());

        } catch(DataValidatorException e) {
            ErrorDialogGenerator gen = new ErrorDialogGenerator(e.getMessage());
            gen.generate().showAndWait();
        }
        catch(Exception e) {
            new ErrorDialogGenerator("Whoops. Something went wrong. \nCheck if all fields are filled").generate().showAndWait();

            if(AppMode.getInstance().getMode() == AppMode.APP_MODE.DEBUG) {
                Debugger d = new Debugger("Employee Controller Debugger", System.out);
                d.debug(e);
            }

        }
    }

    public void cancel() throws Exception {
        SceneSwitcher.getInstance().switchScene(BillingTableGenerator.getInstance().generate());
    }
}
