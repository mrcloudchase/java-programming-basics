/**
 * SumToN.java
 * Demonstrates for loops with a classic summation problem
 * Shows loop counter, accumulator pattern, and loop variations
 */
import java.util.Scanner;

public class SumToN {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("=== Sum from 1 to N ===");
        System.out.print("Enter a positive number (N): ");
        int n = scanner.nextInt();
        
        // Validate input
        if (n <= 0) {
            System.out.println("Please enter a positive number!");
            scanner.close();
            return;
        }
        
        // Method 1: Standard for loop
        System.out.println("\n--- Using for loop ---");
        int sum = 0;  // Accumulator variable
        
        // for (initialization; condition; update)
        for (int i = 1; i <= n; i++) {
            sum += i;  // Same as: sum = sum + i
            
            // Show the process for small values
            if (n <= 10) {
                System.out.print(i);
                if (i < n) {
                    System.out.print(" + ");
                }
            }
        }
        
        if (n <= 10) {
            System.out.println(" = " + sum);
        } else {
            System.out.println("Sum from 1 to " + n + " = " + sum);
        }
        
        // Verify with mathematical formula
        int formulaSum = n * (n + 1) / 2;
        System.out.println("Verification using formula n*(n+1)/2 = " + formulaSum);
        
        // Method 2: While loop equivalent
        System.out.println("\n--- Using while loop ---");
        int sum2 = 0;
        int counter = 1;
        
        while (counter <= n) {
            sum2 += counter;
            counter++;
        }
        
        System.out.println("Sum using while loop: " + sum2);
        
        // Method 3: do-while loop (always executes at least once)
        System.out.println("\n--- Using do-while loop ---");
        int sum3 = 0;
        int i = 1;
        
        do {
            sum3 += i;
            i++;
        } while (i <= n);
        
        System.out.println("Sum using do-while loop: " + sum3);
        
        // Counting down example
        System.out.println("\n--- Countdown using for loop ---");
        System.out.print("Countdown from 5: ");
        for (int count = 5; count > 0; count--) {
            System.out.print(count + " ");
        }
        System.out.println("Liftoff!");
        
        // Step by different amounts
        System.out.println("\n--- Sum of even numbers only ---");
        int evenSum = 0;
        System.out.print("Even numbers: ");
        
        // Step by 2
        for (int num = 2; num <= n; num += 2) {
            evenSum += num;
            System.out.print(num + " ");
        }
        
        System.out.println("\nSum of even numbers from 2 to " + n + " = " + evenSum);
        
        // Sum of odd numbers
        int oddSum = 0;
        System.out.print("Odd numbers: ");
        
        for (int num = 1; num <= n; num += 2) {
            oddSum += num;
            System.out.print(num + " ");
        }
        
        System.out.println("\nSum of odd numbers from 1 to " + n + " = " + oddSum);
        
        // Nested loops example - multiplication table
        System.out.println("\n--- Mini Multiplication Table (nested loops) ---");
        int tableSize = Math.min(n, 5);  // Limit to 5x5 for display
        
        for (int row = 1; row <= tableSize; row++) {
            for (int col = 1; col <= tableSize; col++) {
                System.out.printf("%4d", row * col);
            }
            System.out.println();  // New line after each row
        }
        
        // FRC Example: Averaging sensor readings
        System.out.println("\n--- FRC Sensor Average (simulated) ---");
        System.out.print("How many sensor readings? ");
        int numReadings = scanner.nextInt();
        
        double sensorSum = 0;
        for (int reading = 1; reading <= numReadings; reading++) {
            // Simulate sensor value (in real code, you'd read actual sensor)
            double sensorValue = 10 + Math.random() * 5;  // Random between 10-15
            sensorSum += sensorValue;
            System.out.printf("Reading %d: %.2f%n", reading, sensorValue);
        }
        
        double average = sensorSum / numReadings;
        System.out.printf("Average sensor value: %.2f%n", average);
        
        scanner.close();
    }
}
