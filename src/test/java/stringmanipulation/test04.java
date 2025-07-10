package stringmanipulation;

import java.util.Scanner;

public class test04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please input a sentence:");
        String inputText = scanner.nextLine();
        System.out.println("Please input a word to search: ");
        String keyword = scanner.nextLine();
        if(inputText.contains(keyword)) System.out.println("Key found at index: " + inputText.indexOf(keyword));
        else System.out.println("Key not found");
    }
}
