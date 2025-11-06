/**
 * ClawControl.java
 * FRC robot claw/gripper control simulation
 * Demonstrates state management and button control
 */
import java.util.Scanner;

public class ClawControl {
    // Claw states
    private enum ClawState {
        OPEN("Open", 0),
        CLOSED("Closed", 100),
        HOLDING("Holding", 75);
        
        private final String name;
        private final int power;
        
        ClawState(String name, int power) {
            this.name = name;
            this.power = power;
        }
        
        public String toString() {
            return name + " (" + power + "% power)";
        }
    }
    
    // Current state
    private static ClawState currentState = ClawState.OPEN;
    private static double clawMotorPower = 0.0;
    private static boolean hasGamePiece = false;
    private static double currentDraw = 0.0;  // Amps
    private static final double STALL_CURRENT = 15.0;  // Amps
    private static final double HOLD_CURRENT = 5.0;   // Amps
    
    // Button states (simulating controller)
    private static boolean buttonA = false;
    private static boolean buttonB = false;
    private static boolean buttonX = false;
    private static boolean buttonY = false;
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("=== FRC Claw Control Simulator ===");
        System.out.println("Control a robot claw/gripper mechanism\n");
        
        boolean running = true;
        
        while (running) {
            // Display status
            displayStatus();
            
            // Control menu
            System.out.println("\n--- Controls ---");
            System.out.println("A: Toggle Open/Close");
            System.out.println("B: Hold Position");
            System.out.println("X: Intake (spin wheels)");
            System.out.println("Y: Eject (reverse)");
            System.out.println("S: Check sensors");
            System.out.println("G: Toggle game piece");
            System.out.println("0: Exit");
            System.out.print("Press button: ");
            
            String input = scanner.nextLine().toUpperCase();
            
            // Reset buttons
            resetButtons();
            
            switch (input) {
                case "A":
                    buttonA = true;
                    toggleClaw();
                    break;
                    
                case "B":
                    buttonB = true;
                    holdPosition();
                    break;
                    
                case "X":
                    buttonX = true;
                    intake();
                    break;
                    
                case "Y":
                    buttonY = true;
                    eject();
                    break;
                    
                case "S":
                    checkSensors();
                    break;
                    
                case "G":
                    hasGamePiece = !hasGamePiece;
                    System.out.println("Game piece " + 
                                     (hasGamePiece ? "detected!" : "removed."));
                    updateCurrent();
                    break;
                    
                case "0":
                    running = false;
                    break;
                    
                default:
                    System.out.println("Unknown button!");
            }
            
            // Simulate automatic behaviors
            checkAutoBehaviors();
        }
        
        System.out.println("Claw control ended.");
        scanner.close();
    }
    
    // Display claw status
    private static void displayStatus() {
        System.out.println("\n=== Claw Status ===");
        System.out.println("State: " + currentState);
        System.out.printf("Motor Power: %.1f%%%n", clawMotorPower * 100);
        System.out.printf("Current Draw: %.1f Amps", currentDraw);
        
        if (currentDraw > STALL_CURRENT * 0.8) {
            System.out.print(" ⚠ HIGH CURRENT!");
        }
        System.out.println();
        
        System.out.println("Game Piece: " + (hasGamePiece ? "✓ Detected" : "✗ None"));
        
        // Visual representation
        visualizeClaw();
    }
    
    // Toggle between open and closed
    private static void toggleClaw() {
        if (currentState == ClawState.OPEN) {
            closeClaw();
        } else {
            openClaw();
        }
    }
    
    // Open the claw
    private static void openClaw() {
        System.out.println("Opening claw...");
        currentState = ClawState.OPEN;
        clawMotorPower = -0.5;  // Negative to open
        updateCurrent();
        
        // Check if we dropped something
        if (hasGamePiece) {
            System.out.println("⚠ Dropped game piece!");
            hasGamePiece = false;
        }
    }
    
    // Close the claw
    private static void closeClaw() {
        System.out.println("Closing claw...");
        currentState = ClawState.CLOSED;
        clawMotorPower = 0.8;  // Positive to close
        updateCurrent();
        
        // Check if we grabbed something
        if (hasGamePiece) {
            System.out.println("✓ Game piece secured!");
            currentState = ClawState.HOLDING;
        }
    }
    
    // Hold current position
    private static void holdPosition() {
        if (hasGamePiece) {
            System.out.println("Holding game piece...");
            currentState = ClawState.HOLDING;
            clawMotorPower = 0.3;  // Lower power to hold
            currentDraw = HOLD_CURRENT;
        } else {
            System.out.println("Nothing to hold!");
            clawMotorPower = 0;
            currentDraw = 0;
        }
    }
    
    // Intake (for wheeled intake)
    private static void intake() {
        System.out.println("Intake wheels spinning...");
        clawMotorPower = 1.0;
        updateCurrent();
        
        // Simulate getting game piece
        if (!hasGamePiece && Math.random() > 0.5) {
            hasGamePiece = true;
            System.out.println("✓ Game piece acquired!");
        }
    }
    
    // Eject game piece
    private static void eject() {
        System.out.println("Ejecting...");
        clawMotorPower = -1.0;
        updateCurrent();
        
        if (hasGamePiece) {
            hasGamePiece = false;
            System.out.println("Game piece ejected!");
            currentState = ClawState.OPEN;
        }
    }
    
    // Check sensors
    private static void checkSensors() {
        System.out.println("\n--- Sensor Readings ---");
        
        // Limit switches
        boolean openLimit = (currentState == ClawState.OPEN);
        boolean closedLimit = (currentState == ClawState.CLOSED || 
                              currentState == ClawState.HOLDING);
        
        System.out.println("Open Limit Switch: " + openLimit);
        System.out.println("Closed Limit Switch: " + closedLimit);
        
        // Current sensor
        System.out.printf("Motor Current: %.1f A%n", currentDraw);
        if (currentDraw > STALL_CURRENT) {
            System.out.println("⚠ MOTOR STALL DETECTED!");
        }
        
        // Game piece sensor
        System.out.println("Game Piece Sensor: " + hasGamePiece);
        
        // Position encoder (simulated)
        int encoderPosition = 0;
        switch (currentState) {
            case OPEN:
                encoderPosition = 0;
                break;
            case CLOSED:
            case HOLDING:
                encoderPosition = 1000;
                break;
        }
        System.out.println("Encoder Position: " + encoderPosition + " ticks");
    }
    
    // Update current draw based on state
    private static void updateCurrent() {
        if (clawMotorPower == 0) {
            currentDraw = 0;
        } else if (currentState == ClawState.HOLDING && hasGamePiece) {
            currentDraw = HOLD_CURRENT;
        } else if (Math.abs(clawMotorPower) > 0.7 && hasGamePiece) {
            currentDraw = STALL_CURRENT * 0.9;  // High current with load
        } else {
            currentDraw = Math.abs(clawMotorPower) * 8.0;  // Normal operation
        }
    }
    
    // Check for automatic behaviors
    private static void checkAutoBehaviors() {
        // Auto-stop on high current (stall protection)
        if (currentDraw > STALL_CURRENT) {
            System.out.println("⚠ STALL PROTECTION - Motor stopped!");
            clawMotorPower = 0;
            currentDraw = 0;
        }
        
        // Auto-hold when game piece detected
        if (hasGamePiece && currentState == ClawState.CLOSED) {
            currentState = ClawState.HOLDING;
            clawMotorPower = 0.3;  // Reduce power to hold
            currentDraw = HOLD_CURRENT;
        }
        
        // Stop motor if at limits
        if (currentState == ClawState.OPEN && clawMotorPower < 0) {
            clawMotorPower = 0;  // Already open, stop opening
        } else if ((currentState == ClawState.CLOSED || 
                   currentState == ClawState.HOLDING) && clawMotorPower > 0) {
            if (!hasGamePiece) {
                clawMotorPower = 0;  // Already closed, stop closing
            }
        }
    }
    
    // Reset button states
    private static void resetButtons() {
        buttonA = false;
        buttonB = false;
        buttonX = false;
        buttonY = false;
    }
    
    // Visual representation of claw
    private static void visualizeClaw() {
        System.out.println("\nClaw Visual:");
        
        switch (currentState) {
            case OPEN:
                System.out.println("  \\   /");
                System.out.println("   \\ /");
                System.out.println("    V");
                if (hasGamePiece) {
                    System.out.println("    o  (dropping)");
                }
                break;
                
            case CLOSED:
            case HOLDING:
                System.out.println("   | |");
                System.out.println("   | |");
                System.out.println("   |_|");
                if (hasGamePiece) {
                    System.out.println("   [■]  (holding)");
                }
                break;
        }
        
        // Power indicator
        System.out.print("Power: ");
        int powerBars = (int)(Math.abs(clawMotorPower) * 10);
        for (int i = 0; i < powerBars; i++) {
            System.out.print("█");
        }
        System.out.println();
    }
}
