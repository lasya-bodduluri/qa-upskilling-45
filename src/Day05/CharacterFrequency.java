package Day05;

import java.util.HashMap;
import java.util.Map;

public class CharacterFrequency {

    public static Map<Character, Integer> characterFrequency(String text) {

        Map<Character, Integer> frequency = new HashMap<>();

        for (int i = 0; i < text.length(); i++) {

            char ch = text.charAt(i);

            if (frequency.containsKey(ch)) {
                frequency.put(ch, frequency.get(ch) + 1);
            } else {
                frequency.put(ch, 1);
            }
        }

        return frequency;
    }

    public static void main(String[] args){
        Map<Character, Integer> result = characterFrequency("hello");

        System.out.println(result);
    }
}
