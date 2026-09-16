package Day05;

public class StringUtils {

    public static String reverseString(String name) {

        String reversed = "";

        for (int i = name.length() - 1; i >= 0; i--) {
            reversed = reversed + name.charAt(i);
        }

        return reversed;
    }

    public static void main(String[] args){
        String result = reverseString("Labu");

        System.out.println("Reversed: " + result);
    }
}
