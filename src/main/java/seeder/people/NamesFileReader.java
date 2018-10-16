package seeder.people;

import seeder.SeederFileReader;
import logic.human.Name;
import logic.human.NameBuilder;
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

        NameBuilder.getInstance().clear();
        NameBuilder.getInstance().setFirstname(object.getString("Firstname"));
        NameBuilder.getInstance().setSurname(object.getString("Surname"));
        NameBuilder.getInstance().setMiddlenames(this.JSONArrayToListString(object.getJSONArray("Middlenames")));
        NameBuilder.getInstance().setSuffixes(this.JSONArrayToListString(object.getJSONArray("Suffixes")));

        return NameBuilder.getInstance().buildAndClear();
    }

    private NamesFileReader() {
        super("/seeders-data/nameslist.json");
    }
}
