/**
 * ArraySum.java
 * Demonstrates fixed-size arrays and basic array operations
 * Arrays are fundamental for storing sensor data, motor values, etc.
 */
import java.util.Scanner;

public class ArraySum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("=== Array Operations ===");
        
        // Declare and initialize an array
        // Arrays have FIXED size once created
        int[] numbers = new int[5];  // Array of 5 integers
        
        // Get values from user
        System.out.println("Enter 5 numbers:");
        for (int i = 0; i < numbers.length; i++) {
            System.out.print("Number " + (i + 1) + ": ");
            numbers[i] = scanner.nextInt();
        }
        
        // Calculate sum and find max
        int sum = 0;
        int max = numbers[0];  // Start with first element
        int min = numbers[0];
        
        System.out.println("\n--- Array Contents ---");
        for (int i = 0; i < numbers.length; i++) {
            System.out.println("numbers[" + i + "] = " + numbers[i]);
            
            sum += numbers[i];
            
            if (numbers[i] > max) {
                max = numbers[i];
            }
            if (numbers[i] < min) {
                min = numbers[i];
            }
        }
        
        // Calculate average
        double average = (double) sum / numbers.length;
        
        System.out.println("\n--- Statistics ---");
        System.out.println("Sum: " + sum);
        System.out.println("Max: " + max);
        System.out.println("Min: " + min);
        System.out.printf("Average: %.2f%n", average);
        
        // Alternative array initialization
        System.out.println("\n--- Motor Power Array (Pre-initialized) ---");
        int[] motorPowers = {75, 50, 100, 25, 80};  // Direct initialization
        
        System.out.println("Motor power values:");
        // Enhanced for loop with arrays
        int motorIndex = 0;
        for (int power : motorPowers) {
            System.out.println("Motor " + motorIndex + ": " + power + "%");
            motorIndex++;
        }
        
        // Array of doubles for sensor data
        System.out.println("\n--- Sensor Data Array ---");
        double[] sensorReadings = new double[10];
        
        // Simulate sensor readings
        for (int i = 0; i < sensorReadings.length; i++) {
            sensorReadings[i] = 10.0 + Math.random() * 5.0;  // Random 10-15
        }
        
        // Display with formatting
        System.out.println("Sensor readings:");
        for (int i = 0; i < sensorReadings.length; i++) {
            System.out.printf("Sensor %2d: %.2f%n", i, sensorReadings[i]);
        }
        
        // Find values above threshold
        double threshold = 12.5;
        System.out.printf("\nReadings above %.1f:%n", threshold);
        int countAbove = 0;
        for (int i = 0; i < sensorReadings.length; i++) {
            if (sensorReadings[i] > threshold) {
                System.out.printf("  Sensor %d: %.2f%n", i, sensorReadings[i]);
                countAbove++;
            }
        }
        System.out.println("Total above threshold: " + countAbove);
        
        // Array copying
        System.out.println("\n--- Array Copying ---");
        int[] original = {1, 2, 3, 4, 5};
        int[] copy = new int[original.length];
        
        // Manual copy
        for (int i = 0; i < original.length; i++) {
            copy[i] = original[i];
        }
        
        // Modify copy to show they're different
        copy[0] = 999;
        
        System.out.println("Original: ");
        for (int val : original) {
            System.out.print(val + " ");
        }
        
        System.out.println("\nCopy (modified): ");
        for (int val : copy) {
            System.out.print(val + " ");
        }
        
        // Reverse an array
        System.out.println("\n\n--- Reversing an Array ---");
        int[] toReverse = {10, 20, 30, 40, 50};
        
        System.out.print("Before: ");
        for (int val : toReverse) {
            System.out.print(val + " ");
        }
        
        // Reverse in place
        for (int i = 0; i < toReverse.length / 2; i++) {
            int temp = toReverse[i];
            toReverse[i] = toReverse[toReverse.length - 1 - i];
            toReverse[toReverse.length - 1 - i] = temp;
        }
        
        System.out.print("\nAfter:  ");
        for (int val : toReverse) {
            System.out.print(val + " ");
        }
        
        // String array example
        System.out.println("\n\n--- String Array (Team Names) ---");
        String[] teams = {"Robonauts", "Cheesy Poofs", "Team 254", "The Blue Alliance"};
        
        System.out.println("FRC Teams:");
        for (int i = 0; i < teams.length; i++) {
            System.out.println((i + 1) + ". " + teams[i]);
        }
        
        // Common array pitfalls
        System.out.println("\n--- Important Notes ---");
        System.out.println("1. Arrays are 0-indexed (first element is at index 0)");
        System.out.println("2. Array size is fixed after creation");
        System.out.println("3. Accessing index >= length causes ArrayIndexOutOfBoundsException");
        System.out.println("4. Arrays are reference types (be careful when copying)");
        
        scanner.close();
    }
}
