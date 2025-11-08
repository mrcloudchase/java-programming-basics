public class VariablesExpressions {
    public static void main(String[] args) {
        int items = 5;                 // int: whole numbers
        double price = 3.50;           // double: decimals
        boolean inStock = true;        // boolean: true/false
        String name = "Notebook";      // String: text

        double subtotal = items * price;     // expression
        double taxRate = 0.08;
        double total = subtotal + (subtotal * taxRate);

        System.out.println("Item: " + name);
        System.out.println("In stock? " + inStock);
        System.out.println("Total: " + total);
    }
}
