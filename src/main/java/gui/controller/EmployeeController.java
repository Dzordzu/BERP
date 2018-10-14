package gui.controller;

import gui.SceneSwitcher;
import gui.helper.BillingTableGenerator;

public class EmployeeController {

    public void save() {
        System.out.println("TODO");
    }

    public void cancel() throws Exception {
        SceneSwitcher.getInstance().switchScene(BillingTableGenerator.getInstance().generate());
    }
}
