import java.time.LocalDate;

public class GroceryItem extends StockItem {
    private LocalDate expirationDate;

    public GroceryItem(String itemId, String itemName, int quantityInStock, double pricePerUnit, String supplier, LocalDate expirationDate) {
        super(itemId, itemName, quantityInStock, pricePerUnit, "Groceries", supplier);
        this.expirationDate = expirationDate;
    }

    public void updateStock(int quantity) {
        this.quantityInStock += quantity;
    }

    public double calculateStockValue() {
        return quantityInStock * pricePerUnit;
    }

    public void generateStockReport() {
        System.out.println("Grocery Item Report:");
        System.out.println("Item Name: " + itemName + ", Expiration Date: " + expirationDate);
    }

    public boolean validateStock() {
        return !expirationDate.isBefore(LocalDate.now());
    }

    public boolean isNearingExpiration() {
        return expirationDate.isBefore(LocalDate.now().plusDays(7));
    }
}
