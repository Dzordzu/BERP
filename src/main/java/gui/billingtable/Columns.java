package gui.billingtable;

import javafx.scene.control.TableColumn;
import javafx.util.Callback;
import lombok.Getter;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * <p>Handles list of displayed columns. Then is used in BillingTableGenerator to render them.</p>
 * @see BillingTableGenerator
 */

public enum Columns {
    ID(null, null, CellValueFactories.ID.getValue()),
    Name(null, null, CellValueFactories.Name.getValue()),
    JobTitle(null, null, CellValueFactories.JobTitle.getValue()),
    PaymentStrategy(null, null, CellValueFactories.PaymentStrategy.getValue()),
    NetEmployeeSalary(null, null, CellValueFactories.NetEmployeeSalary.getValue()),
    GrossEmploymentCost(null, null, CellValueFactories.GrossEmploymentCost.getValue()),
    Currency(null, null, CellValueFactories.Currency.getValue()),
//    Fire,
//    Edit,
//    View,
    NESGEC("NES/GEC", null, CellValueFactories.NESGEC.getValue()),
    ;

    @Getter String labelText;
    Callback cellFactory, cellValueFactory;


    void setLabelText(String labelText) {
        if(labelText != null) this.labelText = labelText;
        else {
            String result;
            Pattern p = Pattern.compile("([A-Z][a-z]+)");
            Matcher m = p.matcher(this.name());
            result = m.replaceAll("$1 ");
            p = Pattern.compile("( )$");
            m = p.matcher(result);
            this.labelText = m.replaceFirst("");
        }
    }

    Columns(String labelText, Callback cellFactory, Callback cellValueFactory) {
        setLabelText(labelText);
        this.cellFactory = cellFactory;
        this.cellValueFactory = cellValueFactory;
    }


    public TableColumn getColumn() {
        return new TableColumn(this.toString());
    }
}
