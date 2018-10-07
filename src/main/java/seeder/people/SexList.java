package seeder.people;

import logic.valueobj.human.Sex;
import org.json.JSONObject;
import seeder.Seeder;

import java.io.IOException;
import java.util.List;
import java.util.Vector;

public class SexList extends Seeder {
    private static SexList ourInstance = new SexList();

    public static SexList getInstance() {
        return ourInstance;
    }

    private SexList() {
        super("/seeders-data/sexlist.json");
    }

    public List<Sex> getList() throws IOException {
        JSONObject obj = this.getJSON();

        Vector<Sex> result = new Vector<Sex>();

        for(Object object: obj.getJSONArray("Sex")) {
            result.add(new Sex((String)object));
        }

        return (List<Sex>)result;
    }
}
