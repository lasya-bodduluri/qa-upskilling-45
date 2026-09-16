package Day09;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class CSVReader {

    private static final Logger logger =
            Logger.getLogger(CSVReader.class.getName());

    static {
        try {

            FileHandler fileHandler =
                    new FileHandler("logs/errors.log", true);

            fileHandler.setFormatter(new SimpleFormatter());

            logger.addHandler(fileHandler);

        } catch (IOException e) {

            System.out.println(
                    "Could not create log file: "
                            + e.getMessage()
            );
        }
    }

    public List<String[]> readCSV(String filePath) {

        List<String[]> rows = new ArrayList<>();

        try {

            BufferedReader reader =
                    new BufferedReader(
                            new FileReader(filePath)
                    );

            String line;

            while ((line = reader.readLine()) != null) {

                String[] columns = line.split(",");

                if (columns.length != 3) {

                    throw new MalformedCsvException(
                            "Malformed CSV: expected 3 columns but found "
                                    + columns.length
                                    + " in row: "
                                    + line
                    );
                }

                rows.add(columns);
            }

            reader.close();

        } catch (MalformedCsvException e) {

            logger.severe(
                    "Malformed CSV: "
                            + e.getMessage()
            );

            throw new RuntimeException(e);

        } catch (IOException e) {

            logger.severe(
                    "Failed to read CSV: "
                            + filePath
                            + " - "
                            + e.getMessage()
            );

            throw new RuntimeException(e);
        }

        return rows;
    }
}