import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter Electronic Item details:");
        System.out.print("Item ID: ");
        String id = scanner.nextLine();
        System.out.print("Item Name: ");
        String name = scanner.nextLine();
        System.out.print("Quantity: ");
        int quantity = scanner.nextInt();
        System.out.print("Price per Unit: ");
        double price = scanner.nextDouble();
        scanner.nextLine(); // consume newline
        System.out.print("Supplier Name: ");
        String supplier = scanner.nextLine();
        System.out.print("Warranty Period (months): ");
        int warranty = scanner.nextInt();

        ElectronicsItem item = new ElectronicsItem(id, name, quantity, price, supplier, warranty);

        item.generateStockReport();

        if (item.validateStock()) {
            System.out.println("Stock is valid!");
        } else {
            System.out.println("Invalid stock data!");
        }
    }
}