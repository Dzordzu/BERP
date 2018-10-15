package gui.controller;

import gui.SceneSwitcher;
import gui.helper.BillingTableGenerator;
import gui.helper.EmployeeViewGenerator;

public class NavbarController {
    public void gotoAbout() throws Exception {
        SceneSwitcher.getInstance().switchScene("fxml/about.fxml");
    }
    public void gotoAdd() throws Exception {
        SceneSwitcher.getInstance().switchScene(EmployeeViewGenerator.CREATE_MODE.generate());
    }
    public void gotoBillings() throws Exception {
        SceneSwitcher.getInstance().switchScene(BillingTableGenerator.getInstance().generate());
    }
}
