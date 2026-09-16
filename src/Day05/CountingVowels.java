package Day05;

import static Day05.StringUtils.reverseString;

public class CountingVowels {
    public static int countVowels(String text) {

        int count = 0;

        for (int i = 0; i < text.length(); i++) {

            char ch = text.charAt(i);

            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {

        String result = reverseString("Labu");
        System.out.println("Reversed: " + result);

        int vowels = countVowels("Automation");
        System.out.println("Vowels: " + vowels);
    }
}
