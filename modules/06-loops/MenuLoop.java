/**
 * MenuLoop.java  
 * Demonstrates while loops, break, and continue statements
 * Shows a typical menu-driven program structure
 */
import java.util.Scanner;

public class MenuLoop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Variables for robot simulation
        double batteryLevel = 100.0;
        int motorPower = 0;
        boolean isAutonomous = false;
        int cycleCount = 0;
        
        System.out.println("=== FRC Robot Control Menu ===");
        System.out.println("Welcome to the robot control simulator!");
        
        // Main menu loop - continues until user chooses exit
        boolean running = true;
        
        while (running) {
            cycleCount++;
            
            // Display menu
            System.out.println("\n--- Main Menu (Cycle " + cycleCount + ") ---");
            System.out.println("1. Drive Robot");
            System.out.println("2. Check Status");
            System.out.println("3. Toggle Autonomous Mode");
            System.out.println("4. Recharge Battery");
            System.out.println("5. Run Diagnostic");
            System.out.println("6. Practice Loop Controls");
            System.out.println("0. Exit");
            System.out.print("Choose option: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline
            
            // Process menu choice
            switch (choice) {
                case 1:  // Drive Robot
                    if (batteryLevel < 10) {
                        System.out.println("⚠ Battery too low! Recharge first.");
                        continue;  // Skip to next loop iteration
                    }
                    
                    System.out.print("Enter motor power (0-100): ");
                    motorPower = scanner.nextInt();
                    scanner.nextLine();
                    
                    if (motorPower < 0 || motorPower > 100) {
                        System.out.println("Invalid power! Must be 0-100.");
                        motorPower = 0;
                        continue;  // Skip rest, go to next iteration
                    }
                    
                    // Simulate driving
                    double powerUsage = motorPower * 0.5;  // Higher power = more battery drain
                    batteryLevel -= powerUsage;
                    if (batteryLevel < 0) batteryLevel = 0;
                    
                    System.out.println("🤖 Driving at " + motorPower + "% power");
                    System.out.printf("Battery used: %.1f%%, Remaining: %.1f%%%n", 
                                    powerUsage, batteryLevel);
                    break;
                    
                case 2:  // Check Status
                    System.out.println("\n=== Robot Status ===");
                    System.out.printf("Battery: %.1f%%%n", batteryLevel);
                    System.out.println("Motor Power: " + motorPower + "%");
                    System.out.println("Mode: " + (isAutonomous ? "Autonomous" : "Teleop"));
                    System.out.println("Cycles Run: " + cycleCount);
                    
                    // Battery warning levels
                    if (batteryLevel < 20) {
                        System.out.println("⚠ WARNING: Low battery!");
                    } else if (batteryLevel < 50) {
                        System.out.println("📊 Battery at half capacity");
                    } else {
                        System.out.println("✅ Battery level good");
                    }
                    break;
                    
                case 3:  // Toggle Autonomous
                    isAutonomous = !isAutonomous;  // Toggle boolean
                    System.out.println("Mode switched to: " + 
                                     (isAutonomous ? "AUTONOMOUS" : "TELEOP"));
                    
                    if (isAutonomous) {
                        // Run autonomous sequence
                        System.out.println("Running autonomous sequence...");
                        for (int i = 1; i <= 3; i++) {
                            System.out.println("  Step " + i + " of 3");
                            batteryLevel -= 5;
                        }
                        System.out.println("Autonomous sequence complete!");
                    }
                    break;
                    
                case 4:  // Recharge
                    System.out.println("🔋 Recharging battery...");
                    
                    // Simulate charging with progress indicator
                    while (batteryLevel < 100) {
                        batteryLevel += 20;
                        if (batteryLevel > 100) batteryLevel = 100;
                        
                        // Progress bar
                        System.out.print("\rCharging: [");
                        int bars = (int)(batteryLevel / 10);
                        for (int i = 0; i < 10; i++) {
                            if (i < bars) {
                                System.out.print("█");
                            } else {
                                System.out.print("-");
                            }
                        }
                        System.out.printf("] %.0f%%", batteryLevel);
                        
                        if (batteryLevel >= 100) {
                            System.out.println("\n✅ Fully charged!");
                            break;  // Exit charging loop
                        }
                    }
                    break;
                    
                case 5:  // Diagnostic
                    System.out.println("\n=== Running Diagnostic ===");
                    
                    // Nested loop example
                    for (int system = 1; system <= 3; system++) {
                        System.out.print("Checking system " + system + ": ");
                        
                        for (int check = 1; check <= 5; check++) {
                            System.out.print(".");
                            // Simulate processing time
                            try {
                                Thread.sleep(100);  // 100ms delay
                            } catch (InterruptedException e) {
                                // Ignore
                            }
                        }
                        
                        System.out.println(" OK");
                    }
                    
                    System.out.println("All systems operational!");
                    break;
                    
                case 6:  // Loop control demonstration
                    System.out.println("\n=== Loop Control Practice ===");
                    
                    // Demonstrate break
                    System.out.println("\n1. BREAK example - find first negative:");
                    int[] numbers = {5, 3, -2, 8, -1, 7};
                    
                    for (int num : numbers) {
                        System.out.print(num + " ");
                        if (num < 0) {
                            System.out.println("\n   Found negative: " + num);
                            break;  // Exit loop immediately
                        }
                    }
                    
                    // Demonstrate continue
                    System.out.println("\n2. CONTINUE example - skip negatives:");
                    int sum = 0;
                    for (int num : numbers) {
                        if (num < 0) {
                            System.out.println("   Skipping " + num);
                            continue;  // Skip to next iteration
                        }
                        sum += num;
                        System.out.println("   Adding " + num + ", sum = " + sum);
                    }
                    System.out.println("   Final sum (positives only): " + sum);
                    
                    // Demonstrate do-while
                    System.out.println("\n3. DO-WHILE example - validate input:");
                    int userNum;
                    do {
                        System.out.print("   Enter a number between 1-10: ");
                        userNum = scanner.nextInt();
                        scanner.nextLine();
                        
                        if (userNum < 1 || userNum > 10) {
                            System.out.println("   Invalid! Try again.");
                        }
                    } while (userNum < 1 || userNum > 10);
                    
                    System.out.println("   Valid input: " + userNum);
                    
                    // Infinite loop with break condition
                    System.out.println("\n4. Infinite loop with break condition:");
                    System.out.println("   Type 'stop' to exit this mini-loop");
                    
                    while (true) {  // Infinite loop
                        System.out.print("   > ");
                        String input = scanner.nextLine();
                        
                        if (input.equalsIgnoreCase("stop")) {
                            System.out.println("   Breaking out!");
                            break;
                        }
                        
                        System.out.println("   You typed: " + input);
                    }
                    break;
                    
                case 0:  // Exit
                    System.out.println("\n=== Shutdown Sequence ===");
                    
                    // Countdown using for loop
                    System.out.print("Shutting down in: ");
                    for (int i = 3; i > 0; i--) {
                        System.out.print(i + "... ");
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException e) {
                            // Ignore
                        }
                    }
                    
                    System.out.println("\nGoodbye!");
                    running = false;  // This will exit the main while loop
                    break;
                    
                default:
                    System.out.println("Invalid option! Please try again.");
                    // No break needed for default as it's the last case
            }
            
            // Check for critical battery
            if (batteryLevel <= 0 && running) {
                System.out.println("\n⚠ CRITICAL: Battery depleted! Forcing shutdown.");
                running = false;
            }
        }
        
        // Final statistics (after loop ends)
        System.out.println("\n=== Session Statistics ===");
        System.out.println("Total menu cycles: " + cycleCount);
        System.out.printf("Final battery level: %.1f%%%n", batteryLevel);
        System.out.println("Thanks for using Robot Control!");
        
        scanner.close();
    }
}
