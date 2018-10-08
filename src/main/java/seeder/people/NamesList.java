package seeder.people;

import seeder.SeederList;
import logic.valueobj.human.Name;
import logic.valueobj.human.NameBuilder;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class NamesList extends SeederList {
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

    private List<String> JSONArrayToListString(JSONArray yourJSONresponse) {
        JSONArray arr = yourJSONresponse;
        List<String> list = new ArrayList<String>();
        for(Object i: arr){
            list.add((String)i);
        }
        return list;
    }

    public Name createAddressFromJSON(Object obj) {

        if(!(obj instanceof JSONObject)) throw new Error("Cannot read Name");
        JSONObject object = (JSONObject)obj;

        NameBuilder.clear();
        NameBuilder.setFirstname(object.getString("Firstname"));
        NameBuilder.setSurname(object.getString("Surname"));
        NameBuilder.setMiddlenames(this.JSONArrayToListString(object.getJSONArray("Middlenames")));
        NameBuilder.setSuffixes(this.JSONArrayToListString(object.getJSONArray("Suffixes")));

        return NameBuilder.buildAndClear();
    }

    private NamesList() {
        super("/seeders-data/nameslist.json");
    }
}
