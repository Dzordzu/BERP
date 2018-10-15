package gui.controller;

import javafx.fxml.FXML;
import javafx.scene.control.MenuButton;
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
        ((SplitMenuButton)jobTitle.getChildren().get(1)).setText(jobTitleValue);
        ((MenuButton)paymentStrategy.getChildren().get(1)).setText(paymentStrategyValue);
        ((TextField)payment.getChildren().get(1)).setText(((Double)paymentValue).toString());
        ((SplitMenuButton)payment.getChildren().get(2)).setText(paymentCurrencyValue);
        ((SplitMenuButton)paymentType.getChildren().get(1)).setText(paymentTypeValue);
    }

    public void changePaymentStrategy(String value) {
        ((MenuButton)paymentStrategy.getChildren().get(1)).setText(value);
        paymentStrategyValue = value;
    }

    public void changePSToBonus() {
        changePaymentStrategy("Bonus Payment");
    }

    public void changePSToStandard() {
        changePaymentStrategy("Standard Payment");
    }

    public void changePSToTestPeriod() {
        changePaymentStrategy("Test Period Payment");
    }


}
