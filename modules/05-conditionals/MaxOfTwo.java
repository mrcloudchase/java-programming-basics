/**
 * MaxOfTwo.java
 * Demonstrates basic if-else conditional statements
 * Essential for decision-making in robot control
 */
import java.util.Scanner;

public class MaxOfTwo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("=== Find Maximum of Two Numbers ===");
        
        // Read two numbers
        System.out.print("Enter first number (x): ");
        int x = scanner.nextInt();
        
        System.out.print("Enter second number (y): ");
        int y = scanner.nextInt();
        
        // Basic if-else structure
        int max;
        if (x > y) {
            max = x;
            System.out.println(x + " is greater than " + y);
        } else if (x < y) {
            max = y;
            System.out.println(y + " is greater than " + x);
        } else {
            max = x;  // They're equal, either works
            System.out.println("Both numbers are equal: " + x);
        }
        
        System.out.println("Maximum value: " + max);
        
        // Alternative: Using ternary operator (? :)
        // This is a shorthand for simple if-else
        int max2 = (x > y) ? x : y;
        System.out.println("\nUsing ternary operator: " + max2);
        
        // Practical robotics example
        System.out.println("\n--- Robot Speed Limiter Example ---");
        System.out.print("Enter motor power (-100 to 100): ");
        int motorPower = scanner.nextInt();
        
        // Limit motor power to safe range
        int safePower;
        if (motorPower > 100) {
            safePower = 100;
            System.out.println("Power limited to maximum: 100");
        } else if (motorPower < -100) {
            safePower = -100;
            System.out.println("Power limited to minimum: -100");
        } else {
            safePower = motorPower;
            System.out.println("Power within safe range: " + safePower);
        }
        
        // Nested conditionals
        if (safePower != 0) {
            if (safePower > 0) {
                System.out.println("Motor moving forward at " + safePower + "%");
            } else {
                System.out.println("Motor moving backward at " + Math.abs(safePower) + "%");
            }
        } else {
            System.out.println("Motor stopped");
        }
        
        scanner.close();
    }
}
