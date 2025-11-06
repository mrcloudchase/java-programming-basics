/**
 * Rectangle.java
 * Another concrete class extending Shape
 * Shows different implementation of abstract methods
 */
public class Rectangle extends Shape {
    private double width;
    private double height;
    
    // Constructor
    public Rectangle(double width, double height, String color) {
        super("Rectangle", color);  // Call parent constructor
        this.width = width;
        this.height = height;
    }
    
    // Implement abstract method from Shape
    @Override
    public double area() {
        return width * height;
    }
    
    // Implement abstract method from Shape
    @Override
    public double perimeter() {
        return 2 * (width + height);
    }
    
    // Rectangle-specific methods
    public boolean isSquare() {
        return width == height;
    }
    
    public double getDiagonal() {
        return Math.sqrt(width * width + height * height);
    }
    
    // Getters and setters
    public double getWidth() {
        return width;
    }
    
    public void setWidth(double width) {
        if (width > 0) {
            this.width = width;
        }
    }
    
    public double getHeight() {
        return height;
    }
    
    public void setHeight(double height) {
        if (height > 0) {
            this.height = height;
        }
    }
    
    // Override displayInfo to add rectangle-specific info
    @Override
    public void displayInfo() {
        super.displayInfo();  // Call parent method
        System.out.printf("Width: %.2f%n", width);
        System.out.printf("Height: %.2f%n", height);
        System.out.printf("Diagonal: %.2f%n", getDiagonal());
        System.out.println("Is Square: " + isSquare());
    }
}
