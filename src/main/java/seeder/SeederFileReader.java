package seeder;

import org.json.JSONObject;

import java.io.*;
import java.net.URL;
import java.util.ResourceBundle;

public abstract class SeederFileReader {
    private String file;

    public SeederFileReader(String file) {
        this.file = file;
    }

    public String readFile() throws IOException {

        InputStream in = getClass().getResourceAsStream(this.file);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(in));

        String line;
        StringBuilder sb = new StringBuilder();
        while ((line = bufferedReader.readLine()) != null) {
            sb.append(line);
        }
        bufferedReader.close();

        return sb.toString();
    }

    public JSONObject getJSON() throws IOException {
        JSONObject json = new JSONObject(this.readFile());
        return json;
    }


}
