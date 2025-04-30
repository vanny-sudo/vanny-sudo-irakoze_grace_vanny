import java.time.LocalDate;

public class CollisionPolicy extends InsurancePolicy {

    public CollisionPolicy(String policyId, Vehicle vehicle, Person policyHolder, double coverageAmount, LocalDate startDate, LocalDate endDate) {
        super(policyId, vehicle, policyHolder, coverageAmount, startDate, endDate);
    }

    @Override
    public void calculatePremium() {
        premiumAmount = coverageAmount * 0.04;
    }

    @Override
    public void processClaim(double claimAmount) {
        if (claimAmount <= coverageAmount) {
            System.out.println("Collision Claim approved for $" + claimAmount);
        } else {
            System.out.println("Collision Claim denied.");
        }
    }

    @Override
    public void generatePolicyReport() {
        System.out.println("[Collision Policy]");
        System.out.println("Policy Holder: " + policyHolder.getFullName());
        System.out.println("Vehicle: " + vehicle.getVehicleModel());
        System.out.println("Coverage: $" + coverageAmount + " Premium: $" + premiumAmount);
    }

    @Override
    public boolean validatePolicy() {
        return vehicle.isSafetyChecked();
    }
}
