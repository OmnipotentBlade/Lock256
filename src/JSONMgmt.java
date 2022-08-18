import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.HashMap;

import org.json.simple.JSONObject;

public class JSONMgmt {

    public static void JSONWrite(String key, String value) throws FileNotFoundException {
        HashMap<String, Object> newEntry = new HashMap<String, Object>();
        newEntry.put(key, value);

        PrintWriter pw = new PrintWriter(new FileOutputStream(new File("config.json"), true));
        pw.append(JSONObject.toJSONString(newEntry));
        pw.flush();
        pw.close();
    }
}