package seeder.people;

import logic.valueobj.human.ID;
import logic.valueobj.human.IDType;
import org.json.JSONObject;
import seeder.SeederList;

import java.io.IOException;
import java.util.List;
import java.util.Vector;


/**
 * @XXX DANGEROUS AREA!
 */

public class IDList extends SeederList {
    private static IDList ourInstance = new IDList();

    public static IDList getInstance() {
        return ourInstance;
    }

    private IDList() {super("/seeders-data/idlist.json"); }

    public List<ID> getList() throws IOException {
        JSONObject obj = this.getJSON();

        Vector<ID> result = new Vector<ID>();

        for(Object object: obj.getJSONArray("ID")) {
            result.add(new ID(IDType.PESEL, (String)object));
        }

        return (List<ID>)result;
    }
}
