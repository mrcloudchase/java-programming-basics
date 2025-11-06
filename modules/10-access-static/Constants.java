/**
 * Constants.java
 * Demonstrates static final variables for constants
 * Common pattern for shared values across the application
 */
public class Constants {
    // Static final = constant value shared by all classes
    // Convention: UPPER_CASE_WITH_UNDERSCORES
    
    // Tax and financial constants
    public static final double SALES_TAX = 0.0825;  // 8.25%
    public static final double DISCOUNT_RATE = 0.10;  // 10% discount
    public static final double SHIPPING_FEE = 5.99;
    
    // FRC Robot constants
    public static final double MAX_MOTOR_POWER = 1.0;
    public static final double MIN_MOTOR_POWER = -1.0;
    public static final double JOYSTICK_DEADBAND = 0.1;
    
    // Field dimensions (in meters)
    public static final double FIELD_LENGTH = 16.46;  // ~54 feet
    public static final double FIELD_WIDTH = 8.23;    // ~27 feet
    
    // Robot specifications
    public static final int MAX_ROBOT_WEIGHT_LBS = 125;
    public static final double MAX_ROBOT_HEIGHT_METERS = 1.37;  // ~4.5 feet
    public static final double WHEEL_DIAMETER_INCHES = 6.0;
    
    // Match timing (in seconds)
    public static final int AUTONOMOUS_PERIOD = 15;
    public static final int TELEOP_PERIOD = 135;
    public static final int TOTAL_MATCH_TIME = AUTONOMOUS_PERIOD + TELEOP_PERIOD;
    
    // Mathematical constants
    public static final double PI = 3.14159265359;
    public static final double E = 2.71828182846;
    
    // Private constructor prevents instantiation
    // This class should only be used for its static constants
    private Constants() {
        // Empty - this class shouldn't be instantiated
    }
    
    // Static method to display all constants
    public static void displayConstants() {
        System.out.println("=== Application Constants ===");
        System.out.println("Sales Tax: " + (SALES_TAX * 100) + "%");
        System.out.println("Discount Rate: " + (DISCOUNT_RATE * 100) + "%");
        System.out.println("Shipping Fee: $" + SHIPPING_FEE);
        
        System.out.println("\n=== FRC Constants ===");
        System.out.println("Field: " + FIELD_LENGTH + "m x " + FIELD_WIDTH + "m");
        System.out.println("Max Robot Weight: " + MAX_ROBOT_WEIGHT_LBS + " lbs");
        System.out.println("Match Time: " + TOTAL_MATCH_TIME + " seconds");
        System.out.println("  - Autonomous: " + AUTONOMOUS_PERIOD + "s");
        System.out.println("  - Teleop: " + TELEOP_PERIOD + "s");
    }
}
