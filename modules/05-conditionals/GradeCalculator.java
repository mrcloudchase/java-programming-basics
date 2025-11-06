/**
 * GradeCalculator.java
 * Demonstrates if-else chains and switch statements
 * Shows multiple ways to handle multi-way decisions
 */
import java.util.Scanner;

public class GradeCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("=== Grade Calculator ===");
        System.out.print("Enter your score (0-100): ");
        int score = scanner.nextInt();
        
        // Validate input
        if (score < 0 || score > 100) {
            System.out.println("Error: Score must be between 0 and 100");
            scanner.close();
            return;  // Exit early
        }
        
        // Method 1: if-else if chain
        System.out.println("\n--- Using if-else if chain ---");
        String letterGrade;
        String comment;
        
        if (score >= 90) {
            letterGrade = "A";
            comment = "Excellent work!";
        } else if (score >= 80) {
            letterGrade = "B";
            comment = "Good job!";
        } else if (score >= 70) {
            letterGrade = "C";
            comment = "Satisfactory";
        } else if (score >= 60) {
            letterGrade = "D";
            comment = "Needs improvement";
        } else {
            letterGrade = "F";
            comment = "Please see instructor";
        }
        
        System.out.println("Score: " + score);
        System.out.println("Grade: " + letterGrade);
        System.out.println("Comment: " + comment);
        
        // Method 2: Using switch with grade buckets
        System.out.println("\n--- Using switch statement ---");
        
        // Convert score to grade bucket for switch
        int gradeBucket = score / 10;  // 90-100 -> 9-10, 80-89 -> 8, etc.
        
        String switchGrade;
        String performance;
        
        // Modern Java switch (Java 14+) with arrow syntax
        // For older Java, use traditional switch with break statements
        switch (gradeBucket) {
            case 10:  // 100
            case 9:   // 90-99
                switchGrade = "A";
                performance = "Outstanding";
                break;
            case 8:   // 80-89
                switchGrade = "B";
                performance = "Above Average";
                break;
            case 7:   // 70-79
                switchGrade = "C";
                performance = "Average";
                break;
            case 6:   // 60-69
                switchGrade = "D";
                performance = "Below Average";
                break;
            default:  // 0-59
                switchGrade = "F";
                performance = "Failing";
                break;
        }
        
        System.out.println("Grade (via switch): " + switchGrade);
        System.out.println("Performance: " + performance);
        
        // Bonus: Plus/Minus grades using modulo
        System.out.println("\n--- Detailed Grade with +/- ---");
        String detailedGrade = letterGrade;  // Start with base grade
        
        if (!letterGrade.equals("F")) {  // No F+ or F-
            int lastDigit = score % 10;
            if (lastDigit >= 7 && score < 97) {  // No A+
                detailedGrade += "+";
            } else if (lastDigit <= 2 && !letterGrade.equals("A")) {
                detailedGrade += "-";
            }
        }
        
        System.out.println("Detailed grade: " + detailedGrade);
        
        // Robotics example: Competition ranking
        System.out.println("\n--- FRC Competition Ranking Example ---");
        System.out.print("Enter team's ranking points: ");
        int rankingPoints = scanner.nextInt();
        
        String qualification;
        if (rankingPoints >= 30) {
            qualification = "Qualified for Championships!";
        } else if (rankingPoints >= 20) {
            qualification = "Qualified for Regional Finals";
        } else if (rankingPoints >= 10) {
            qualification = "Qualified for Elimination Rounds";
        } else {
            qualification = "Keep practicing for next event";
        }
        
        System.out.println("Status: " + qualification);
        
        // Compound conditions
        System.out.println("\n--- Alliance Selection (Compound Conditions) ---");
        System.out.print("Enter autonomous points: ");
        int autoPoints = scanner.nextInt();
        System.out.print("Enter teleop points: ");
        int teleopPoints = scanner.nextInt();
        
        // Using && (AND) and || (OR) operators
        if (autoPoints >= 15 && teleopPoints >= 30) {
            System.out.println("Elite team - First pick material!");
        } else if (autoPoints >= 10 || teleopPoints >= 35) {
            System.out.println("Strong team - Good alliance partner");
        } else if (autoPoints > 0 && teleopPoints > 0) {
            System.out.println("Consistent team - Reliable choice");
        } else {
            System.out.println("Needs more development");
        }
        
        // Boolean flags for complex decisions
        boolean hasClimb = autoPoints >= 5;
        boolean hasScoring = teleopPoints >= 20;
        boolean isReliable = (autoPoints + teleopPoints) >= 40;
        
        if (hasClimb && hasScoring && isReliable) {
            System.out.println("✓ All key capabilities present");
        } else {
            System.out.println("Missing capabilities:");
            if (!hasClimb) System.out.println("  - Climbing ability");
            if (!hasScoring) System.out.println("  - Scoring consistency");
            if (!isReliable) System.out.println("  - Overall reliability");
        }
        
        scanner.close();
    }
}
