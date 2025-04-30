import java.util.*;
import java.time.LocalDate;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static List<InsurancePolicy> policies = new ArrayList<>();
    static List<Claim> claims = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println("🚗 Welcome to the Advanced Motor Vehicle Insurance System 🚗");

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Create Policy");
            System.out.println("2. File a Claim");
            System.out.println("3. Generate Report");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1: createPolicy(); break;
                case 2: fileClaim(); break;
                case 3: generateReport(); break;
                case 4: System.exit(0);
                default: System.out.println("Invalid choice!");
            }
        }
    }

    private static void createPolicy() {
        System.out.println("\nEnter Policy Holder Details:");
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Phone: ");
        String phone = scanner.nextLine();
        System.out.print("DOB (YYYY-MM-DD): ");
        LocalDate dob = LocalDate.parse(scanner.nextLine());
        Person person = new Person(UUID.randomUUID().toString(), name, dob, email, phone);

        System.out.println("\nEnter Vehicle Details:");
        System.out.print("Make: ");
        String make = scanner.nextLine();
        System.out.print("Model: ");
        String model = scanner.nextLine();
        System.out.print("Year: ");
        int year = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Type: ");
        String type = scanner.nextLine();
        Vehicle vehicle = new Vehicle(UUID.randomUUID().toString(), make, model, year, type);

        System.out.println("\nSelect Policy Type:");
        System.out.println("1. Comprehensive");
        System.out.println("2. Third Party");
        System.out.println("3. Collision");
        System.out.println("4. Liability");
        System.out.println("5. Roadside Assistance");
        int typeChoice = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter Coverage Amount: ");
        double coverage = scanner.nextDouble();
        scanner.nextLine();

        LocalDate startDate = LocalDate.now();
        LocalDate endDate = startDate.plusYears(1);

        InsurancePolicy policy = null;

        switch (typeChoice) {
            case 1: policy = new ComprehensivePolicy(UUID.randomUUID().toString(), vehicle, person, coverage, startDate, endDate); break;
            case 2: policy = new ThirdPartyPolicy(UUID.randomUUID().toString(), vehicle, person, coverage, startDate, endDate); break;
            case 3: policy = new CollisionPolicy(UUID.randomUUID().toString(), vehicle, person, coverage, startDate, endDate); break;
            case 4: policy = new LiabilityPolicy(UUID.randomUUID().toString(), vehicle, person, coverage, startDate, endDate); break;
            case 5: policy = new RoadsideAssistancePolicy(UUID.randomUUID().toString(), vehicle, person, coverage, startDate, endDate); break;
            default: System.out.println("Invalid type."); return;
        }

        if (policy.validatePolicy()) {
            policy.calculatePremium();
            policies.add(policy);
            System.out.println("Policy Created Successfully!");
            policy.generatePolicyReport();
        } else {
            System.out.println("Policy validation failed.");
        }
    }

    private static void fileClaim() {
        System.out.print("\nEnter Policy ID to claim: ");
        String pid = scanner.nextLine();
        InsurancePolicy policy = policies.stream().filter(p -> p.getPolicyId().equals(pid)).findFirst().orElse(null);
        if (policy == null) {
            System.out.println("Policy not found!");
            return;
        }

        System.out.print("Enter claim amount: ");
        double amount = scanner.nextDouble();
        scanner.nextLine();

        Claim claim = new Claim(UUID.randomUUID().toString(), amount);
        if (amount <= policy.coverageAmount) {
            policy.processClaim(amount);
            claim.approve();
        } else {
            System.out.println("Claim exceeds coverage.");
            claim.reject();
        }
        claims.add(claim);
    }

    private static void generateReport() {
        double totalPremium = policies.stream().mapToDouble(InsurancePolicy::getPremiumAmount).sum();
        
        System.out.println("\n*** Report ***");
        System.out.println("Total Premiums Collected: $" + totalPremium);
        System.out.println("Total Claims: " + claims.size());
        
        claims.forEach(c -> System.out.println("Claim " + c.getClaimId() + ": " + c.getClaimStatus()));
        System.out.println("Policies by Type:");
        
        Map<String, Long> counts = new HashMap<>();
        
        for (InsurancePolicy p : policies) {
            counts.put(p.getClass().getSimpleName(), counts.getOrDefault(p.getClass().getSimpleName(), 0L) + 1);
        }

        counts.forEach((k,v) -> System.out.println(k + ": " + v));
    }
}