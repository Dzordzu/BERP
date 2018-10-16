package gui.billingtable;

import javafx.scene.control.TableColumn;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Handles list of displayed columns. Then is used in BillingTableGenerator to render them
 * @see BillingTableGenerator
 */

public enum Columns {
    ID,
    Name,
    Position,
    PaymentStrategy,
    NetEmployeeSalary,
    GrossEmploymentCost,
    Currency,
    Fire,
    Edit,
    View,
    NESGEC,
    ;

    public TableColumn getTableViewColumn() {
        return new TableColumn(this.toString());
    }

    public String toString() {
        String result;
        Pattern p = Pattern.compile("([A-Z][a-z]+)");
        Matcher m = p.matcher(this.name());
        result = m.replaceAll("$1 ");
        p = Pattern.compile("( )$");
        m = p.matcher(result);
        return m.replaceFirst("");
    }
}
