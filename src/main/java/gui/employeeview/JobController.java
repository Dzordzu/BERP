package gui.employeeview;

import business.servicelocators.ServiceLocatorEntries;
import business.servicelocators.JobsServiceLocator;
import business.servicelocators.PaymentsServiceLocator;
import javafx.fxml.FXML;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import lombok.Getter;
import lombok.Setter;

public class JobController {

    @FXML
    HBox jobTitle, paymentStrategy, payment, paymentType;
    @Getter
    @Setter
    private String jobTitleValue, paymentStrategyValue, paymentCurrencyValue, paymentTypeValue;
    @Getter
    @Setter
    private double paymentValue;

    public void initialize() {

        MenuButton jobTitle = (MenuButton)this.jobTitle.getChildren().get(1);
        MenuButton paymentStrategy = (MenuButton)this.paymentStrategy.getChildren().get(1);

        changeJobTitle(JobsServiceLocator.getInstance().getDefault().getUIName());
        for(ServiceLocatorEntries j: JobsServiceLocator.getInstance().getValues()) {
            MenuItem item = new MenuItem(j.getUIName());
            item.setOnAction(event -> changeJobTitle(j.getUIName()));
            jobTitle.getItems().add(item);
        }

        changePaymentStrategy(PaymentsServiceLocator.getInstance().getDefault().getUIName());
        for(ServiceLocatorEntries p: PaymentsServiceLocator.getInstance().getValues()) {
            MenuItem item = new MenuItem(p.getUIName());
            item.setOnAction(event -> changePaymentStrategy(p.getUIName()));
            paymentStrategy.getItems().add(item);
        }
    }

    public void setMode(String mode) {
        switch (mode) {
            case "EDIT_MODE":
                break;
            case "VIEW_MODE":
                jobTitle.setDisable(true);
                paymentStrategy.setDisable(true);
                payment.setDisable(true);
                paymentType.setDisable(true);
        }
    }

    public void applyValues() {
        ((MenuButton)jobTitle.getChildren().get(1)).setText(jobTitleValue);
        ((MenuButton)paymentStrategy.getChildren().get(1)).setText(paymentStrategyValue);
        ((TextField)payment.getChildren().get(1)).setText(((Double)paymentValue).toString());
        ((SplitMenuButton)payment.getChildren().get(2)).setText(paymentCurrencyValue);
        ((MenuButton)paymentType.getChildren().get(1)).setText(paymentTypeValue);
    }

    public void changePaymentStrategy(String value) {
        ((MenuButton)paymentStrategy.getChildren().get(1)).setText(value);
        paymentStrategyValue = value;
    }

    public void changePayment() {
        String value = ((TextField) payment.getChildren().get(1)).getText();
        if(value == "" || value == null) value = "0";
        paymentValue = Double.valueOf(value);
    }

    public void changePaymentType(String type) {
        ((MenuButton)paymentType.getChildren().get(1)).setText(type);
        paymentTypeValue = type;
    }

    public void changePTToNetEmployeeSalary() {
        changePaymentType("Net Employee Salary");
    }

    public void changePTToNetEmploymentCost() {
        changePaymentType("Net Employment Cost");
    }

    public void changePTToGrossEmploymentCost() {
        changePaymentType("Gross Employment Cost");
    }

    public void changeJobTitle(String value) {
        ((MenuButton)jobTitle.getChildren().get(1)).setText(value);
        jobTitleValue = value;
    }
}
