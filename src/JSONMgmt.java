import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONObject;

public class JSONMgmt {

    static FileWriter file;

    public static void JSONWrite(String key, String value) throws FileNotFoundException {

        JSONObject jsonStream = new JSONObject();
        jsonStream.put(key, value);
        
        try {
            file = new FileWriter("config.json");
            file.write(jsonStream.toJSONString());
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void JSONWrite(String key, char[] value) throws FileNotFoundException {

        JSONObject jsonStream = new JSONObject();
        jsonStream.put(key, value);
        
        try {
            file = new FileWriter("config.json");
            file.append(jsonStream.toJSONString());
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void JSONRead(String key, String value) throws FileNotFoundException {
        
    }
}