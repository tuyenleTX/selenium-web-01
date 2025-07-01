package stringmanipulation;

public class test07 {
    public static void main(String[] args) {
        String name = "Alice";
        int age = 28;
       // System.out.println("Name: " + name + ", age: " + age);

        //System.out.printf("Name: %s | Age: %d%n", name, age);

        System.out.printf("Name: %s | Age: %d%n", name, age);

        double price = 23.45678;
        System.out.printf("Price = %.2f%n", price);

        String pen = "Pen";
        System.out.printf("%-10s | Right: %10s%n", pen, pen);

        int id = 42;
        System.out.printf("%05d", id);

        String item = "Notebook";
        int qty = 4;
        double cost = 2.75;
        double total = qty * cost;
        System.out.printf("Item: %s, Qty: %d, Total: %.2f", item, qty, total);
    }
}
