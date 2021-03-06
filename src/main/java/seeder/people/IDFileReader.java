package seeder.people;

import logic.DataValidatorException;
import logic.identity.ID;
import logic.identity.IDType;
import org.json.JSONObject;
import seeder.SeederFileReader;

import java.io.IOException;
import java.util.List;
import java.util.Vector;


/**
 * XXX DANGEROUS AREA!
 */

public class IDFileReader extends SeederFileReader {
    private static IDFileReader ourInstance = new IDFileReader();

    public static IDFileReader getInstance() {
        return ourInstance;
    }

    private IDFileReader() {super("/seeders-data/idlist.json"); }

    public List<ID> getList() throws IOException, DataValidatorException {
        JSONObject obj = this.getJSON();

        Vector<ID> result = new Vector<ID>();

        for(Object object: obj.getJSONArray("ID")) {
            result.add(new ID(IDType.PESEL, (String)object));
        }

        return (List<ID>)result;
    }
}
