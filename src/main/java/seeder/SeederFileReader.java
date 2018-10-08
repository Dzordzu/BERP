package seeder;

import org.json.JSONObject;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;

public abstract class SeederFileReader {
    private String file;

    public SeederFileReader(String file) {
        this.file = file;
    }

    public String readFile() throws IOException {

        URL url = getClass().getResource(this.file);
        File file = new File(url.getPath());

        /**
         * Copy paste... https://www.journaldev.com/875/java-read-file-to-string
         */
        FileInputStream fis = new FileInputStream(file);
        byte[] buffer = new byte[10];
        StringBuilder sb = new StringBuilder();
        while (fis.read(buffer) != -1) {
            sb.append(new String(buffer));
            buffer = new byte[10];
        }
        fis.close();

        return sb.toString();
    }

    public JSONObject getJSON() throws IOException {
        JSONObject json = new JSONObject(this.readFile());
        return json;
    }


}
