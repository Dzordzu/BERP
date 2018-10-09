package seeder.people;

import valueobj.time.Age;
import org.json.JSONObject;
import seeder.SeederFileReader;

import java.io.IOException;
import java.util.List;
import java.util.Vector;

public class AgeFileReader extends SeederFileReader {
    private static AgeFileReader ourInstance = new AgeFileReader();

    public static AgeFileReader getInstance() {
        return ourInstance;
    }

    private AgeFileReader() {
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
