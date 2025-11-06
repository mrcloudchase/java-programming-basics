/**
 * NamesList.java
 * Demonstrates ArrayList - a dynamic, resizable array
 * More flexible than arrays, perfect for when size changes
 */
import java.util.ArrayList;
import java.util.Scanner;

public class NamesList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("=== ArrayList Demo - Team Roster ===");
        
        // Create an ArrayList of Strings
        // ArrayList can grow and shrink dynamically!
        ArrayList<String> teamMembers = new ArrayList<String>();
        // Or shorter: ArrayList<String> teamMembers = new ArrayList<>();
        
        // Add initial members
        System.out.println("Adding initial team members...");
        teamMembers.add("Alex");
        teamMembers.add("Jordan");
        teamMembers.add("Sam");
        
        // Display current roster
        System.out.println("\nCurrent team roster:");
        System.out.println("Size: " + teamMembers.size());  // Note: .size() not .length
        
        // Print using for-each loop
        for (String member : teamMembers) {
            System.out.println("  - " + member);
        }
        
        // Add more members from user input
        System.out.println("\nAdd 3 more team members:");
        for (int i = 0; i < 3; i++) {
            System.out.print("Enter name " + (i + 1) + ": ");
            String name = scanner.nextLine();
            teamMembers.add(name);
        }
        
        // Display updated roster
        System.out.println("\n--- Updated Roster ---");
        System.out.println("Total members: " + teamMembers.size());
        
        // Access by index (like arrays)
        for (int i = 0; i < teamMembers.size(); i++) {
            System.out.println((i + 1) + ". " + teamMembers.get(i));  // Note: .get(i) not [i]
        }
        
        // ArrayList specific operations
        System.out.println("\n--- ArrayList Operations ---");
        
        // Check if contains
        System.out.print("Search for member: ");
        String searchName = scanner.nextLine();
        
        if (teamMembers.contains(searchName)) {
            int position = teamMembers.indexOf(searchName);
            System.out.println(searchName + " found at position " + position);
        } else {
            System.out.println(searchName + " not found on team");
        }
        
        // Insert at specific position
        System.out.print("\nEnter name to add as team captain (will be first): ");
        String captain = scanner.nextLine();
        teamMembers.add(0, captain);  // Insert at beginning
        
        System.out.println("Updated roster with captain:");
        for (int i = 0; i < teamMembers.size(); i++) {
            String role = (i == 0) ? " (Captain)" : "";
            System.out.println((i + 1) + ". " + teamMembers.get(i) + role);
        }
        
        // Replace a member
        if (teamMembers.size() > 3) {
            System.out.println("\nReplacing member at position 3...");
            String oldMember = teamMembers.get(2);  // Position 3 is index 2
            System.out.print("Enter replacement name: ");
            String newMember = scanner.nextLine();
            teamMembers.set(2, newMember);  // Replace at index 2
            System.out.println("Replaced " + oldMember + " with " + newMember);
        }
        
        // Remove a member
        System.out.print("\nEnter name to remove from team: ");
        String toRemove = scanner.nextLine();
        
        if (teamMembers.remove(toRemove)) {  // Returns true if found and removed
            System.out.println(toRemove + " removed from team");
        } else {
            System.out.println(toRemove + " not found");
        }
        
        // ArrayList of numbers
        System.out.println("\n--- Match Scores ArrayList ---");
        ArrayList<Integer> matchScores = new ArrayList<>();  // Note: Integer, not int
        
        // Add some scores
        matchScores.add(150);
        matchScores.add(225);
        matchScores.add(180);
        matchScores.add(195);
        matchScores.add(210);
        
        System.out.println("Match scores: " + matchScores);  // ArrayList has nice toString()
        
        // Calculate statistics
        int totalScore = 0;
        int highScore = matchScores.get(0);
        int lowScore = matchScores.get(0);
        
        for (int score : matchScores) {  // Auto-unboxing from Integer to int
            totalScore += score;
            if (score > highScore) highScore = score;
            if (score < lowScore) lowScore = score;
        }
        
        double averageScore = (double) totalScore / matchScores.size();
        
        System.out.println("\nMatch Statistics:");
        System.out.println("Games played: " + matchScores.size());
        System.out.println("Total points: " + totalScore);
        System.out.printf("Average: %.1f%n", averageScore);
        System.out.println("High score: " + highScore);
        System.out.println("Low score: " + lowScore);
        
        // Clear and isEmpty
        System.out.println("\n--- Clear Operation ---");
        System.out.print("Clear match scores? (yes/no): ");
        String clearChoice = scanner.nextLine();
        
        if (clearChoice.equalsIgnoreCase("yes")) {
            matchScores.clear();
            System.out.println("Scores cleared!");
        }
        
        if (matchScores.isEmpty()) {
            System.out.println("No match scores recorded");
        } else {
            System.out.println("Scores remain: " + matchScores);
        }
        
        // ArrayList vs Array comparison
        System.out.println("\n--- ArrayList vs Array ---");
        System.out.println("ARRAY:");
        System.out.println("  - Fixed size");
        System.out.println("  - Slightly faster");
        System.out.println("  - Can hold primitives directly");
        System.out.println("  - Access with []");
        System.out.println("  - Length with .length");
        
        System.out.println("\nARRAYLIST:");
        System.out.println("  - Dynamic size");
        System.out.println("  - Can grow/shrink");
        System.out.println("  - More methods (add, remove, contains, etc.)");
        System.out.println("  - Access with .get()");
        System.out.println("  - Size with .size()");
        System.out.println("  - Must use wrapper types (Integer, Double, etc.)");
        
        // Convert ArrayList to Array if needed
        System.out.println("\n--- Final Team Roster ---");
        String[] finalRoster = teamMembers.toArray(new String[0]);
        System.out.println("Converted to array with " + finalRoster.length + " members:");
        for (String member : finalRoster) {
            System.out.println("  • " + member);
        }
        
        // Practical FRC example
        System.out.println("\n--- FRC Alliance Selection ---");
        ArrayList<String> availableTeams = new ArrayList<>();
        availableTeams.add("Team 254");
        availableTeams.add("Team 1678"); 
        availableTeams.add("Team 2056");
        availableTeams.add("Team 971");
        
        ArrayList<String> ourAlliance = new ArrayList<>();
        
        System.out.println("Available teams: " + availableTeams);
        
        // Pick teams for alliance
        while (ourAlliance.size() < 2 && !availableTeams.isEmpty()) {
            System.out.print("Pick team number (1-" + availableTeams.size() + "): ");
            int pick = scanner.nextInt() - 1;
            scanner.nextLine();
            
            if (pick >= 0 && pick < availableTeams.size()) {
                String pickedTeam = availableTeams.remove(pick);  // Remove returns the element
                ourAlliance.add(pickedTeam);
                System.out.println("Added " + pickedTeam + " to alliance");
            }
        }
        
        System.out.println("\nFinal Alliance: " + ourAlliance);
        System.out.println("Remaining teams: " + availableTeams);
        
        scanner.close();
    }
}
