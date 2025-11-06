/**
 * Shape.java
 * Abstract base class demonstrating inheritance
 * Cannot be instantiated directly - must be extended
 */
public abstract class Shape {
    // Protected = accessible by subclasses
    protected String name;
    protected String color;
    
    // Constructor
    public Shape(String name, String color) {
        this.name = name;
        this.color = color;
    }
    
    // Abstract method - must be implemented by subclasses
    public abstract double area();
    
    // Abstract method for perimeter
    public abstract double perimeter();
    
    // Concrete method - inherited by all subclasses
    public void displayInfo() {
        System.out.println("Shape: " + name);
        System.out.println("Color: " + color);
        System.out.printf("Area: %.2f%n", area());
        System.out.printf("Perimeter: %.2f%n", perimeter());
    }
    
    // Getters and setters
    public String getName() {
        return name;
    }
    
    public String getColor() {
        return color;
    }
    
    public void setColor(String color) {
        this.color = color;
    }
}
