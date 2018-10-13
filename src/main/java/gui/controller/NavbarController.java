package gui.controller;

import gui.SceneSwitcher;
import gui.helper.BillingTableGenerator;

public class NavbarController {
    public void gotoAbout() throws Exception {
        SceneSwitcher.getInstance().switchScene("fxml/about.fxml");
    }
    public void gotoAdd() {}
    public void gotoBillings() throws Exception {
        SceneSwitcher.getInstance().switchScene(BillingTableGenerator.getInstance().generate());
    }
}
