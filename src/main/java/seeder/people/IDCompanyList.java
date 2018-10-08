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

public class IDCompanyList extends SeederList {
    private static IDCompanyList ourInstance = new IDCompanyList();

    public static IDCompanyList getInstance() {
        return ourInstance;
    }

    private IDCompanyList() {
        super("/seeders-data/idlist-company.json");
    }

    public List<ID> getList() throws IOException {
        JSONObject obj = this.getJSON();

        Vector<ID> result = new Vector<ID>();

        for(Object object: obj.getJSONArray("ID")) {
            result.add(new ID(IDType.COMPANYID, (String)object));
        }

        return (List<ID>)result;
    }
}
