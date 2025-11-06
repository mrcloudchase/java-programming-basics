/**
 * Circle.java
 * Concrete class extending Shape
 * Demonstrates inheritance and method implementation
 */
public class Circle extends Shape {
    private double radius;
    
    // Constructor
    public Circle(double radius, String color) {
        super("Circle", color);  // Call parent constructor
        this.radius = radius;
    }
    
    // Implement abstract method from Shape
    @Override
    public double area() {
        return Math.PI * radius * radius;
    }
    
    // Implement abstract method from Shape
    @Override
    public double perimeter() {
        return 2 * Math.PI * radius;
    }
    
    // Circle-specific method
    public double getDiameter() {
        return 2 * radius;
    }
    
    // Getter and setter
    public double getRadius() {
        return radius;
    }
    
    public void setRadius(double radius) {
        if (radius > 0) {
            this.radius = radius;
        }
    }
    
    // Override displayInfo to add circle-specific info
    @Override
    public void displayInfo() {
        super.displayInfo();  // Call parent method
        System.out.printf("Radius: %.2f%n", radius);
        System.out.printf("Diameter: %.2f%n", getDiameter());
    }
}
