package Day04;

public class ReverseString {

    public static String reverseString(String text) {

        String reversed = "";

        for (int i = text.length() - 1; i >= 0; i--) {
            reversed = reversed + text.charAt(i);
        }

        return reversed;
    }

    public static void main(String[] args) {

        String result = reverseString("Labu");

        System.out.println("Reversed: " + result);
    }
}
