/**
 * Main.java
 * Demonstrates polymorphism with Shape hierarchy
 * Shows dynamic dispatch and inheritance in action
 */
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("=== Inheritance & Polymorphism Demo ===\n");
        
        // Create specific shape objects
        Circle circle1 = new Circle(5.0, "Red");
        Rectangle rect1 = new Rectangle(4.0, 6.0, "Blue");
        Rectangle square1 = new Rectangle(5.0, 5.0, "Green");
        Circle circle2 = new Circle(3.0, "Yellow");
        
        // Individual shape operations
        System.out.println("--- Individual Shapes ---");
        circle1.displayInfo();
        System.out.println();
        
        rect1.displayInfo();
        System.out.println();
        
        // Polymorphism: Shape reference to Circle/Rectangle objects
        System.out.println("--- Polymorphism in Action ---");
        
        // Array of Shape references (parent type)
        Shape[] shapes = {
            circle1,
            rect1,
            square1,
            circle2,
            new Circle(7.0, "Purple"),
            new Rectangle(10.0, 3.0, "Orange")
        };
        
        // Process all shapes polymorphically
        System.out.println("Processing all shapes:");
        for (int i = 0; i < shapes.length; i++) {
            System.out.printf("%d. %s (%s): Area = %.2f%n", 
                            i + 1,
                            shapes[i].getName(), 
                            shapes[i].getColor(),
                            shapes[i].area());  // Dynamic dispatch!
        }
        
        // Find largest shape
        System.out.println("\n--- Finding Largest Shape ---");
        Shape largestShape = shapes[0];
        for (Shape shape : shapes) {
            if (shape.area() > largestShape.area()) {
                largestShape = shape;
            }
        }
        System.out.println("Largest shape:");
        largestShape.displayInfo();
        
        // ArrayList of shapes
        ArrayList<Shape> shapeList = new ArrayList<>();
        shapeList.add(new Circle(4.5, "Pink"));
        shapeList.add(new Rectangle(8.0, 2.0, "Brown"));
        
        // Interactive shape creation
        System.out.println("\n--- Create Your Shapes ---");
        boolean creating = true;
        
        while (creating) {
            System.out.println("\n1. Create Circle");
            System.out.println("2. Create Rectangle");
            System.out.println("3. Display all shapes");
            System.out.println("4. Calculate total area");
            System.out.println("0. Exit");
            System.out.print("Choose option: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine();  // Clear buffer
            
            switch (choice) {
                case 1:  // Create Circle
                    System.out.print("Enter radius: ");
                    double radius = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.print("Enter color: ");
                    String circleColor = scanner.nextLine();
                    
                    Circle newCircle = new Circle(radius, circleColor);
                    shapeList.add(newCircle);  // Add as Shape
                    System.out.println("Circle created!");
                    break;
                    
                case 2:  // Create Rectangle
                    System.out.print("Enter width: ");
                    double width = scanner.nextDouble();
                    System.out.print("Enter height: ");
                    double height = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.print("Enter color: ");
                    String rectColor = scanner.nextLine();
                    
                    Rectangle newRect = new Rectangle(width, height, rectColor);
                    shapeList.add(newRect);  // Add as Shape
                    
                    if (newRect.isSquare()) {
                        System.out.println("Square created!");
                    } else {
                        System.out.println("Rectangle created!");
                    }
                    break;
                    
                case 3:  // Display all
                    System.out.println("\n--- All Shapes in List ---");
                    for (int i = 0; i < shapeList.size(); i++) {
                        System.out.println("\nShape " + (i + 1) + ":");
                        shapeList.get(i).displayInfo();
                    }
                    break;
                    
                case 4:  // Total area
                    double totalArea = 0;
                    double totalPerimeter = 0;
                    int circleCount = 0;
                    int rectangleCount = 0;
                    
                    for (Shape shape : shapeList) {
                        totalArea += shape.area();
                        totalPerimeter += shape.perimeter();
                        
                        // instanceof checks the actual type
                        if (shape instanceof Circle) {
                            circleCount++;
                        } else if (shape instanceof Rectangle) {
                            rectangleCount++;
                        }
                    }
                    
                    System.out.println("\n--- Statistics ---");
                    System.out.printf("Total shapes: %d%n", shapeList.size());
                    System.out.printf("  Circles: %d%n", circleCount);
                    System.out.printf("  Rectangles: %d%n", rectangleCount);
                    System.out.printf("Total area: %.2f%n", totalArea);
                    System.out.printf("Total perimeter: %.2f%n", totalPerimeter);
                    
                    if (!shapeList.isEmpty()) {
                        System.out.printf("Average area: %.2f%n", 
                                        totalArea / shapeList.size());
                    }
                    break;
                    
                case 0:  // Exit
                    creating = false;
                    break;
                    
                default:
                    System.out.println("Invalid option!");
            }
        }
        
        // Type checking and casting
        System.out.println("\n--- Type Checking & Casting ---");
        for (Shape shape : shapeList) {
            System.out.print(shape.getColor() + " " + shape.getName());
            
            // Check type and access specific methods
            if (shape instanceof Circle) {
                Circle c = (Circle) shape;  // Cast to Circle
                System.out.printf(" - Diameter: %.2f%n", c.getDiameter());
            } else if (shape instanceof Rectangle) {
                Rectangle r = (Rectangle) shape;  // Cast to Rectangle
                System.out.printf(" - Diagonal: %.2f%n", r.getDiagonal());
            }
        }
        
        // Key concepts summary
        System.out.println("\n=== Key Concepts ===");
        System.out.println("1. INHERITANCE:");
        System.out.println("   - Circle and Rectangle extend Shape");
        System.out.println("   - They inherit methods and fields");
        System.out.println("   - Use 'extends' keyword");
        
        System.out.println("\n2. ABSTRACT CLASS:");
        System.out.println("   - Shape is abstract (cannot instantiate)");
        System.out.println("   - Contains abstract methods (no body)");
        System.out.println("   - Subclasses must implement abstract methods");
        
        System.out.println("\n3. POLYMORPHISM:");
        System.out.println("   - Shape reference can hold Circle/Rectangle");
        System.out.println("   - Correct method called at runtime");
        System.out.println("   - Same interface, different implementations");
        
        System.out.println("\n4. DYNAMIC DISPATCH:");
        System.out.println("   - shape.area() calls correct version");
        System.out.println("   - Determined by actual object type");
        System.out.println("   - Not by reference type");
        
        System.out.println("\n5. instanceof & CASTING:");
        System.out.println("   - instanceof checks actual type");
        System.out.println("   - Casting allows access to subclass methods");
        System.out.println("   - Be careful - wrong cast causes error!");
        
        scanner.close();
    }
}
