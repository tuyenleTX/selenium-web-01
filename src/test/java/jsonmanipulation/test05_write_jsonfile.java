package jsonmanipulation;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;

public class test05_write_jsonfile {
    public static void main(String[] args) throws IOException {
        JSONObject jsonObject01 = new JSONObject();
        jsonObject01.put("name", "Alice");
        jsonObject01.put("age", 25);
        jsonObject01.put("city", "New York");
        System.out.println(jsonObject01.toJSONString());

        JSONObject jsonObject02 = new JSONObject();
        jsonObject02.put("name", "John");
        jsonObject02.put("age", 35);
        jsonObject02.put("city", "New Mexico");
        System.out.println(jsonObject02.toJSONString());

        JSONArray array = new JSONArray();
        array.add(jsonObject01);
        array.add(jsonObject02);
        System.out.println(array.toJSONString());

        FileWriter fileWriter = new FileWriter("src/test/java/jsonmanipulation/jsonfile05.json");
        fileWriter.write(array.toJSONString());
        fileWriter.flush();
    }
}
