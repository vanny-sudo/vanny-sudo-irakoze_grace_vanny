public class ElectronicsItem extends StockItem {
    private int warrantyPeriod;

    public ElectronicsItem(String itemId, String itemName, int quantityInStock, double pricePerUnit, String supplier, int warrantyPeriod) {
        super(itemId, itemName, quantityInStock, pricePerUnit, "Electronics", supplier);
        this.warrantyPeriod = warrantyPeriod;
    }

    public void updateStock(int quantity) {
        this.quantityInStock += quantity;
    }

    public double calculateStockValue() {
        return quantityInStock * pricePerUnit;
    }

    public void generateStockReport() {
        System.out.println("Electronics Item Report:");
        System.out.println("Item Name: " + itemName + ", Quantity: " + quantityInStock + ", Price per Unit: RWF" + pricePerUnit);
    }

    public boolean validateStock() {
        return quantityInStock > 0 && warrantyPeriod > 0 && warrantyPeriod <= 36;
    }

    public void applyDiscount(double percentage) {
        if (percentage <= 50) {
            pricePerUnit -= pricePerUnit * (percentage / 100);
        } else {
            System.out.println("Discount exceeds maximum limit (50%)");
        }
    }
}