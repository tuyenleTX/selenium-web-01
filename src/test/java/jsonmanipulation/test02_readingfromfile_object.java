package jsonmanipulation;


import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.FileReader;
import java.io.IOException;

public class test02_readingfromfile_object {
    public static void main(String[] args) throws IOException, ParseException {
        JSONParser parser = new JSONParser();
        FileReader reader = new FileReader("src/test/java/jsonmanipulation/jsonfile02.json");
        JSONObject jsonObject = (JSONObject)parser.parse(reader);
        System.out.println(jsonObject.get("city"));
    }
}
