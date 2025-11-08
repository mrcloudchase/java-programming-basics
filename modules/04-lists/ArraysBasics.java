public class ArraysBasics {
    public static void main(String[] args) {
        int[] scores = {90, 85, 88};          // create with values
        System.out.println(scores[0]);         // get index 0
        scores[1] = 87;                        // set index 1
        System.out.println("Length: " + scores.length);

        // simple loop over array
        int sum = 0;
        for (int i = 0; i < scores.length; i++) {
            sum += scores[i];
        }
        System.out.println("Sum: " + sum);
    }
}
