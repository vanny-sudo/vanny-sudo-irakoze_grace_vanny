import java.time.LocalDate;

public class LiabilityPolicy extends InsurancePolicy {

    public LiabilityPolicy(String policyId, Vehicle vehicle, Person policyHolder, double coverageAmount, LocalDate startDate, LocalDate endDate) {
        super(policyId, vehicle, policyHolder, coverageAmount, startDate, endDate);
    }

    @Override
    public void calculatePremium() {
        premiumAmount = coverageAmount * 0.025;
    }

    @Override
    public void processClaim(double claimAmount) {
        if (claimAmount <= coverageAmount) {
            System.out.println("Liability Claim approved for $" + claimAmount);
        } else {
            System.out.println("Liability Claim denied.");
        }
    }

    @Override
    public void generatePolicyReport() {
        System.out.println("[Liability Policy]");
        System.out.println("Holder: " + policyHolder.getFullName());
        System.out.println("Coverage: $" + coverageAmount + " Premium: $" + premiumAmount);
    }

    @Override
    public boolean validatePolicy() {
        return policyHolder.isMedicallyCleared();
    }
}
