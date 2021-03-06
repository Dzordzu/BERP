package seeder.people;

import logic.human.Sex;
import org.json.JSONObject;
import seeder.SeederFileReader;

import java.io.IOException;
import java.util.List;
import java.util.Vector;

public class SexFileReader extends SeederFileReader {
    private static SexFileReader ourInstance = new SexFileReader();

    public static SexFileReader getInstance() {
        return ourInstance;
    }

    private SexFileReader() {
        super("/seeders-data/sexlist.json");
    }

    public List<Sex> getList() throws Exception {
        JSONObject obj = this.getJSON();

        Vector<Sex> result = new Vector<Sex>();

        for(Object object: obj.getJSONArray("Sex")) {
            result.add(Sex.get((String)object));
        }

        return result;
    }
}
