
public class BooksItem extends ShoppingItem {
    private String isbn;
    private String edition;

    public BooksItem(String itemId, String itemName, String itemDescription, double price, int stockAvailable, String isbn, String edition) {
        super(itemId, itemName, itemDescription, price, stockAvailable);
        this.isbn = isbn;
        this.edition = edition;
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
        System.out.println("Item: " + itemName + ", ISBN: " + isbn + ", Price: $" + price);
    }

    @Override
    public boolean validateItem() {
        return isbn != null && !isbn.isEmpty();
    }
}
