package gui.controller.helpers;

import business.Employee;
import gui.SourceLoader;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.io.IOException;

public class EmployeesListRow {

    Text id;
    Text name;
    Button details;
    Button fire;

    public String idVal;
    public String nameVal;

    public EmployeesListRow(Employee e) {
        idVal = e.getId().getValue();
        nameVal = e.getPerson().getName().toString();
    }

    public String getElementID() {
        return "empl-" + idVal;
    }

    public HBox getFXML() throws IOException {
        HBox reg = (HBox) SourceLoader.getInstance().getRegion("/employees-element.fxml");

        id = (Text) reg.lookup("#id");
        name = (Text) reg.lookup("#name");
        details = (Button) reg.lookup("#details");
        fire = (Button) reg.lookup("#fire");


        id.setText(idVal);
        id.setId(null);

        name.setText(nameVal);
        name.setId(null);

        details.setId("det-empl-" + idVal);
        fire.setId("fire-empl-" + idVal);

        //reg.setId("empl-" + idVal);
        return reg;
    }
}
