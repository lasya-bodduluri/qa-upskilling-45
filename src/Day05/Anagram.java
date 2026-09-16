package Day05;

public class Anagram {
    public static boolean isAnagram(String first, String second) {

        if (first.length() != second.length()) {
            return false;
        }

        first = first.toLowerCase();
        second = second.toLowerCase();

        for (int i = 0; i < first.length(); i++) {

            char ch = first.charAt(i);

            int firstCount = 0;
            int secondCount = 0;

            for (int j = 0; j < first.length(); j++) {

                if (first.charAt(j) == ch) {
                    firstCount++;
                }

                if (second.charAt(j) == ch) {
                    secondCount++;
                }
            }

            if (firstCount != secondCount) {
                return false;
            }
        }

        return true;
    }
}
