package Day06;

public class TwoSum {

    public static void main(String[] args) {

        int[] numbers = {3, 5, 8, 12};
        int target = 13;
        for (int i = 0; i < numbers.length; i++) {

            for (int j = i + 1; j < numbers.length; j++) {

                // check two numbers
                if (numbers[i] + numbers[j] == target) {
                    System.out.println(numbers[i] + " + " + numbers[j] + " = " + target);
                }
            }
        }
    }
}