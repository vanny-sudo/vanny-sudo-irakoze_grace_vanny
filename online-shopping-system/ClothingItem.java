import java.util.List;

public class ClothingItem extends ShoppingItem {
    private List<String> availableSizes;
    private double seasonalDiscount; // %

    public ClothingItem(String itemId, String itemName, String itemDescription, double price, int stockAvailable, List<String> sizes, double seasonalDiscount) {
        super(itemId, itemName, itemDescription, price, stockAvailable);
        this.availableSizes = sizes;
        this.seasonalDiscount = seasonalDiscount;
    }

    public void updateStock(int quantity) {
        stockAvailable += quantity;
    }

    public void addToCart(Customer customer) {
        if (stockAvailable > 0) {
            System.out.println(itemName + " added to " + customer.getCustomerName() + "'s cart.");
            stockAvailable--;
        } else {
            System.out.println("Item out of stock.");
        }
    }

    public void generateInvoice(Customer customer) {
        double discountedPrice = price - (price * seasonalDiscount / 100);
        System.out.println("Invoice for " + customer.getCustomerName());
        System.out.println("Item: " + itemName + ", Price after discount: $" + discountedPrice);
    }

    public boolean validateItem() {
        return stockAvailable > 0 && seasonalDiscount <= 50;
    }
}