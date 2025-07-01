package stringmanipulation;

public class test06 {
    public static void main(String[] args) {
        StringBuilder strBuilder = new StringBuilder("Start");
        strBuilder.append(" Middle");
        System.out.println(strBuilder);
        strBuilder.insert(6, "Quick ");
        System.out.println(strBuilder);
        strBuilder.replace(0,5, "Begin");
        System.out.println(strBuilder);
        strBuilder.delete(12,13);
        System.out.println(strBuilder);
    }

}
