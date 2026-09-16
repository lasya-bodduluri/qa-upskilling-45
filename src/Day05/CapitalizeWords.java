package Day05;

public class CapitalizeWords {

    public static String capitalizeWords(String text) {

        String[] words = text.split(" ");
        String result = "";

        for (String word : words) {

            String firstLetter = word.substring(0, 1).toUpperCase();
            String remainingLetters = word.substring(1);

            result = result + firstLetter + remainingLetters + " ";
        }

        return result.trim();
    }

    public static void main(String[] args){
        String result = capitalizeWords("hello labu bunny");

        System.out.println("Capitalized: " + result);
    }
}
