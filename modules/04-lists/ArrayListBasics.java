import java.util.ArrayList;

public class ArrayListBasics {
    public static void main(String[] args) {
        ArrayList<String> tasks = new ArrayList<>();
        tasks.add("DriveForward");     // add
        tasks.add("TurnRight");
        System.out.println(tasks.get(0));      // read by index
        System.out.println("Size: " + tasks.size());

        tasks.set(1, "TurnLeft");      // update
        tasks.remove(0);               // remove first item
        System.out.println(tasks);     // prints the list
    }
}
