/**
 * VowelCounter.java
 * Demonstrates for-each loop (enhanced for loop) with character arrays
 * Shows string processing and counting patterns
 */
import java.util.Scanner;

public class VowelCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("=== Vowel Counter ===");
        System.out.print("Enter a line of text: ");
        String text = scanner.nextLine();
        
        // Convert to lowercase for easier checking
        String lowerText = text.toLowerCase();
        
        // Method 1: For-each loop over character array
        System.out.println("\n--- Using for-each loop ---");
        
        int vowelCount = 0;
        int consonantCount = 0;
        int digitCount = 0;
        int spaceCount = 0;
        int otherCount = 0;
        
        // Count each vowel separately
        int aCount = 0, eCount = 0, iCount = 0, oCount = 0, uCount = 0;
        
        // Convert string to character array for for-each loop
        char[] characters = lowerText.toCharArray();
        
        // Enhanced for loop (for-each)
        // Syntax: for (type variable : array/collection)
        for (char ch : characters) {
            // Check character type
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                vowelCount++;
                
                // Count individual vowels
                switch (ch) {
                    case 'a': aCount++; break;
                    case 'e': eCount++; break;
                    case 'i': iCount++; break;
                    case 'o': oCount++; break;
                    case 'u': uCount++; break;
                }
            } else if (ch >= 'a' && ch <= 'z') {
                consonantCount++;
            } else if (ch >= '0' && ch <= '9') {
                digitCount++;
            } else if (ch == ' ') {
                spaceCount++;
            } else {
                otherCount++;
            }
        }
        
        // Display results
        System.out.println("Total characters: " + text.length());
        System.out.println("Vowels: " + vowelCount);
        System.out.println("Consonants: " + consonantCount);
        System.out.println("Digits: " + digitCount);
        System.out.println("Spaces: " + spaceCount);
        System.out.println("Other: " + otherCount);
        
        // Individual vowel breakdown
        System.out.println("\n--- Vowel Breakdown ---");
        System.out.println("A: " + aCount);
        System.out.println("E: " + eCount);
        System.out.println("I: " + iCount);
        System.out.println("O: " + oCount);
        System.out.println("U: " + uCount);
        
        // Method 2: Traditional for loop with charAt()
        System.out.println("\n--- Using traditional for loop ---");
        
        int vowelCount2 = 0;
        for (int i = 0; i < lowerText.length(); i++) {
            char currentChar = lowerText.charAt(i);
            if ("aeiou".indexOf(currentChar) != -1) {
                vowelCount2++;
            }
        }
        
        System.out.println("Vowel count (method 2): " + vowelCount2);
        
        // Method 3: While loop with indexOf
        System.out.println("\n--- Finding vowel positions ---");
        String vowels = "aeiou";
        
        for (int i = 0; i < text.length() && i < 50; i++) {  // Limit to first 50 chars for display
            char original = text.charAt(i);
            char lower = Character.toLowerCase(original);
            
            if (vowels.indexOf(lower) != -1) {
                System.out.println("Vowel '" + original + "' at position " + i);
            }
        }
        
        // Word analysis
        System.out.println("\n--- Word Analysis ---");
        String[] words = text.split("\\s+");  // Split on whitespace
        
        int wordsWithVowels = 0;
        int wordsAllVowels = 0;
        int wordsNoVowels = 0;
        
        for (String word : words) {
            if (word.isEmpty()) continue;
            
            int wordVowelCount = 0;
            String lowerWord = word.toLowerCase();
            
            for (char ch : lowerWord.toCharArray()) {
                if ("aeiou".indexOf(ch) != -1) {
                    wordVowelCount++;
                }
            }
            
            if (wordVowelCount == word.length()) {
                wordsAllVowels++;
                System.out.println("All vowels: " + word);
            } else if (wordVowelCount == 0) {
                wordsNoVowels++;
                System.out.println("No vowels: " + word);
            } else {
                wordsWithVowels++;
            }
        }
        
        System.out.println("\nWord statistics:");
        System.out.println("Total words: " + words.length);
        System.out.println("Words with mixed letters: " + wordsWithVowels);
        System.out.println("Words with all vowels: " + wordsAllVowels);
        System.out.println("Words with no vowels: " + wordsNoVowels);
        
        // Pattern visualization
        System.out.println("\n--- Vowel Pattern Visualization ---");
        System.out.print("Pattern: ");
        
        int maxDisplay = Math.min(text.length(), 50);
        for (int i = 0; i < maxDisplay; i++) {
            char ch = Character.toLowerCase(text.charAt(i));
            if ("aeiou".indexOf(ch) != -1) {
                System.out.print("V");  // Vowel
            } else if (ch == ' ') {
                System.out.print(" ");  // Space
            } else {
                System.out.print("-");  // Consonant or other
            }
        }
        
        if (text.length() > 50) {
            System.out.print("...");
        }
        System.out.println();
        
        // Calculate percentage
        double vowelPercentage = (vowelCount * 100.0) / text.length();
        System.out.printf("\nVowels make up %.1f%% of the text%n", vowelPercentage);
        
        scanner.close();
    }
}
