import java.time.LocalDate;

public class ThirdPartyPolicy extends InsurancePolicy {

    public ThirdPartyPolicy(String policyId, Vehicle vehicle, Person policyHolder, double coverageAmount, LocalDate startDate, LocalDate endDate) {
        super(policyId, vehicle, policyHolder, coverageAmount, startDate, endDate);
    }

    @Override
    public void calculatePremium() {
        premiumAmount = coverageAmount * 0.03;
    }

    @Override
    public void processClaim(double claimAmount) {
        if (claimAmount <= coverageAmount) {
            System.out.println("Third Party Claim approved for $" + claimAmount);
        } else {
            System.out.println("Third Party Claim denied.");
        }
    }

    @Override
    public void generatePolicyReport() {
        System.out.println("[Third Party Policy]");
        System.out.println("Holder: " + policyHolder.getFullName());
        System.out.println("Vehicle: " + vehicle.getVehicleMake());
        System.out.println("Coverage: $" + coverageAmount + " Premium: $" + premiumAmount);
    }

    @Override
    public boolean validatePolicy() {
        return vehicle.getVehicleType().equalsIgnoreCase("Car") || vehicle.getVehicleType().equalsIgnoreCase("Truck");
    }
}
