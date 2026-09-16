package Day06;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SortByValue {

    public static void main(String[] args) {

        Map<String, Integer> marks = new HashMap<>();

        marks.put("Labu", 80);
        marks.put("Bunny", 95);
        marks.put("Bobo", 70);
        List<Map.Entry<String, Integer>> entries = new ArrayList<>(marks.entrySet());
        entries.sort(Map.Entry.comparingByValue());
        for (Map.Entry<String, Integer> entry : entries) {
            System.out.println(entry.getKey() + " → " + entry.getValue());
        }
    }
}