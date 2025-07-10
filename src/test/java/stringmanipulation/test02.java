package stringmanipulation;

import java.util.Scanner;

public class test02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please input name: ");
        String name = scanner.next();
        if (name.equals("admin")) System.out.println("Welcome admin");
        else System.out.println("Access denied");
    }
}
