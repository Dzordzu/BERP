package seeder.people;

import logic.valueobj.time.Age;
import org.json.JSONObject;
import seeder.Seeder;

import java.io.IOException;
import java.util.List;
import java.util.Vector;

public class AgeList extends Seeder {
    private static AgeList ourInstance = new AgeList();

    public static AgeList getInstance() {
        return ourInstance;
    }

    private AgeList() {
        super("/seeders-data/bornlist.json");
    }

    public List<Age> getList() throws IOException {
        JSONObject obj = this.getJSON();

        Vector<Age> result = new Vector<Age>();

        for(Object object: obj.getJSONArray("Age")) {
            result.add(new Age((String)object));
        }

        return (List<Age>)result;
    }
}
