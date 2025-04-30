import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private String cartId;
    private List<ShoppingItem> cartItems;
    private double totalPrice;
    private Customer customer;

    public ShoppingCart(String cartId, Customer customer) {
        this.cartId = cartId;
        this.cartItems = new ArrayList<>();
        this.customer = customer;
    }

    public void addItem(ShoppingItem item) {
        if (item.validateItem()) {
            cartItems.add(item);
            totalPrice += item.price;
        }
    }

    public void displayCart() {
        System.out.println("Cart Items for " + customer.getCustomerName() + ":");
        for (ShoppingItem item : cartItems) {
            System.out.println("- " + item.itemName);
        }
        System.out.println("Total Price: $" + totalPrice);
    }
}