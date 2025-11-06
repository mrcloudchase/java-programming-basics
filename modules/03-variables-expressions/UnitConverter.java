/**
 * UnitConverter.java
 * Demonstrates type conversion, variables, and mathematical expressions
 * Useful for robotics: converting between measurement units
 */
import java.util.Scanner;

public class UnitConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Constants for conversion factors (using final)
        final double CM_TO_METERS = 0.01;
        final double CM_TO_INCHES = 0.393701;
        final double CM_TO_FEET = 0.0328084;
        
        System.out.println("=== FRC Unit Converter ===");
        System.out.print("Enter distance in centimeters: ");
        
        // Read integer input
        int centimeters = scanner.nextInt();
        
        // Expressions with type conversion
        // int * double = double (automatic widening)
        double meters = centimeters * CM_TO_METERS;
        double inches = centimeters * CM_TO_INCHES;
        double feet = centimeters * CM_TO_FEET;
        
        // Display conversions
        System.out.println("\n--- Conversions ---");
        System.out.println(centimeters + " cm = " + meters + " meters");
        System.out.printf("%d cm = %.2f inches%n", centimeters, inches);
        System.out.printf("%d cm = %.2f feet%n", centimeters, feet);
        
        // Demonstrating integer division vs double division
        System.out.println("\n--- Division Examples ---");
        int wholeFeet = centimeters / 30;  // Integer division (30 cm ≈ 1 foot)
        System.out.println("Whole feet (int division): " + wholeFeet);
        
        double exactFeet = centimeters / 30.0;  // Double division
        System.out.println("Exact feet (double division): " + exactFeet);
        
        // Compound expressions
        // Convert to inches, then calculate feet and remaining inches
        int totalInches = (int)(centimeters * CM_TO_INCHES);
        int feetPart = totalInches / 12;  // 12 inches per foot
        int inchesPart = totalInches % 12;  // Remainder operator
        
        System.out.println("\n--- Feet and Inches ---");
        System.out.println(centimeters + " cm = " + feetPart + " feet, " + inchesPart + " inches");
        
        // Variable scope example
        {
            // This block has its own scope
            double tempValue = meters * 100;  // tempValue only exists in this block
            System.out.println("\nBack to cm: " + tempValue);
        }
        // tempValue is not accessible here
        
        // Using variables in expressions
        double fieldLengthMeters = 16.46;  // FRC field is ~54 feet
        double distanceRatio = meters / fieldLengthMeters;
        System.out.printf("%nYour distance is %.1f%% of an FRC field length%n", 
                         distanceRatio * 100);
        
        scanner.close();
    }
}
