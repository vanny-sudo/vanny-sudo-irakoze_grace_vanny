public class FurnitureItem extends StockItem {
    private double weight; // kg

    public FurnitureItem(String itemId, String itemName, int quantityInStock, double pricePerUnit, String supplier, double weight) {
        super(itemId, itemName, quantityInStock, pricePerUnit, "Furniture", supplier);
        this.weight = weight;
    }

    public void updateStock(int quantity) {
        this.quantityInStock += quantity;
    }

    public double calculateStockValue() {
        return quantityInStock * pricePerUnit;
    }

    public void generateStockReport() {
        System.out.println("Furniture Item Report:");
        System.out.println("Item Name: " + itemName + ", Weight: " + weight + "kg");
    }

    public boolean validateStock() {
        return quantityInStock >= 0;
    }
}
