import java.time.LocalDate;

public class Claim {
    private String claimId;
    private double claimAmount;
    private LocalDate claimDate;
    private String claimStatus;

    public Claim(String claimId, double claimAmount) {
        this.claimId = claimId;
        this.claimAmount = claimAmount;
        this.claimDate = LocalDate.now();
        this.claimStatus = "Pending";
    }

    public String getClaimId() { return claimId; }
    public double getClaimAmount() { return claimAmount; }
    public LocalDate getClaimDate() { return claimDate; }
    public String getClaimStatus() { return claimStatus; }

    public void approve() {
        this.claimStatus = "Approved";
    }

    public void reject() {
        this.claimStatus = "Rejected";
    }
}