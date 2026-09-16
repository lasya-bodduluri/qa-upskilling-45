package Day09;

import java.util.List;

public class Driver {

    public static void main(String[] args) {

        CSVReader reader = new CSVReader();

        List<String[]> rows = reader.readCSV("users.csv");

        System.out.println("Total rows: " + rows.size());

        for (String[] row : rows) {
            System.out.println(String.join(" | ", row));
        }
    }
}
