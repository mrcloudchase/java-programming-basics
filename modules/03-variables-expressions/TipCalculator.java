/**
 * TipCalculator.java
 * Demonstrates variables, arithmetic expressions, and user input
 */
import java.util.Scanner;

public class TipCalculator {
    public static void main(String[] args) {
        // Variables are containers that store values
        // They must be declared with a type before use
        
        Scanner scanner = new Scanner(System.in);
        
        // Variable declaration and initialization
        System.out.print("Enter bill amount ($): ");
        double billAmount = scanner.nextDouble();  // Variable to store the bill
        
        System.out.print("Enter tip percentage (e.g., 15 for 15%): ");
        int tipPercent = scanner.nextInt();  // Variable to store tip percentage
        
        // Expressions combine variables and operators to compute values
        double tipAmount = billAmount * (tipPercent / 100.0);  // Note: 100.0 to ensure double division
        double totalAmount = billAmount + tipAmount;
        
        // Using 'final' makes a variable constant (can't be changed)
        final double TAX_RATE = 0.08;  // Convention: constants in UPPER_CASE
        double tax = billAmount * TAX_RATE;
        double totalWithTax = totalAmount + tax;
        
        // Display results with formatting
        System.out.println("\n=== Receipt ===");
        System.out.printf("Bill:         $%.2f%n", billAmount);
        System.out.printf("Tax (8%%):     $%.2f%n", tax);
        System.out.printf("Tip (%d%%):     $%.2f%n", tipPercent, tipAmount);
        System.out.printf("Total:        $%.2f%n", totalWithTax);
        
        // Variable scope: variables only exist within their curly braces {}
        if (tipPercent >= 20) {
            String message = "Generous tip!";  // This variable only exists in this block
            System.out.println(message);
        }
        // System.out.println(message);  // ERROR: message doesn't exist here
        
        scanner.close();
    }
}
