package stringmanipulation;

public class test03 {
    public static void main(String[] args) {
        String text = "Programming";
        String sub1 = text.replace('m', 'n');
        String sub2 = text.substring(5);
        System.out.println(sub1);
        System.out.println(sub2);
        String word = "developer";
        int lastIndex = word.lastIndexOf("e");
        System.out.println(lastIndex);
    }
}
