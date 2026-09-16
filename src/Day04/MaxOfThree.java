package Day04;

public class MaxOfThree {

    public static int maxOfThree(int a, int b, int c) {

        int max = a;

        if (b > max) {
            max = b;
        }

        if (c > max) {
            max = c;
        }

        return max;
    }

    public static void main(String[] args) {

        int result = maxOfThree(10, 25, 15);

        System.out.println("Maximum: " + result);
    }
}