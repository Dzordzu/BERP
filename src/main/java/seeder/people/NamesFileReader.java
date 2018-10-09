package seeder.people;

import seeder.SeederFileReader;
import valueobj.human.Name;
import valueobj.human.NameBuilder;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class NamesFileReader extends SeederFileReader {
    private static NamesFileReader ourInstance = new NamesFileReader();

    public static NamesFileReader getInstance() {
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

    private Name createAddressFromJSON(Object obj) {

        if(!(obj instanceof JSONObject)) throw new Error("Cannot read Name");
        JSONObject object = (JSONObject)obj;

        NameBuilder.clear();
        NameBuilder.setFirstname(object.getString("Firstname"));
        NameBuilder.setSurname(object.getString("Surname"));
        NameBuilder.setMiddlenames(this.JSONArrayToListString(object.getJSONArray("Middlenames")));
        NameBuilder.setSuffixes(this.JSONArrayToListString(object.getJSONArray("Suffixes")));

        return NameBuilder.buildAndClear();
    }

    private NamesFileReader() {
        super("/seeders-data/nameslist.json");
    }
}
