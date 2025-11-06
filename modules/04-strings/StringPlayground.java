/**
 * StringPlayground.java
 * Demonstrates String operations essential for text processing
 * Important for parsing commands, displaying data, and logging in robotics
 */
import java.util.Scanner;

public class StringPlayground {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("=== String Operations Playground ===");
        System.out.print("Enter a full line of text: ");
        
        // Read entire line (including spaces)
        String fullLine = scanner.nextLine();
        
        // Basic string properties
        System.out.println("\n--- String Properties ---");
        System.out.println("Your text: \"" + fullLine + "\"");
        System.out.println("Length: " + fullLine.length() + " characters");
        
        // Check if string is empty
        if (fullLine.length() > 0) {
            // Access characters
            char firstChar = fullLine.charAt(0);
            char lastChar = fullLine.charAt(fullLine.length() - 1);
            System.out.println("First character: '" + firstChar + "'");
            System.out.println("Last character: '" + lastChar + "'");
        }
        
        // CRITICAL: equals() vs == for Strings
        System.out.println("\n--- String Comparison (equals vs ==) ---");
        String test1 = "ROBOT";
        String test2 = "ROBOT";
        String test3 = new String("ROBOT");  // Force new object
        
        // == compares memory addresses (usually wrong for Strings!)
        System.out.println("test1 == test2: " + (test1 == test2));     // May be true (string pool)
        System.out.println("test1 == test3: " + (test1 == test3));     // False (different objects)
        
        // equals() compares actual content (this is what you want!)
        System.out.println("test1.equals(test2): " + test1.equals(test2));  // True
        System.out.println("test1.equals(test3): " + test1.equals(test3));  // True
        
        // Case-insensitive comparison
        String command1 = "START";
        String command2 = "start";
        System.out.println("\"START\".equalsIgnoreCase(\"start\"): " + 
                          command1.equalsIgnoreCase(command2));  // True
        
        // Substring operations
        System.out.println("\n--- Substring Operations ---");
        if (fullLine.length() >= 5) {
            String firstFive = fullLine.substring(0, 5);  // From index 0 to 4
            System.out.println("First 5 characters: \"" + firstFive + "\"");
            
            String fromThird = fullLine.substring(2);  // From index 2 to end
            System.out.println("From 3rd character onward: \"" + fromThird + "\"");
        }
        
        // indexOf - finding characters or substrings
        System.out.println("\n--- Finding Text with indexOf ---");
        System.out.print("Enter a word to search for: ");
        String searchWord = scanner.next();
        scanner.nextLine();  // Clear buffer
        
        int position = fullLine.indexOf(searchWord);
        if (position != -1) {
            System.out.println("\"" + searchWord + "\" found at position: " + position);
            
            // Check for multiple occurrences
            int lastPos = fullLine.lastIndexOf(searchWord);
            if (lastPos != position) {
                System.out.println("Last occurrence at position: " + lastPos);
            }
        } else {
            System.out.println("\"" + searchWord + "\" not found in the text");
        }
        
        // String replacement
        System.out.println("\n--- String Replacement ---");
        System.out.print("Enter word to replace: ");
        String oldWord = scanner.next();
        System.out.print("Enter replacement word: ");
        String newWord = scanner.next();
        scanner.nextLine();  // Clear buffer
        
        String modified = fullLine.replace(oldWord, newWord);
        System.out.println("Original: \"" + fullLine + "\"");
        System.out.println("Modified: \"" + modified + "\"");
        System.out.println("Note: Original string unchanged (Strings are immutable)");
        
        // String case conversion
        System.out.println("\n--- Case Conversion ---");
        System.out.println("UPPERCASE: " + fullLine.toUpperCase());
        System.out.println("lowercase: " + fullLine.toLowerCase());
        
        // Trimming whitespace
        String padded = "  TEAM 1234  ";
        System.out.println("\n--- Trimming Whitespace ---");
        System.out.println("Before trim: \"" + padded + "\"");
        System.out.println("After trim: \"" + padded.trim() + "\"");
        
        // String splitting
        System.out.println("\n--- Splitting Strings ---");
        String data = "Motor1:75,Motor2:50,Motor3:100";
        System.out.println("Data string: " + data);
        String[] parts = data.split(",");
        System.out.println("Split by comma:");
        for (int i = 0; i < parts.length; i++) {
            System.out.println("  Part " + i + ": " + parts[i]);
        }
        
        // StringBuilder for efficient string building
        System.out.println("\n--- StringBuilder (Efficient for Loops) ---");
        StringBuilder sb = new StringBuilder();
        sb.append("Building");
        sb.append(" a");
        sb.append(" string");
        sb.append(" efficiently!");
        System.out.println("Built string: " + sb.toString());
        
        // Performance note
        System.out.println("\nPerformance tip: Use StringBuilder when building strings in loops:");
        StringBuilder telemetry = new StringBuilder("Telemetry: ");
        for (int i = 1; i <= 5; i++) {
            telemetry.append("Sensor").append(i).append("=OK ");
        }
        System.out.println(telemetry.toString());
        
        // String formatting
        System.out.println("\n--- String Formatting ---");
        int motorPower = 75;
        double batteryVoltage = 12.4;
        String status = String.format("Motor: %d%%, Battery: %.1fV", motorPower, batteryVoltage);
        System.out.println("Formatted status: " + status);
        
        scanner.close();
    }
}
