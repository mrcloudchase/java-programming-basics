/**
 * DriveStop.java
 * FRC robot drive control simulation
 * Demonstrates joystick input processing and safety controls
 */
import java.util.Scanner;

public class DriveStop {
    // Robot constants
    private static final double MAX_SPEED = 1.0;  // Maximum motor speed
    private static final double MIN_SPEED = -1.0; // Minimum (reverse) speed
    private static final double DEADBAND = 0.1;   // Joystick deadband
    private static final double SAFETY_DISTANCE = 0.5;  // meters
    
    // Robot state
    private static double leftMotorPower = 0.0;
    private static double rightMotorPower = 0.0;
    private static double distanceToWall = 5.0;  // meters
    private static boolean isEnabled = false;
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("=== FRC Drive Control Simulator ===");
        System.out.println("Simulates robot drive with safety features\n");
        
        boolean running = true;
        
        while (running) {
            // Display current status
            displayStatus();
            
            // Menu
            System.out.println("\n--- Control Menu ---");
            System.out.println("1. Toggle Enable/Disable");
            System.out.println("2. Tank Drive Input");
            System.out.println("3. Arcade Drive Input");
            System.out.println("4. Update Distance Sensor");
            System.out.println("5. Emergency Stop");
            System.out.println("6. Run Autonomous");
            System.out.println("0. Exit");
            System.out.print("Choose: ");
            
            int choice = scanner.nextInt();
            
            switch (choice) {
                case 1:  // Toggle enable
                    isEnabled = !isEnabled;
                    if (!isEnabled) {
                        stopMotors();
                    }
                    System.out.println("Robot " + (isEnabled ? "ENABLED" : "DISABLED"));
                    break;
                    
                case 2:  // Tank drive
                    if (!isEnabled) {
                        System.out.println("⚠ Robot is disabled! Enable first.");
                        break;
                    }
                    
                    System.out.print("Left joystick Y (-1 to 1): ");
                    double leftY = scanner.nextDouble();
                    System.out.print("Right joystick Y (-1 to 1): ");
                    double rightY = scanner.nextDouble();
                    
                    tankDrive(leftY, rightY);
                    break;
                    
                case 3:  // Arcade drive
                    if (!isEnabled) {
                        System.out.println("⚠ Robot is disabled! Enable first.");
                        break;
                    }
                    
                    System.out.print("Forward/Back (-1 to 1): ");
                    double forward = scanner.nextDouble();
                    System.out.print("Turn (-1 to 1): ");
                    double turn = scanner.nextDouble();
                    
                    arcadeDrive(forward, turn);
                    break;
                    
                case 4:  // Update distance
                    System.out.print("Distance to wall (meters): ");
                    distanceToWall = scanner.nextDouble();
                    
                    // Auto-stop if too close
                    if (distanceToWall < SAFETY_DISTANCE && isEnabled) {
                        System.out.println("⚠ TOO CLOSE TO WALL - AUTO STOP!");
                        stopMotors();
                    }
                    break;
                    
                case 5:  // Emergency stop
                    emergencyStop();
                    break;
                    
                case 6:  // Run autonomous
                    runAutonomous();
                    break;
                    
                case 0:  // Exit
                    running = false;
                    break;
                    
                default:
                    System.out.println("Invalid choice!");
            }
        }
        
        System.out.println("Drive simulation ended.");
        scanner.close();
    }
    
    // Display robot status
    private static void displayStatus() {
        System.out.println("\n=== Robot Status ===");
        System.out.println("State: " + (isEnabled ? "ENABLED" : "DISABLED"));
        System.out.printf("Left Motor:  %+.2f (%d%%)%n", 
                         leftMotorPower, (int)(leftMotorPower * 100));
        System.out.printf("Right Motor: %+.2f (%d%%)%n", 
                         rightMotorPower, (int)(rightMotorPower * 100));
        System.out.printf("Distance to wall: %.2f meters", distanceToWall);
        
        if (distanceToWall < SAFETY_DISTANCE) {
            System.out.print(" ⚠ WARNING!");
        }
        System.out.println();
        
        // Visual representation
        visualizeRobot();
    }
    
    // Tank drive control
    private static void tankDrive(double leftY, double rightY) {
        // Apply deadband
        leftY = applyDeadband(leftY);
        rightY = applyDeadband(rightY);
        
        // Safety check
        if (distanceToWall < SAFETY_DISTANCE) {
            // Only allow backing up
            if (leftY > 0 || rightY > 0) {
                System.out.println("⚠ Too close to wall! Only reverse allowed.");
                leftY = Math.min(leftY, 0);
                rightY = Math.min(rightY, 0);
            }
        }
        
        // Set motor powers
        leftMotorPower = clamp(leftY, MIN_SPEED, MAX_SPEED);
        rightMotorPower = clamp(rightY, MIN_SPEED, MAX_SPEED);
        
        System.out.println("Tank drive engaged!");
    }
    
    // Arcade drive control
    private static void arcadeDrive(double forward, double turn) {
        // Apply deadband
        forward = applyDeadband(forward);
        turn = applyDeadband(turn);
        
        // Calculate motor powers
        double left = forward + turn;
        double right = forward - turn;
        
        // Normalize if needed
        double maxMagnitude = Math.max(Math.abs(left), Math.abs(right));
        if (maxMagnitude > 1.0) {
            left /= maxMagnitude;
            right /= maxMagnitude;
        }
        
        // Safety check
        if (distanceToWall < SAFETY_DISTANCE && forward > 0) {
            System.out.println("⚠ Too close to wall! Limiting forward speed.");
            forward = 0;
            left = turn;
            right = -turn;
        }
        
        leftMotorPower = clamp(left, MIN_SPEED, MAX_SPEED);
        rightMotorPower = clamp(right, MIN_SPEED, MAX_SPEED);
        
        System.out.println("Arcade drive engaged!");
    }
    
    // Apply deadband to joystick input
    private static double applyDeadband(double value) {
        if (Math.abs(value) < DEADBAND) {
            return 0;
        }
        return value;
    }
    
    // Clamp value between min and max
    private static double clamp(double value, double min, double max) {
        if (value > max) return max;
        if (value < min) return min;
        return value;
    }
    
    // Stop all motors
    private static void stopMotors() {
        leftMotorPower = 0;
        rightMotorPower = 0;
        System.out.println("Motors stopped.");
    }
    
    // Emergency stop
    private static void emergencyStop() {
        isEnabled = false;
        stopMotors();
        System.out.println("🛑 EMERGENCY STOP ACTIVATED!");
    }
    
    // Simple autonomous routine
    private static void runAutonomous() {
        System.out.println("\n=== Running Autonomous ===");
        
        if (!isEnabled) {
            System.out.println("Enable robot first!");
            return;
        }
        
        // Simulate autonomous sequence
        String[] actions = {
            "Moving forward...",
            "Turning left...",
            "Moving forward...",
            "Deploying game piece...",
            "Backing up...",
            "Complete!"
        };
        
        for (String action : actions) {
            System.out.println(action);
            
            // Simulate time delay
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                // Ignore
            }
            
            // Check safety
            if (distanceToWall < SAFETY_DISTANCE) {
                System.out.println("⚠ Obstacle detected - aborting autonomous!");
                stopMotors();
                break;
            }
        }
        
        stopMotors();
        System.out.println("Autonomous ended.");
    }
    
    // Visual representation of robot
    private static void visualizeRobot() {
        System.out.println("\n   [ROBOT]");
        
        // Left motor
        System.out.print("L: ");
        printMotorBar(leftMotorPower);
        
        // Right motor
        System.out.print("R: ");
        printMotorBar(rightMotorPower);
    }
    
    // Print motor power as visual bar
    private static void printMotorBar(double power) {
        int bars = (int)(Math.abs(power) * 10);
        
        if (power < 0) {
            System.out.print("← ");
            for (int i = 0; i < bars; i++) {
                System.out.print("█");
            }
        } else if (power > 0) {
            for (int i = 0; i < bars; i++) {
                System.out.print("█");
            }
            System.out.print(" →");
        } else {
            System.out.print("STOP");
        }
        
        System.out.printf(" (%+.1f)%n", power);
    }
}
