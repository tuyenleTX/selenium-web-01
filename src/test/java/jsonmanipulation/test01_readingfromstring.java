package jsonmanipulation;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class test01_readingfromstring {
    public static void main(String[] args) throws ParseException {
        String employeeJson = "{\"name\":\"Alice\", \"age\": 25, \"city\": \"New York\"}";
        JSONParser parser = new JSONParser();
        JSONObject jsonObject = (JSONObject)parser.parse(employeeJson);
        System.out.println(jsonObject.get("name"));
        System.out.println(jsonObject.get("age"));
        System.out.println(jsonObject.get("city"));
    }
}
