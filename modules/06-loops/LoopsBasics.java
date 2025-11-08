public class LoopsBasics {
    public static void main(String[] args) {
        // for = do something N times
        for (int i = 0; i < 3; i++) {
            System.out.println("Beep");
        }

        // while = repeat while condition is true
        int countdown = 3;
        while (countdown > 0) {
            System.out.println(countdown);
            countdown--;
        }
        System.out.println("Go!");

        // for-each = visit each item in array
        String[] steps = {"Drive", "Intake", "Score"};
        for (String step : steps) {
            System.out.println("Do: " + step);
        }
    }
}
