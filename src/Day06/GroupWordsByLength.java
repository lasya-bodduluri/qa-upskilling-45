package Day06;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class GroupWordsByLength {

    public static void main(String[] args) {

        String[] words = {"cat", "dog", "apple", "bat", "banana"};

        Map<Integer, ArrayList<String>> groups = new HashMap<>();

        for (String word : words) {
        int length = word.length();
            if (groups.containsKey(length)) {
                groups.get(length).add(word);
            }
            else {
                ArrayList<String> wordList = new ArrayList<>();
                wordList.add(word);
                groups.put(length, wordList);
            }
        }
        System.out.println(groups);
    }
}