import java.time.LocalDate;

public class Payment {
    private String paymentId;
    private String paymentMethod;
    private double amountPaid;
    private LocalDate transactionDate;

    public Payment(String paymentId, String paymentMethod, double amountPaid) {
        if (!(paymentMethod.equalsIgnoreCase("Credit Card") || paymentMethod.equalsIgnoreCase("PayPal"))) {
            throw new IllegalArgumentException("Invalid payment method.");
        }
        this.paymentId = paymentId;
        this.paymentMethod = paymentMethod;
        this.amountPaid = amountPaid;
        this.transactionDate = LocalDate.now();
    }

    public void displayPayment() {
        System.out.println("Payment Method: " + paymentMethod);
        System.out.println("Amount Paid: $" + amountPaid);
        System.out.println("Transaction Date: " + transactionDate);
    }
}
