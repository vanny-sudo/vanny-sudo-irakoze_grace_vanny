import java.time.LocalDate;

public class GroceriesItem extends ShoppingItem {
    private LocalDate expirationDate;

    public GroceriesItem(String itemId, String itemName, String itemDescription, double price, int stockAvailable, LocalDate expirationDate) {
        super(itemId, itemName, itemDescription, price, stockAvailable);
        this.expirationDate = expirationDate;
    }

    public void updateStock(int quantity) {
        stockAvailable += quantity;
    }

    public void addToCart(Customer customer) {
        if (stockAvailable > 0 && !expirationDate.isBefore(LocalDate.now())) {
            System.out.println(itemName + " added to " + customer.getCustomerName() + "'s cart.");
            stockAvailable--;
        } else {
            System.out.println("Cannot add expired item or out of stock.");
        }
    }

    public void generateInvoice(Customer customer) {
        System.out.println("Invoice for " + customer.getCustomerName());
        System.out.println("Item: " + itemName + ", Price: $" + price);
    }

    public boolean validateItem() {
        return expirationDate.isAfter(LocalDate.now());
    }

    public double bulkDiscount(int quantity) {
        if (quantity >= 10) {
            return price * 0.9;
        }
        return price;
    }
}