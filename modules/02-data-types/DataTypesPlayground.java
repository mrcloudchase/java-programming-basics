/**
 * DataTypesPlayground.java
 * Demonstrates Java's primitive data types and basic operations
 */
public class DataTypesPlayground {
    public static void main(String[] args) {
        // Primitive data types in Java
        
        // Integer types
        int robotSpeed = 75;        // Whole numbers (-2^31 to 2^31-1)
        byte smallNumber = 127;     // -128 to 127
        short mediumNumber = 32000; // -32768 to 32767
        long bigNumber = 9_000_000_000L; // Note the 'L' suffix for long
        
        // Floating-point types
        double voltage = 12.6;      // Double precision (64-bit)
        float motorPower = 0.85f;   // Single precision (32-bit) - note 'f' suffix
        
        // Boolean type
        boolean isAutonomous = true; // true or false only
        
        // Character type
        char teamLetter = 'A';      // Single character in single quotes
        
        // String is NOT primitive (it's an object), but very common
        String teamName = "Robotics Eagles";
        
        // Print all values
        System.out.println("=== Java Data Types ===");
        System.out.println("int robotSpeed: " + robotSpeed);
        System.out.println("byte smallNumber: " + smallNumber);
        System.out.println("double voltage: " + voltage);
        System.out.println("float motorPower: " + motorPower);
        System.out.println("boolean isAutonomous: " + isAutonomous);
        System.out.println("char teamLetter: " + teamLetter);
        System.out.println("String teamName: " + teamName);
        
        System.out.println("\n=== Integer vs Double Division ===");
        // Integer division truncates (removes decimal part)
        int intResult = 7 / 2;
        System.out.println("7 / 2 (integer division) = " + intResult);  // 3
        
        // Double division keeps decimal
        double doubleResult = 7.0 / 2.0;
        System.out.println("7.0 / 2.0 (double division) = " + doubleResult);  // 3.5
        
        // Mixed division promotes to double
        double mixedResult = 7.0 / 2;  // One double makes result double
        System.out.println("7.0 / 2 (mixed division) = " + mixedResult);  // 3.5
        
        System.out.println("\n=== Type Casting ===");
        // Widening cast (automatic) - no data loss
        int score = 100;
        double scoreAsDouble = score;  // Automatic conversion
        System.out.println("int 100 -> double: " + scoreAsDouble);
        
        // Narrowing cast (manual) - possible data loss!
        double piValue = 3.14159;
        int piAsInt = (int) piValue;  // Must explicitly cast
        System.out.println("double 3.14159 -> int: " + piAsInt);  // Loses decimal part
        
        // Be careful with narrowing!
        int bigInt = 300;
        byte smallByte = (byte) bigInt;  // Overflow warning!
        System.out.println("int 300 -> byte: " + smallByte);  // Unexpected result due to overflow
        
        System.out.println("\n=== Special Values ===");
        // Integer limits
        System.out.println("Max int: " + Integer.MAX_VALUE);
        System.out.println("Min int: " + Integer.MIN_VALUE);
        
        // Special double values
        double infinity = Double.POSITIVE_INFINITY;
        double notANumber = Double.NaN;
        System.out.println("Infinity: " + infinity);
        System.out.println("NaN (Not a Number): " + notANumber);
    }
}
