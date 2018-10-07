package factory.people;

import factory.Factory;

public class AddressList extends Factory {
    private static AddressList ourInstance = new AddressList();

    public static AddressList getInstance() {
        return ourInstance;
    }

    private AddressList() {
        super("addresslist.json");
    }
}
