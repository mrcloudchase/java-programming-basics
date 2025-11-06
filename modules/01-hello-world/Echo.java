/**
 * Echo.java
 * Demonstrates basic input/output with Scanner
 */
import java.util.Scanner;

public class Echo {
    public static void main(String[] args) {
        // Scanner lets us read input from the keyboard
        Scanner scanner = new Scanner(System.in);
        
        // Prompt the user
        System.out.print("Enter a word: ");
        
        // Read one word (stops at space)
        String word = scanner.next();
        
        // Echo it back
        System.out.println("You said: " + word);
        
        // Good practice: close the scanner when done
        scanner.close();
    }
}
