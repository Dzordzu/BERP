package factory.people;

import factory.Factory;
import logic.valueobj.human.Name;
import logic.valueobj.human.NameBuilder;
import org.json.JSONObject;

import java.io.IOException;
import java.util.List;
import java.util.Vector;

public class NamesList extends Factory {
    private static NamesList ourInstance = new NamesList();

    public static NamesList getInstance() {
        return ourInstance;
    }

    public List<Name> getList() throws IOException {
        Vector<Name> result = new Vector();
        for(Object obj : super.getJSON().getJSONArray("NamesList")) {
            result.addElement(this.createAddressFromJSON(obj));
        }
        return (List<Name>)result;
    }

    public Name createAddressFromJSON(Object obj) {

        if(!(obj instanceof JSONObject)) throw new Error("Cannot read Name");
        JSONObject object = (JSONObject)obj;

        NameBuilder.clear();
        NameBuilder.setFirstname(object.getString("Firstname"));
        NameBuilder.setSurname(object.getString("Surname"));
        NameBuilder.setMiddlenames((String[] )object.get("Middlenames"));
        NameBuilder.setSuffixes((String[])object.get("Suffixes"));

        return NameBuilder.buildAndClear();
    }

    private NamesList() {
        super("/nameslist.json");
    }
}
