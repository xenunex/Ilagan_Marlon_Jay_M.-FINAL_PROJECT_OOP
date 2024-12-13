import java.util.Scanner;

abstract class Bill {
    private double totalAmount;

    public abstract void calculateBill(double consumption);

    public double getTotalAmount() {
        return totalAmount;
    }

    protected void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public void displayBillDetails() {
        System.out.println("Total Amount Due: P" + getTotalAmount());
    }
}

class WaterBill extends Bill {
    private final double unitPrice;

    public WaterBill(String company) {
        switch (company.toLowerCase()) {
            case "aqua data":
            case "aquadata":
                unitPrice = 10.0973;
                break;
            case "primewater":
            case "prime water":
                unitPrice = 10.2345;
                break;
            case "waterdistrict":
            case "water district":
                unitPrice = 9.1394;
                break;
            default:
                unitPrice = 2.00;
                System.out.println("Invalid company. Defaulting to P2.00 per cubic meter.");
                break;
        }
    }

    @Override
    public void calculateBill(double consumption) {

        double totalAmount = consumption * unitPrice;
        setTotalAmount(totalAmount);
    }
}


class ElectricityBill extends Bill {
    private final double unitPrice;

    public ElectricityBill(String company) {

        switch (company.toLowerCase()) {
            case "first bay":
            case "firstbay":
                unitPrice = 10.0938;
                break;
            case "meralco":
                unitPrice = 11.7882;
                break;
            case "batelec":
                unitPrice = 8.4723;
                break;
            default:
                unitPrice = 9.98;
                System.out.println("Invalid company. Defaulting to P9.98 per kWh.");
                break;
        }
    }

    @Override
    public void calculateBill(double consumption) {

        double totalAmount = consumption * unitPrice;
        setTotalAmount(totalAmount);
    }
}


class InternetBill extends Bill {
    private final double unitPrice;

    public InternetBill(String company) {
        unitPrice = getPlanPrice(company);
    }

    public double getPlanPrice(String company) {
        Scanner scanner = new Scanner(System.in);
        String[] plans;
        double[] prices;

        switch (company.toLowerCase()) {
            case "converge":
                plans = new String[]{"FiberX 1500", "FiberX 2500", "FiberX 3500", "FiberXtreme 4500", "FiberXtreme 7000"};
                prices = new double[]{1500, 2500, 3500, 4500, 7000};
                break;
            case "globe":
                plans = new String[]{"Plan 999", "Plan 1299", "Plan 1699", "Plan 2299"};
                prices = new double[]{999, 1299, 1699, 2299};
                break;
            case "pldt":
                plans = new String[]{"Plan 1999", "Plan 2499", "Plan 2999"};
                prices = new double[]{1999, 2499, 2999};
                break;
            case "skycable":
                plans = new String[]{"Plan 1500", "Plan 2000", "Plan 2500"};
                prices = new double[]{1500, 2000, 2500};
                break;
            default:
                System.out.println("Invalid Input. Defaulting to P0.0.");
                return 0.0;
        }

        System.out.println("------------------------------------");
        System.out.println(company.toUpperCase() + " PLANS");
        for (int i = 0; i < plans.length; i++) {
            System.out.println((i + 1) + ". " + plans[i]);
        }
        System.out.print("Choose your plan (1-" + plans.length + "): ");
        int choice = scanner.nextInt();

        return (choice >= 1 && choice <= plans.length) ? prices[choice - 1] : 0;
    }

    @Override
    public void calculateBill(double consumption) {

        setTotalAmount(unitPrice);
    }
}


class FoodBill extends Bill {

    @Override
    public void calculateBill(double consumption) {
        setTotalAmount(consumption);
    }
}


class RentBill extends Bill {

    @Override
    public void calculateBill(double consumption) {
        setTotalAmount(consumption);
    }
}


public class BillCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double totalBillAmount = 0;

        while (true) {
            System.out.println("\n\nWelcome to the BILL CALCULATOR!");
            System.out.println("------------------------------------");
            System.out.println("Please choose the type of bill to be added on the total amount:");
            System.out.println("1. Water Bill");
            System.out.println("2. Electricity Bill");
            System.out.println("3. Internet Bill");
            System.out.println("4. Food Bill");
            System.out.println("5. Rent Bill");

            System.out.print("Enter your choice (1-5): ");
            int choice = scanner.nextInt();
            System.out.println("------------------------------------");

            Bill bill;

            if (choice == 1) {

                System.out.print("\nEnter the total cubic meters of water consumed:");
                double waterConsumption = scanner.nextDouble();
                System.out.print("\nEnter the water company you belong to (AquaData/Prime Water/Water District):");
                String company = scanner.next();

                bill = new WaterBill(company);
                bill.calculateBill(waterConsumption);
            } else if (choice == 2) {

                System.out.print("\nEnter the total kWh of electricity consumed:");
                double electricityConsumption = scanner.nextDouble();
                System.out.print("\nEnter the electricity company you belong to (First Bay/Meralco/BATELEC):");
                String company = scanner.next();

                bill = new ElectricityBill(company);
                bill.calculateBill(electricityConsumption);
            } else if (choice == 3) {

                System.out.print("\nEnter the internet service provider (Converge/Globe/PLDT/SkyCable):");
                String company = scanner.next();

                bill = new InternetBill(company);
                bill.calculateBill(0);  // Internet bill is based on the selected plan
            } else if (choice == 4) {

                System.out.print("\nEnter the total amount for food:");
                double foodAmount = scanner.nextDouble();

                bill = new FoodBill();
                bill.calculateBill(foodAmount);
            } else if (choice == 5) {

                System.out.println("\nEnter the rent amount:");
                double rentAmount = scanner.nextDouble();

                bill = new RentBill();
                bill.calculateBill(rentAmount);
            } else {
                System.out.println("Invalid choice. Please select again.");
                continue;
            }

            totalBillAmount += bill.getTotalAmount();
            bill.displayBillDetails();

            System.out.println("-----------------------------------------------");
            System.out.print("Do you want add another bill to the total amount? (yes/no): ");
            String continueChoice = scanner.next();
            if (continueChoice.equalsIgnoreCase("no")) {
                break;
            }
        }

            System.out.println("---------------------------------------------------------------------------");
            System.out.print("\nDo you want to compute the total bill according to your salary? (yes/no): ");
            String salaryChoice = scanner.next();

            if (salaryChoice.equalsIgnoreCase("yes")) {
                System.out.print("Enter your salary: ");
                double salary = scanner.nextDouble();

                double finalBill = Math.max(0, salary - totalBillAmount);
                String formattedbill = String.format("%.2f", totalBillAmount);
                String formattedfbill = String.format("%.2f", finalBill);
                System.out.println("------------------------------------");
                System.out.println("Total Bills: P" + formattedbill);
                System.out.println("Remaining after salary deduction: P" + formattedfbill);
            } else {
                System.out.println("Total Bills: P" + totalBillAmount);
            }
        scanner.close();
    }
}
