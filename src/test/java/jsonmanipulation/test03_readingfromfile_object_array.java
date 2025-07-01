package jsonmanipulation;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

public class test03_readingfromfile_object_array {
    public static void main(String[] args) throws IOException, ParseException {
        JSONParser parser = new JSONParser();
        FileReader reader = new FileReader("src/test/java/jsonmanipulation/jsonfile03.json");
        JSONObject jsonObject = (JSONObject) parser.parse(reader);
        System.out.println(jsonObject.get("name"));
        JSONArray jsonArray = (JSONArray)jsonObject.get("hobbies");
        for (int i = 0; i < jsonArray.size(); i ++)
            System.out.println(jsonArray.get(i));
    }
}
