import java.util.List;

public class ClothingItem extends StockItem {
    private List<String> sizes;
    private List<String> colors;
    private double discount;

    public ClothingItem(String itemId, String itemName, int quantityInStock, double pricePerUnit, String supplier, List<String> sizes, List<String> colors, double discount) {
        super(itemId, itemName, quantityInStock, pricePerUnit, "Clothing", supplier);
        this.sizes = sizes;
        this.colors = colors;
        this.discount = discount;
    }

    public void updateStock(int quantity) {
        this.quantityInStock += quantity;
    }

    public double calculateStockValue() {
        double effectivePrice = pricePerUnit - (pricePerUnit * (discount / 100));
        return quantityInStock * effectivePrice;
    }

    public void generateStockReport() {
        System.out.println("Clothing Item Report:");
        System.out.println("Item Name: " + itemName + ", Sizes: " + sizes + ", Colors: " + colors + ", Quantity: " + quantityInStock);
    }

    public boolean validateStock() {
        return quantityInStock >= 0 && discount <= 50;
    }
}
