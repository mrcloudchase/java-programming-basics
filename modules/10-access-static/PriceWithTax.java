/**
 * PriceWithTax.java
 * Demonstrates using static constants from another class
 * Shows how static members are accessed via ClassName.MEMBER
 */
import java.util.Scanner;

public class PriceWithTax {
    // Static variable to track total sales
    private static double totalSalesAmount = 0;
    private static int transactionCount = 0;
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("=== Price Calculator with Tax ===");
        
        // Display the tax rate from Constants class
        System.out.printf("Current sales tax rate: %.2f%%%n", 
                        Constants.SALES_TAX * 100);
        
        boolean continueShopping = true;
        
        while (continueShopping) {
            System.out.print("\nEnter item price (0 to finish): $");
            double price = scanner.nextDouble();
            
            if (price == 0) {
                continueShopping = false;
            } else {
                // Calculate tax using static constant
                double tax = price * Constants.SALES_TAX;
                double totalPrice = price + tax;
                
                // Check for discount eligibility
                if (price >= 100) {
                    double discount = price * Constants.DISCOUNT_RATE;
                    totalPrice -= discount;
                    System.out.printf("Discount applied: -$%.2f (%.0f%% off)%n", 
                                    discount, Constants.DISCOUNT_RATE * 100);
                }
                
                // Add shipping if needed
                if (price < 50) {
                    totalPrice += Constants.SHIPPING_FEE;
                    System.out.printf("Shipping fee: $%.2f%n", Constants.SHIPPING_FEE);
                } else {
                    System.out.println("Free shipping!");
                }
                
                System.out.printf("Subtotal: $%.2f%n", price);
                System.out.printf("Tax: $%.2f%n", tax);
                System.out.printf("Total: $%.2f%n", totalPrice);
                
                // Update static tracking variables
                totalSalesAmount += totalPrice;
                transactionCount++;
            }
        }
        
        // Display summary using static variables
        System.out.println("\n=== Sales Summary ===");
        System.out.println("Total transactions: " + transactionCount);
        System.out.printf("Total sales: $%.2f%n", totalSalesAmount);
        
        if (transactionCount > 0) {
            double averageSale = totalSalesAmount / transactionCount;
            System.out.printf("Average sale: $%.2f%n", averageSale);
        }
        
        // Demonstrate FRC constants
        System.out.println("\n=== FRC Robot Calculator ===");
        System.out.print("Enter robot weight (lbs): ");
        int robotWeight = scanner.nextInt();
        
        if (robotWeight <= Constants.MAX_ROBOT_WEIGHT_LBS) {
            System.out.println("✓ Robot weight is legal!");
            int weightMargin = Constants.MAX_ROBOT_WEIGHT_LBS - robotWeight;
            System.out.println("Weight margin: " + weightMargin + " lbs");
        } else {
            int overweight = robotWeight - Constants.MAX_ROBOT_WEIGHT_LBS;
            System.out.println("✗ Robot is " + overweight + " lbs overweight!");
        }
        
        // Motor power calculation
        System.out.print("\nEnter desired motor power (-100 to 100%): ");
        double desiredPower = scanner.nextDouble() / 100.0;
        
        // Clamp to valid range using constants
        double actualPower = desiredPower;
        if (actualPower > Constants.MAX_MOTOR_POWER) {
            actualPower = Constants.MAX_MOTOR_POWER;
            System.out.println("Power limited to maximum: " + 
                             (Constants.MAX_MOTOR_POWER * 100) + "%");
        } else if (actualPower < Constants.MIN_MOTOR_POWER) {
            actualPower = Constants.MIN_MOTOR_POWER;
            System.out.println("Power limited to minimum: " + 
                             (Constants.MIN_MOTOR_POWER * 100) + "%");
        }
        
        // Apply deadband
        if (Math.abs(actualPower) < Constants.JOYSTICK_DEADBAND) {
            actualPower = 0;
            System.out.println("Within deadband zone - motor stopped");
        }
        
        System.out.printf("Final motor power: %.1f%%%n", actualPower * 100);
        
        // Display all constants
        System.out.println("\n--- All Constants ---");
        Constants.displayConstants();
        
        // Demonstrate static vs instance
        System.out.println("\n=== Static vs Instance Concepts ===");
        System.out.println("STATIC:");
        System.out.println("  - Belongs to the class, not objects");
        System.out.println("  - Shared by all instances");
        System.out.println("  - Accessed via ClassName.member");
        System.out.println("  - Example: Constants.SALES_TAX");
        
        System.out.println("\nINSTANCE:");
        System.out.println("  - Belongs to each object");
        System.out.println("  - Each object has its own copy");
        System.out.println("  - Accessed via objectName.member");
        System.out.println("  - Example: account1.getBalance()");
        
        System.out.println("\nFINAL:");
        System.out.println("  - Value cannot be changed");
        System.out.println("  - Often combined with static for constants");
        System.out.println("  - Example: public static final double PI");
        
        scanner.close();
    }
    
    // Static method - can be called without creating an object
    public static double calculateTotalWithTax(double price) {
        return price * (1 + Constants.SALES_TAX);
    }
}
