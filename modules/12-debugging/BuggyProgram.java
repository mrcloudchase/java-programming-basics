/**
 * BuggyProgram.java
 * Contains intentional bugs for debugging practice
 * Learn to identify and fix common programming errors
 */
import java.util.Scanner;

public class BuggyProgram {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("=== Debugging Practice ===");
        System.out.println("This program has bugs! Let's find and fix them.\n");
        
        // BUG 1: Off-by-one error in loop
        System.out.println("BUG 1: Off-by-one error");
        System.out.println("Trying to print numbers 1 through 5:");
        
        // BUGGY VERSION:
        System.out.print("Buggy output: ");
        for (int i = 1; i < 5; i++) {  // BUG: Should be i <= 5
            System.out.print(i + " ");
        }
        System.out.println("\n^ Notice: Only prints 1-4, missing 5!");
        
        // FIXED VERSION:
        System.out.print("Fixed output: ");
        for (int i = 1; i <= 5; i++) {  // FIX: Changed < to <=
            System.out.print(i + " ");
        }
        System.out.println("\n✓ Now prints all numbers 1-5");
        
        // BUG 2: NullPointerException
        System.out.println("\n\nBUG 2: NullPointerException");
        System.out.println("Working with strings:");
        
        String text = null;
        // Uncomment the next line to see the error:
        // System.out.println("Length: " + text.length());  // BUG: NPE!
        
        System.out.println("^ Buggy line commented out to prevent crash");
        System.out.println("Would cause: NullPointerException");
        
        // FIXED VERSION:
        System.out.println("\nFixed version with null check:");
        if (text != null) {
            System.out.println("Length: " + text.length());
        } else {
            System.out.println("Text is null - cannot get length");
        }
        
        // Alternative fix:
        text = "";  // Initialize to empty string instead of null
        System.out.println("After initialization - Length: " + text.length());
        
        // BUG 3: Array index out of bounds
        System.out.println("\n\nBUG 3: ArrayIndexOutOfBoundsException");
        int[] numbers = {10, 20, 30, 40, 50};
        
        System.out.println("Array has " + numbers.length + " elements (indices 0-4)");
        
        // BUGGY VERSION (commented to prevent crash):
        // for (int i = 0; i <= numbers.length; i++) {  // BUG: <= includes length
        //     System.out.println("numbers[" + i + "] = " + numbers[i]);
        // }
        
        System.out.println("^ Buggy loop would try to access numbers[5] which doesn't exist!");
        
        // FIXED VERSION:
        System.out.println("\nFixed version:");
        for (int i = 0; i < numbers.length; i++) {  // FIX: < instead of <=
            System.out.println("numbers[" + i + "] = " + numbers[i]);
        }
        
        // BUG 4: Integer division truncation
        System.out.println("\n\nBUG 4: Integer Division Truncation");
        int score = 7;
        int total = 10;
        
        // BUGGY VERSION:
        double percentage = score / total * 100;  // BUG: Integer division!
        System.out.println("Buggy calculation: " + score + "/" + total + " * 100 = " + percentage);
        System.out.println("^ Expected 70.0, but got 0.0!");
        
        // FIXED VERSION:
        double percentageFixed = (double) score / total * 100;  // FIX: Cast to double
        System.out.println("Fixed calculation: " + score + "/" + total + " * 100 = " + percentageFixed);
        
        // BUG 5: Infinite loop
        System.out.println("\n\nBUG 5: Infinite Loop Prevention");
        System.out.println("Example of what would be an infinite loop:");
        
        // BUGGY VERSION (DO NOT UNCOMMENT!):
        // int counter = 0;
        // while (counter < 10) {
        //     System.out.println(counter);
        //     // BUG: Forgot to increment counter!
        // }
        
        System.out.println("^ The loop above never increments counter, so it runs forever!");
        
        // FIXED VERSION:
        System.out.println("\nFixed version with proper increment:");
        int counter = 0;
        while (counter < 5) {
            System.out.print(counter + " ");
            counter++;  // FIX: Increment counter
        }
        System.out.println("\n✓ Loop terminates correctly");
        
        // BUG 6: String comparison with ==
        System.out.println("\n\nBUG 6: String Comparison Error");
        System.out.print("Enter 'yes' to continue: ");
        String input = scanner.nextLine();
        
        // BUGGY VERSION:
        if (input == "yes") {  // BUG: Using == for strings
            System.out.println("Buggy: You typed yes (using ==)");
        } else {
            System.out.println("Buggy: You didn't type yes (using ==)");
        }
        System.out.println("^ Using == often fails for strings!");
        
        // FIXED VERSION:
        if (input.equals("yes")) {  // FIX: Use .equals()
            System.out.println("Fixed: You typed yes (using .equals())");
        } else {
            System.out.println("Fixed: You didn't type yes (using .equals())");
        }
        
        // BUG 7: Logic error
        System.out.println("\n\nBUG 7: Logic Error");
        System.out.print("Enter a number between 1 and 10: ");
        int num = scanner.nextInt();
        
        // BUGGY VERSION:
        if (num < 1 && num > 10) {  // BUG: Impossible condition!
            System.out.println("Buggy: Number is out of range");
        } else {
            System.out.println("Buggy: Number is in range");
        }
        System.out.println("^ Logic error: no number can be both < 1 AND > 10!");
        
        // FIXED VERSION:
        if (num < 1 || num > 10) {  // FIX: Use OR instead of AND
            System.out.println("Fixed: Number is out of range");
        } else {
            System.out.println("Fixed: Number is in range (1-10)");
        }
        
        // Debugging tips
        System.out.println("\n\n=== DEBUGGING TIPS ===");
        System.out.println("1. SET BREAKPOINTS:");
        System.out.println("   - Click left of line number in IDE");
        System.out.println("   - Program pauses at that line");
        
        System.out.println("\n2. STEP THROUGH CODE:");
        System.out.println("   - Step Over: Execute current line");
        System.out.println("   - Step Into: Enter method calls");
        System.out.println("   - Step Out: Exit current method");
        
        System.out.println("\n3. INSPECT VARIABLES:");
        System.out.println("   - Hover over variables while debugging");
        System.out.println("   - Watch window shows current values");
        
        System.out.println("\n4. USE PRINT STATEMENTS:");
        System.out.println("   - System.out.println() to trace execution");
        System.out.println("   - Print variable values at key points");
        
        System.out.println("\n5. READ ERROR MESSAGES:");
        System.out.println("   - Line numbers show where error occurred");
        System.out.println("   - Stack trace shows method call chain");
        
        System.out.println("\n6. COMMON BUGS TO WATCH FOR:");
        System.out.println("   - Off-by-one errors (< vs <=)");
        System.out.println("   - Null pointer exceptions");
        System.out.println("   - Array index out of bounds");
        System.out.println("   - Integer division truncation");
        System.out.println("   - Infinite loops");
        System.out.println("   - String comparison with ==");
        System.out.println("   - Logic errors (AND vs OR)");
        
        System.out.println("\n7. PREVENTION:");
        System.out.println("   - Initialize variables");
        System.out.println("   - Check for null");
        System.out.println("   - Validate array indices");
        System.out.println("   - Use .equals() for strings");
        System.out.println("   - Test edge cases");
        
        scanner.close();
    }
}
