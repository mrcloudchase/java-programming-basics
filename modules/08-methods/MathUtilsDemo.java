/**
 * MathUtilsDemo.java
 * Demonstrates method creation, parameters, return values, and overloading
 * Methods are essential for organizing code and avoiding repetition
 */
import java.util.Scanner;

public class MathUtilsDemo {
    
    // Method 1: Simple method with return value
    // Access modifier: public (can be called from other classes)
    // Static: can be called without creating an object
    // Return type: int (must return an integer)
    // Parameters: two integers
    public static int max(int a, int b) {
        if (a > b) {
            return a;  // Return immediately exits the method
        } else {
            return b;
        }
        // Could also write: return (a > b) ? a : b;
    }
    
    // Method 2: Method with boolean return
    public static boolean isPrime(int n) {
        // Handle edge cases
        if (n <= 1) {
            return false;
        }
        if (n == 2) {
            return true;
        }
        if (n % 2 == 0) {
            return false;  // Even numbers (except 2) aren't prime
        }
        
        // Check odd divisors up to square root
        for (int i = 3; i * i <= n; i += 2) {
            if (n % i == 0) {
                return false;  // Found a divisor
            }
        }
        
        return true;  // No divisors found, it's prime
    }
    
    // Method 3: String manipulation method
    public static String repeat(String s, int times) {
        String result = "";
        for (int i = 0; i < times; i++) {
            result += s;
        }
        return result;
    }
    
    // Method 4: Void method (no return value)
    public static void printStars(int count) {
        for (int i = 0; i < count; i++) {
            System.out.print("*");
        }
        System.out.println();  // New line at the end
        // No return statement needed for void methods
    }
    
    // Method 5: Method with array parameter
    public static double average(int[] numbers) {
        if (numbers.length == 0) {
            return 0;  // Avoid division by zero
        }
        
        int sum = 0;
        for (int num : numbers) {
            sum += num;
        }
        
        return (double) sum / numbers.length;
    }
    
    // Method 6: Overloading - same name, different parameters
    public static int max(int a, int b, int c) {
        // Can reuse the two-parameter max method
        return max(max(a, b), c);
    }
    
    // Another overload with double parameters
    public static double max(double a, double b) {
        return (a > b) ? a : b;
    }
    
    // Method 7: Method calling other methods
    public static void analyzeNumber(int num) {
        System.out.println("\n--- Analysis of " + num + " ---");
        
        // Check if prime
        if (isPrime(num)) {
            System.out.println(num + " is prime");
        } else {
            System.out.println(num + " is not prime");
            
            // Find factors
            System.out.print("Factors: ");
            for (int i = 1; i <= num; i++) {
                if (num % i == 0) {
                    System.out.print(i + " ");
                }
            }
            System.out.println();
        }
        
        // Check even/odd
        System.out.println(num + " is " + (isEven(num) ? "even" : "odd"));
    }
    
    // Helper method
    public static boolean isEven(int n) {
        return n % 2 == 0;
    }
    
    // Method 8: Recursive method (method calls itself)
    public static int factorial(int n) {
        if (n <= 1) {
            return 1;  // Base case
        }
        return n * factorial(n - 1);  // Recursive call
    }
    
    // FRC-specific methods
    public static double limitMotorPower(double power) {
        // Clamp motor power between -1.0 and 1.0
        if (power > 1.0) return 1.0;
        if (power < -1.0) return -1.0;
        return power;
    }
    
    public static double applyDeadband(double value, double deadband) {
        // Ignore small joystick movements
        if (Math.abs(value) < deadband) {
            return 0;
        }
        return value;
    }
    
    public static double celsiusToFahrenheit(double celsius) {
        return celsius * 9.0 / 5.0 + 32;
    }
    
    public static double fahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5.0 / 9.0;
    }
    
    // Main method - program entry point
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("=== Method Demonstrations ===");
        
        // Test max method
        System.out.println("\n--- Max Function ---");
        System.out.print("Enter two numbers: ");
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        
        int result = max(x, y);  // Call the method
        System.out.println("max(" + x + ", " + y + ") = " + result);
        
        // Test three-parameter max (overloading)
        System.out.print("Enter a third number: ");
        int z = scanner.nextInt();
        System.out.println("max(" + x + ", " + y + ", " + z + ") = " + max(x, y, z));
        
        // Test with doubles
        double d1 = 3.14, d2 = 2.71;
        System.out.println("max(" + d1 + ", " + d2 + ") = " + max(d1, d2));
        
        // Test isPrime
        System.out.println("\n--- Prime Number Check ---");
        System.out.print("Enter a number to check: ");
        int primeCheck = scanner.nextInt();
        
        if (isPrime(primeCheck)) {
            System.out.println(primeCheck + " is prime!");
        } else {
            System.out.println(primeCheck + " is not prime.");
        }
        
        // Find primes in range
        System.out.print("\nPrimes from 1 to 30: ");
        for (int i = 1; i <= 30; i++) {
            if (isPrime(i)) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
        
        // Test repeat method
        System.out.println("\n--- String Repeat ---");
        scanner.nextLine();  // Clear buffer
        System.out.print("Enter a string: ");
        String str = scanner.nextLine();
        System.out.print("Repeat how many times? ");
        int times = scanner.nextInt();
        
        String repeated = repeat(str, times);
        System.out.println("Result: " + repeated);
        
        // Test void method
        System.out.println("\n--- Star Patterns ---");
        for (int i = 1; i <= 5; i++) {
            printStars(i);  // Void method - no return value to store
        }
        
        // Test array method
        System.out.println("\n--- Array Average ---");
        int[] scores = {85, 92, 78, 95, 88};
        double avg = average(scores);
        System.out.printf("Average of scores: %.2f%n", avg);
        
        // Empty array test
        int[] empty = {};
        System.out.println("Average of empty array: " + average(empty));
        
        // Test analyze number
        System.out.print("\nEnter number to analyze: ");
        int analyze = scanner.nextInt();
        analyzeNumber(analyze);
        
        // Test factorial
        System.out.println("\n--- Factorial (Recursive) ---");
        System.out.print("Enter number for factorial (max 12): ");
        int factNum = scanner.nextInt();
        
        if (factNum <= 12 && factNum >= 0) {
            System.out.println(factNum + "! = " + factorial(factNum));
        } else {
            System.out.println("Please enter 0-12 to avoid overflow");
        }
        
        // FRC Examples
        System.out.println("\n--- FRC Motor Control ---");
        double[] testPowers = {0.5, 1.5, -1.5, -0.8};
        
        for (double power : testPowers) {
            double limited = limitMotorPower(power);
            System.out.printf("Motor power %.2f -> %.2f (limited)%n", power, limited);
        }
        
        System.out.println("\n--- Joystick Deadband ---");
        double[] joystickValues = {0.02, -0.03, 0.5, -0.8};
        double deadband = 0.1;
        
        for (double value : joystickValues) {
            double filtered = applyDeadband(value, deadband);
            System.out.printf("Joystick %.2f -> %.2f (deadband=%.1f)%n", 
                            value, filtered, deadband);
        }
        
        // Temperature conversion
        System.out.println("\n--- Temperature Conversion ---");
        System.out.print("Enter temperature in Celsius: ");
        double celsius = scanner.nextDouble();
        double fahrenheit = celsiusToFahrenheit(celsius);
        System.out.printf("%.1f°C = %.1f°F%n", celsius, fahrenheit);
        
        // Convert back to verify
        double backToCelsius = fahrenheitToCelsius(fahrenheit);
        System.out.printf("%.1f°F = %.1f°C (verification)%n", fahrenheit, backToCelsius);
        
        // Pass by value demonstration
        System.out.println("\n--- Pass by Value ---");
        int original = 10;
        System.out.println("Before method call: " + original);
        modifyValue(original);
        System.out.println("After method call: " + original);
        System.out.println("Note: Primitive values are copied, not referenced!");
        
        scanner.close();
    }
    
    // Demonstrate pass-by-value
    public static void modifyValue(int x) {
        x = 999;  // This only changes the local copy
        System.out.println("Inside method: " + x);
    }
}
