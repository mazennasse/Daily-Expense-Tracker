
// DailyExpense:
import java.util.Scanner;

public class DailyExpense {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        double weeklySpent = 0;
        double weeklySaved = 0;

        // Loop through 7 days (one week)
        for (int day = 1; day <= 7; day++) {

            System.out.println("\n===== Day " + day + " =====");

            System.out.print("Enter day name: ");
            String dayName = input.nextLine();

            System.out.print("Enter your daily budget: ");
            double dailyBudget = input.nextDouble();

            System.out.print("Enter minimum amount you must keep (for going home): ");
            double minimumKeep = input.nextDouble();

            double currentMoney = dailyBudget;
            double dailySpent = 0;

            String choice = "yes";
            input.nextLine();

            // Shopping loop for the current day
            while (choice.equalsIgnoreCase("yes")) {

                System.out.println("\nCurrent money: " + currentMoney);
                System.out.print("Enter item price: ");
                double price = input.nextDouble();
                input.nextLine();

                // Check if purchase keeps minimum required money
                if (currentMoney - price >= minimumKeep) {
                    currentMoney -= price;
                    dailySpent += price;
                    System.out.println("Purchase successful");
                } else {
                    System.out.println("Purchase denied (You must keep at least " + minimumKeep + ")");
                }

                System.out.print("Do you want to buy another item? (yes/no): ");
                choice = input.nextLine();
            }

            double dailySaved = currentMoney;

            weeklySpent += dailySpent;
            weeklySaved += dailySaved;

            System.out.println("\n--- End of " + dayName + " ---");
            System.out.println("Total spent today: " + dailySpent);
            System.out.println("Money left today: " + dailySaved);
        }

        System.out.println("\n====== Weekly Report ======");
        System.out.println("Total spent this week: " + weeklySpent);
        System.out.println("Total saved this week: " + weeklySaved);

        // Estimate monthly saving based on 4 weeks
        double estimatedMonthlySaving = weeklySaved * 4;
        System.out.println("Estimated monthly saving: " + estimatedMonthlySaving);

        input.close();
    }
}