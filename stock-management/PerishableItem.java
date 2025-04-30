import java.time.LocalDate;

public class PerishableItem extends StockItem {
    private LocalDate expirationDate;

    public PerishableItem(String itemId, String itemName, int quantityInStock, double pricePerUnit, String supplier, LocalDate expirationDate) {
        super(itemId, itemName, quantityInStock, pricePerUnit, "Perishable", supplier);
        this.expirationDate = expirationDate;
    }

    public void updateStock(int quantity) {
        this.quantityInStock += quantity;
    }

    public double calculateStockValue() {
        return quantityInStock * pricePerUnit;
    }

    public void generateStockReport() {
        System.out.println("Perishable Item Report:");
        System.out.println("Item Name: " + itemName + ", Expiration Date: " + expirationDate);
    }

    public boolean validateStock() {
        return expirationDate.isAfter(LocalDate.now().plusDays(3)); // Must have > 3 days shelf life
    }

    public boolean isExpired() {
        return expirationDate.isBefore(LocalDate.now());
    }
}
