package seeder.job;

import logic.valueobj.human.ID;
import logic.valueobj.human.IDType;
import org.json.JSONObject;
import seeder.SeederFileReader;

import java.io.IOException;
import java.util.List;
import java.util.Vector;

/**
 * @XXX DANGEROUS AREA!
 */

public class IDCompanyFileReader extends SeederFileReader {
    private static IDCompanyFileReader ourInstance = new IDCompanyFileReader();

    public static IDCompanyFileReader getInstance() {
        return ourInstance;
    }

    private IDCompanyFileReader() {
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
