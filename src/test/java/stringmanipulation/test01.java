package stringmanipulation;

public class test01 {
    public static void main(String[] args) {
        String name = "Alice";
        System.out.println(name.length());
        System.out.println(name.charAt(1));
        System.out.println(name.toUpperCase());
        String a = null;
        String b = "test";
        System.out.println(a.equals(b));//null pointer exception
    }
}
