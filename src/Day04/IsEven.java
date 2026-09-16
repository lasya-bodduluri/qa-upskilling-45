package Day04;

public class IsEven {

    public static boolean isEven(int number) {
        return number % 2 == 0;
    }

    public static void main(String[] args) {

        boolean result = isEven(8);

        System.out.println("Is even: " + result);
    }
}