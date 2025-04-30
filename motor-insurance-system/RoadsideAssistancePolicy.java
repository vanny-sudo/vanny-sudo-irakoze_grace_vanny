import java.time.LocalDate;

public class RoadsideAssistancePolicy extends InsurancePolicy {

    public RoadsideAssistancePolicy(String policyId, Vehicle vehicle, Person policyHolder, double coverageAmount, LocalDate startDate, LocalDate endDate) {
        super(policyId, vehicle, policyHolder, coverageAmount, startDate, endDate);
    }

    @Override
    public void calculatePremium() {
        premiumAmount = 120; // Fixed price
    }

    @Override
    public void processClaim(double claimAmount) {
        System.out.println("Roadside Assistance Claim approved.");
    }

    @Override
    public void generatePolicyReport() {
        System.out.println("[Roadside Assistance Policy]");
        System.out.println("Vehicle: " + vehicle.getVehicleModel());
        System.out.println("Premium: $" + premiumAmount);
    }

    @Override
    public boolean validatePolicy() {
        return vehicle.isRegistered();
    }
}