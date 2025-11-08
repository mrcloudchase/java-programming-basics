public class ConditionalsBasics {
    public static void main(String[] args) {
        int distance = 18;     // cm
        boolean enabled = true;
        int speed = 50;        // %

        // if / else with comparisons + combined conditions
        if ((distance < 20 && enabled) || speed == 0) {
            System.out.println("STOP");
        } else {
            System.out.println("GO");
        }

        // switch/case
        String mode = "AUTO";
        switch (mode) {
            case "AUTO":   System.out.println("Run autonomous"); break;
            case "TELEOP": System.out.println("Driver control"); break;
            default:       System.out.println("Disabled");
        }
    }
}
