package gui.billingtable;

import business.Employee;
import business.payment.PaymentStrategy;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.TableColumn;
import javafx.util.Callback;
import logic.math.Percentage;
import lombok.Getter;

/**
 * Handles all CellValueFactories
 */

public enum CellValueFactories {
    ID(
            (Callback<TableColumn.CellDataFeatures<Employee, String>, ObservableValue<String>>) param ->
                    new SimpleStringProperty(param.getValue().getId().getValue())

    ),
    Name(
            (Callback<TableColumn.CellDataFeatures<Employee, String>, ObservableValue<String>>) param ->
                    new SimpleStringProperty(param.getValue().getPerson().getName().toString())

    ),
    JobTitle(
            (Callback<TableColumn.CellDataFeatures<Employee, String>, ObservableValue<String>>) param ->
                    new SimpleStringProperty(param.getValue().getJob().getJobTitle())

    ),
    PaymentStrategy(
            (Callback<TableColumn.CellDataFeatures<Employee, String>, ObservableValue<String>>) param ->
                    new SimpleStringProperty(param.getValue().getJob().getSalary().getPaymentName())
    ),
    NetEmployeeSalary(
            (Callback<TableColumn.CellDataFeatures<Employee, Double>, ObservableValue<Double>>) param ->
                    new SimpleDoubleProperty(param.getValue().getJob().getSalary().getNetEmployeeSalary().getAmount()).asObject()
    ),
    GrossEmploymentCost(
            (Callback<TableColumn.CellDataFeatures<Employee, Double>, ObservableValue<Double>>) param ->
                    new SimpleDoubleProperty(param.getValue().getJob().getSalary().getGrossEmploymentCost().getAmount()).asObject()
    ),
    Currency(
            (Callback<TableColumn.CellDataFeatures<Employee, String>, ObservableValue<String>>) param ->
                    new SimpleStringProperty(param.getValue().getJob().getSalary().getGrossEmploymentCost().getCurrency().getCurrencyCode())
    ),
    NESGEC(
            (Callback<TableColumn.CellDataFeatures<Employee, Double>, ObservableValue<Double>>) param -> {
                PaymentStrategy strategy = param.getValue().getJob().getSalary();
                double nes = strategy.getNetEmployeeSalary().getAmount();
                double gec = strategy.getGrossEmploymentCost().getAmount();
                Percentage result = new Percentage().setFraction(nes/gec);
                return new SimpleDoubleProperty(result.getPercentage()).asObject();
            }
    ),
    ;

    @Getter Callback<TableColumn.CellDataFeatures, ObservableValue> value;

    CellValueFactories(Callback callback) {
        this.value = callback;
    }
}
