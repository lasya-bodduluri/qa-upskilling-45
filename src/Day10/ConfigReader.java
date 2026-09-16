package Day10;

public class ConfigReader {

    private static ConfigReader instance;

    private ConfigReader() {
    }

    public static ConfigReader getInstance() {

        if (instance == null) {
            instance = new ConfigReader();
        }

        return instance;
    }

    public String getBrowser() {
        return "Chrome";
    }

    public String getEnvironment() {
        return "QA";
    }
}