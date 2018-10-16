package seeder.people;

import seeder.SeederFileReader;
import org.json.JSONObject;
import logic.place.Address;
import logic.place.AddressBuilder;
import logic.place.Country;

import java.io.IOException;
import java.util.List;
import java.util.Vector;

public class AddressFileReader extends SeederFileReader {
    private static AddressFileReader ourInstance = new AddressFileReader();

    public static AddressFileReader getInstance() {
        return ourInstance;
    }

    private AddressFileReader() {
        super("/seeders-data/addresslist.json");
    }

    public List<Address> getList() throws IOException {

        Vector<Address> result = new Vector();

        for(Object obj : super.getJSON().getJSONArray("AddressList")) {
            result.addElement(this.createAddressFromJSON(obj));
        }

        return (List<Address>)result;
    }

    public Address createAddressFromJSON(Object obj) {

        if(!(obj instanceof JSONObject)) throw new Error("Cannot read Address");

        JSONObject object = (JSONObject)obj;

        AddressBuilder.getInstance().clear();
        AddressBuilder.getInstance().setCityName(object.getString("City"));
        AddressBuilder.getInstance().setCountry(Country.POLAND);
        AddressBuilder.getInstance().setPostalCode(object.getString("Postal"));
        AddressBuilder.getInstance().setHomeNumber(object.getString("HomeNum"));
        AddressBuilder.getInstance().setRegion(object.getString("Region"));
        AddressBuilder.getInstance().setStreet(object.getString("Street"));
        AddressBuilder.getInstance().setStreetNumber(object.getString("StreetNum"));

        if(AddressBuilder.getInstance().isComplete()) return AddressBuilder.getInstance().buildAndClear();
        else throw new Error("Incomplete Address");
    }
}
