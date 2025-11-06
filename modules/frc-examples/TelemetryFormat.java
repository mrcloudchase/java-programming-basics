/**
 * TelemetryFormat.java
 * FRC telemetry and data formatting demonstration
 * Shows how to format and display robot data for debugging
 */
import java.util.Scanner;
import java.util.ArrayList;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class TelemetryFormat {
    // Robot telemetry data
    private static class RobotData {
        double batteryVoltage = 12.6;
        double matchTime = 135.0;  // seconds
        int allianceScore = 0;
        int robotX = 8;  // Field position in meters
        int robotY = 4;
        double robotHeading = 45.0;  // degrees
        double[] motorTemps = {45.2, 48.7, 51.3, 46.8};  // Celsius
        double[] motorCurrents = {15.2, 18.5, 12.3, 14.7};  // Amps
        boolean isAutonomous = false;
        String currentCommand = "Idle";
        ArrayList<String> eventLog = new ArrayList<>();
        int gearRatio = 10;
        double wheelDiameter = 6.0;  // inches
        int encoderTicks = 0;
    }
    
    private static RobotData robot = new RobotData();
    private static DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("=== FRC Telemetry System ===");
        System.out.println("Format and display robot data\n");
        
        // Add initial events
        robot.eventLog.add("System initialized");
        robot.eventLog.add("Connected to field");
        
        boolean running = true;
        
        while (running) {
            // Display menu
            System.out.println("\n--- Telemetry Options ---");
            System.out.println("1. Show Full Dashboard");
            System.out.println("2. Show Compact Status");
            System.out.println("3. Show Drive Train Data");
            System.out.println("4. Show Match Info");
            System.out.println("5. Show Event Log");
            System.out.println("6. Update Values");
            System.out.println("7. Export CSV Format");
            System.out.println("8. Show Graphs");
            System.out.println("0. Exit");
            System.out.print("Choose: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine();  // Clear buffer
            
            switch (choice) {
                case 1:
                    showFullDashboard();
                    break;
                case 2:
                    showCompactStatus();
                    break;
                case 3:
                    showDriveTrainData();
                    break;
                case 4:
                    showMatchInfo();
                    break;
                case 5:
                    showEventLog();
                    break;
                case 6:
                    updateValues(scanner);
                    break;
                case 7:
                    exportCSV();
                    break;
                case 8:
                    showGraphs();
                    break;
                case 0:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option!");
            }
        }
        
        System.out.println("Telemetry system closed.");
        scanner.close();
    }
    
    // Full dashboard display
    private static void showFullDashboard() {
        System.out.println("\n╔════════════════════════════════════════════════╗");
        System.out.println("║            FRC ROBOT DASHBOARD                 ║");
        System.out.println("╠════════════════════════════════════════════════╣");
        
        // Match info
        System.out.printf("║ Mode: %-12s Time: %s         ║%n",
                         robot.isAutonomous ? "AUTONOMOUS" : "TELEOP",
                         formatTime(robot.matchTime));
        
        // Battery and power
        System.out.printf("║ Battery: %s  Score: %3d           ║%n",
                         formatBattery(robot.batteryVoltage),
                         robot.allianceScore);
        
        System.out.println("╠════════════════════════════════════════════════╣");
        
        // Position
        System.out.printf("║ Position: (%2d, %2d)  Heading: %6.1f°         ║%n",
                         robot.robotX, robot.robotY, robot.robotHeading);
        
        // Current command
        System.out.printf("║ Command: %-38s║%n", robot.currentCommand);
        
        System.out.println("╠════════════════════════════════════════════════╣");
        System.out.println("║ MOTORS          Temp(°C)  Current(A)  Status  ║");
        
        // Motor data
        String[] motorNames = {"Front Left ", "Front Right", "Back Left  ", "Back Right "};
        for (int i = 0; i < 4; i++) {
            String status = getMotorStatus(robot.motorTemps[i], robot.motorCurrents[i]);
            System.out.printf("║ %s    %5.1f      %5.1f     %-8s║%n",
                             motorNames[i],
                             robot.motorTemps[i],
                             robot.motorCurrents[i],
                             status);
        }
        
        System.out.println("╚════════════════════════════════════════════════╝");
    }
    
    // Compact status line
    private static void showCompactStatus() {
        // Single line status for logging/quick view
        String status = String.format("[%s] %s | Bat:%.1fV | Pos:(%d,%d) | Hdg:%.0f° | %s",
                                     LocalTime.now().format(timeFormatter),
                                     robot.isAutonomous ? "AUTO" : "TELE",
                                     robot.batteryVoltage,
                                     robot.robotX, robot.robotY,
                                     robot.robotHeading,
                                     robot.currentCommand);
        
        System.out.println("\n" + status);
        
        // Quick health check
        String health = String.format("Motors: %.0f°C avg | %.0fA total | %s",
                                    averageTemp(),
                                    totalCurrent(),
                                    overallHealth());
        System.out.println(health);
    }
    
    // Drive train specific data
    private static void showDriveTrainData() {
        System.out.println("\n=== Drive Train Telemetry ===");
        
        // Calculate distance from encoder
        double wheelCircumference = Math.PI * robot.wheelDiameter * 2.54 / 100;  // meters
        double ticksPerRevolution = 2048;  // Example encoder resolution
        double distance = (robot.encoderTicks / ticksPerRevolution) * 
                         wheelCircumference / robot.gearRatio;
        
        System.out.printf("Gear Ratio:        %d:1%n", robot.gearRatio);
        System.out.printf("Wheel Diameter:    %.1f inches%n", robot.wheelDiameter);
        System.out.printf("Encoder Ticks:     %d%n", robot.encoderTicks);
        System.out.printf("Distance Traveled: %.2f meters%n", distance);
        
        System.out.println("\nMotor Details:");
        System.out.println("┌─────────────┬────────┬─────────┬────────┐");
        System.out.println("│ Motor       │ Temp°C │ Amps    │ Power% │");
        System.out.println("├─────────────┼────────┼─────────┼────────┤");
        
        String[] motors = {"Front Left", "Front Right", "Back Left", "Back Right"};
        for (int i = 0; i < 4; i++) {
            double powerPercent = (robot.motorCurrents[i] / 40.0) * 100;  // Assume 40A max
            System.out.printf("│ %-11s │ %6.1f │ %7.1f │ %6.0f │%n",
                             motors[i],
                             robot.motorTemps[i],
                             robot.motorCurrents[i],
                             powerPercent);
        }
        System.out.println("└─────────────┴────────┴─────────┴────────┘");
    }
    
    // Match information
    private static void showMatchInfo() {
        System.out.println("\n=== Match Information ===");
        
        int totalTime = 150;  // 2:30 match
        int elapsed = totalTime - (int)robot.matchTime;
        int minutes = elapsed / 60;
        int seconds = elapsed % 60;
        
        System.out.printf("Match Time Elapsed:  %d:%02d%n", minutes, seconds);
        System.out.printf("Match Time Remaining: %s%n", formatTime(robot.matchTime));
        System.out.printf("Current Period:       %s%n", 
                         robot.isAutonomous ? "Autonomous (15s)" : "Teleop (135s)");
        System.out.printf("Alliance Score:       %d points%n", robot.allianceScore);
        
        // Time warnings
        if (robot.matchTime <= 30 && robot.matchTime > 0) {
            System.out.println("⚠ ENDGAME - 30 seconds remaining!");
        } else if (robot.matchTime <= 5 && robot.matchTime > 0) {
            System.out.println("🚨 FINAL COUNTDOWN - 5 seconds!");
        }
        
        // Field position visual
        System.out.println("\nField Position:");
        showFieldMap();
    }
    
    // Event log display
    private static void showEventLog() {
        System.out.println("\n=== Event Log ===");
        
        if (robot.eventLog.isEmpty()) {
            System.out.println("No events recorded.");
            return;
        }
        
        // Show last 10 events
        int start = Math.max(0, robot.eventLog.size() - 10);
        for (int i = start; i < robot.eventLog.size(); i++) {
            System.out.printf("[%s] %s%n", 
                            LocalTime.now().minusSeconds(robot.eventLog.size() - i).format(timeFormatter),
                            robot.eventLog.get(i));
        }
        
        System.out.printf("\nTotal events: %d%n", robot.eventLog.size());
    }
    
    // Update telemetry values
    private static void updateValues(Scanner scanner) {
        System.out.println("\n--- Update Values ---");
        System.out.println("1. Battery Voltage");
        System.out.println("2. Robot Position");
        System.out.println("3. Add Event");
        System.out.println("4. Toggle Auto/Teleop");
        System.out.println("5. Update Score");
        System.out.print("Choose: ");
        
        int choice = scanner.nextInt();
        scanner.nextLine();
        
        switch (choice) {
            case 1:
                System.out.print("New battery voltage: ");
                robot.batteryVoltage = scanner.nextDouble();
                robot.eventLog.add("Battery voltage updated: " + robot.batteryVoltage + "V");
                break;
            case 2:
                System.out.print("New X position: ");
                robot.robotX = scanner.nextInt();
                System.out.print("New Y position: ");
                robot.robotY = scanner.nextInt();
                robot.eventLog.add(String.format("Position updated: (%d, %d)", 
                                                robot.robotX, robot.robotY));
                break;
            case 3:
                System.out.print("Event description: ");
                String event = scanner.nextLine();
                robot.eventLog.add(event);
                break;
            case 4:
                robot.isAutonomous = !robot.isAutonomous;
                robot.eventLog.add("Mode changed to " + 
                                 (robot.isAutonomous ? "Autonomous" : "Teleop"));
                break;
            case 5:
                System.out.print("New score: ");
                robot.allianceScore = scanner.nextInt();
                robot.eventLog.add("Score updated: " + robot.allianceScore);
                break;
        }
    }
    
    // Export data in CSV format
    private static void exportCSV() {
        System.out.println("\n=== CSV Export ===");
        System.out.println("timestamp,battery,x,y,heading,mode,score,avg_temp,total_current");
        
        // Generate sample data points
        for (int i = 0; i < 5; i++) {
            System.out.printf("%s,%.1f,%d,%d,%.1f,%s,%d,%.1f,%.1f%n",
                            LocalTime.now().plusSeconds(i).format(timeFormatter),
                            robot.batteryVoltage - (i * 0.1),
                            robot.robotX,
                            robot.robotY,
                            robot.robotHeading + (i * 5),
                            robot.isAutonomous ? "auto" : "teleop",
                            robot.allianceScore + (i * 10),
                            averageTemp(),
                            totalCurrent());
        }
    }
    
    // Show ASCII graphs
    private static void showGraphs() {
        System.out.println("\n=== Telemetry Graphs ===");
        
        // Battery voltage graph
        System.out.println("\nBattery Voltage:");
        drawBar("Current", robot.batteryVoltage, 13.0);
        drawBar("Warning", 11.5, 13.0);
        drawBar("Critical", 11.0, 13.0);
        
        // Motor temperatures
        System.out.println("\nMotor Temperatures (°C):");
        for (int i = 0; i < 4; i++) {
            drawBar("Motor " + (i+1), robot.motorTemps[i], 70.0);
        }
        
        // Current draw
        System.out.println("\nCurrent Draw (A):");
        double total = totalCurrent();
        drawBar("Total", total, 120.0);
    }
    
    // Helper methods
    
    private static String formatTime(double seconds) {
        int mins = (int)seconds / 60;
        int secs = (int)seconds % 60;
        return String.format("%d:%02d", mins, secs);
    }
    
    private static String formatBattery(double voltage) {
        String icon;
        if (voltage > 12.0) icon = "████";
        else if (voltage > 11.5) icon = "███░";
        else if (voltage > 11.0) icon = "██░░";
        else icon = "█░░░";
        
        return String.format("%s %.1fV", icon, voltage);
    }
    
    private static String getMotorStatus(double temp, double current) {
        if (temp > 60) return "HOT!";
        if (current > 30) return "HIGH";
        if (temp < 30 && current < 10) return "IDLE";
        return "OK";
    }
    
    private static double averageTemp() {
        double sum = 0;
        for (double temp : robot.motorTemps) {
            sum += temp;
        }
        return sum / robot.motorTemps.length;
    }
    
    private static double totalCurrent() {
        double sum = 0;
        for (double current : robot.motorCurrents) {
            sum += current;
        }
        return sum;
    }
    
    private static String overallHealth() {
        if (robot.batteryVoltage < 11.0) return "CRITICAL";
        if (averageTemp() > 55) return "OVERHEATING";
        if (totalCurrent() > 100) return "HIGH LOAD";
        return "HEALTHY";
    }
    
    private static void showFieldMap() {
        // Simple ASCII field representation
        char[][] field = new char[9][17];
        
        // Initialize field
        for (int y = 0; y < 9; y++) {
            for (int x = 0; x < 17; x++) {
                field[y][x] = '·';
            }
        }
        
        // Place robot
        if (robot.robotX >= 0 && robot.robotX < 17 && 
            robot.robotY >= 0 && robot.robotY < 9) {
            field[robot.robotY][robot.robotX] = 'R';
        }
        
        // Draw field
        System.out.println("  0 2 4 6 8 10121416");
        for (int y = 0; y < 9; y++) {
            System.out.print(y + " ");
            for (int x = 0; x < 17; x++) {
                System.out.print(field[y][x]);
            }
            System.out.println();
        }
        System.out.println("R = Robot Position");
    }
    
    private static void drawBar(String label, double value, double max) {
        System.out.printf("%-10s [", label);
        int bars = (int)((value / max) * 20);
        for (int i = 0; i < 20; i++) {
            if (i < bars) {
                System.out.print("█");
            } else {
                System.out.print("░");
            }
        }
        System.out.printf("] %.1f%n", value);
    }
}
