public class ElectronicsItem extends ShoppingItem {
    private int warrantyMonths;
    private boolean registeredProduct;

    public ElectronicsItem(String itemId, String itemName, String itemDescription, double price, int stockAvailable, int warrantyMonths) {
        super(itemId, itemName, itemDescription, price, stockAvailable);
        this.warrantyMonths = warrantyMonths;
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
        System.out.println("Invoice for " + customer.getCustomerName());
        System.out.println("Item: " + itemName + ", Price: $" + price);
    }

    public boolean validateItem() {
        return stockAvailable > 0 && warrantyMonths > 0;
    }

    public void registerProduct() {
        registeredProduct = true;
    }
}
