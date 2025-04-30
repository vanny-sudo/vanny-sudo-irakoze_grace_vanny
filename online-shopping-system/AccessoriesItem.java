import java.util.ArrayList;
import java.util.List;

public class AccessoriesItem extends ShoppingItem {
    private List<String> varieties;
    private List<String> reviews;

    public AccessoriesItem(String itemId, String itemName, String itemDescription, double price, int stockAvailable, List<String> varieties) {
        super(itemId, itemName, itemDescription, price, stockAvailable);
        this.varieties = varieties;
        this.reviews = new ArrayList<>();
    }

    @Override
    public void updateStock(int quantity) {
        stockAvailable += quantity;
    }

    @Override
    public void addToCart(Customer customer) {
        if (stockAvailable > 0) {
            System.out.println(itemName + " added to " + customer.getCustomerName() + "'s cart.");
            stockAvailable--;
        } else {
            System.out.println("Out of stock.");
        }
    }

    @Override
    public void generateInvoice(Customer customer) {
        System.out.println("Invoice for " + customer.getCustomerName());
        System.out.println("Item: " + itemName + ", Price: $" + price);
    }

    @Override
    public boolean validateItem() {
        return !varieties.isEmpty();
    }

    public void addReview(String review) {
        reviews.add(review);
    }
}