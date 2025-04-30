import java.time.LocalDate;

public class ComprehensivePolicy extends InsurancePolicy {

    public ComprehensivePolicy(String policyId, Vehicle vehicle, Person policyHolder, double coverageAmount, LocalDate startDate, LocalDate endDate) {
        super(policyId, vehicle, policyHolder, coverageAmount, startDate, endDate);
    }

    public void calculatePremium() {
        int vehicleAge = LocalDate.now().getYear() - vehicle.getVehicleYear();
        premiumAmount = coverageAmount * (0.05 + (vehicleAge * 0.01));
    }

    public void processClaim(double claimAmount) {
        if (claimAmount <= coverageAmount) {
            System.out.println("Claim approved for amount: $" + claimAmount);
        } else {
            System.out.println("Claim exceeds coverage amount. Denied.");
        }
    }

    public void generatePolicyReport() {
        System.out.println("Policy ID: " + policyId);
        System.out.println("Policy Holder: " + policyHolder.getFullName());
        System.out.println("Vehicle: " + vehicle.getVehicleMake() + " " + vehicle.getVehicleModel());
        System.out.println("Coverage: $" + coverageAmount);
        System.out.println("Premium: $" + premiumAmount);
        System.out.println("Policy Period: " + policyStartDate + " to " + policyEndDate);
    }

    public boolean validatePolicy() {
        return vehicle.getVehicleYear() >= 2000;
    }
}
