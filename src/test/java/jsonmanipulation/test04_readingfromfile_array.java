package jsonmanipulation;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class test04_readingfromfile_array {
    public static void main(String[] args) throws IOException, ParseException {
        JSONParser parser = new JSONParser();
        FileReader reader = new FileReader("src/test/java/jsonmanipulation/jsonfile04.json");
        JSONArray jsonArray = (JSONArray) parser.parse(reader);
        for(int i = 0; i < jsonArray.size(); i ++) {
            JSONObject object = (JSONObject) jsonArray.get(i);
            System.out.println(object.get("name"));
            System.out.println(object.get("age"));
        }
    }
}
