package stringmanipulation;

public class test05 {
    public static void main(String[] args) {
        String inputStr = "Text   With     Whitespaces!   ";
        String result = inputStr.replaceAll("\\s+", "_");
        String[] parts = result.split("_");
        System.out.println(parts.length);
        for (int i = 0; i < parts.length; i++) {
            System.out.println(parts[i]);
        }
    }
}
