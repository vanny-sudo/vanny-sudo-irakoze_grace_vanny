import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Register a Customer:");
        System.out.print("Customer ID: ");
        String customerId = scanner.nextLine();

        System.out.print("Customer Name: ");
        String name = scanner.nextLine();

        System.out.print("Email: ");
        String email = scanner.nextLine();

        System.out.print("Address: ");
        String address = scanner.nextLine();

        System.out.print("Phone: ");
        String phone = scanner.nextLine();

        Customer customer = new Customer(customerId, name, email, address, phone);
        ShoppingCart cart = new ShoppingCart(UUID.randomUUID().toString(), customer);

        System.out.println("Enter Electronic Item details:");
        System.out.print("Item ID: ");
        String id = scanner.nextLine();
        System.out.print("Item Name: ");
        String itemName = scanner.nextLine();
        System.out.print("Item Description: ");
        String description = scanner.nextLine();
        System.out.print("Price: ");
        double price = scanner.nextDouble();
        System.out.print("Stock Available: ");
        int stock = scanner.nextInt();
        System.out.print("Warranty Months: ");
        int warranty = scanner.nextInt();

        ElectronicsItem item = new ElectronicsItem(id, itemName, description, price, stock, warranty);
        
        cart.addItem(item);
        cart.displayCart();

        System.out.println("\nProcessing Payment...");
        System.out.print("Enter Payment Method (Credit Card / PayPal): ");
        scanner.nextLine();
        String method = scanner.nextLine();

        Payment payment = new Payment(UUID.randomUUID().toString(), method, price);
        payment.displayPayment();
    }
}