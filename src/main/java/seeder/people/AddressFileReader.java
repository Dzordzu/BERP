package seeder.people;

import seeder.SeederFileReader;
import org.json.JSONObject;
import valueobj.place.Address;
import valueobj.place.AddressBuilder;
import valueobj.place.Country;

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

        AddressBuilder.clear();
        AddressBuilder.setCityName(object.getString("City"));
        AddressBuilder.setCountry(Country.POLAND);
        AddressBuilder.setPostalCode(object.getString("Postal"));
        AddressBuilder.setHomeNumber(object.getString("HomeNum"));
        AddressBuilder.setRegion(object.getString("Region"));
        AddressBuilder.setStreet(object.getString("Street"));
        AddressBuilder.setStreetNumber(object.getString("StreetNum"));

        if(AddressBuilder.isComplete()) return AddressBuilder.buildAndClear();
        else throw new Error("Incomplete Address");
    }
}