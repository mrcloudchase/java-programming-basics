public class StringManipulation {
    public static void main(String[] args) {
        String full = "Ada Lovelace";

        System.out.println(full.length());         // length()
        System.out.println(full.substring(0, 3));  // "Ada"
        System.out.println(full.substring(4));     // "Lovelace"
        System.out.println(full.equals("Ada Lovelace")); // true

        String msg = "Hello, " + full;            // + joins text
        System.out.println(msg);
    }
}
