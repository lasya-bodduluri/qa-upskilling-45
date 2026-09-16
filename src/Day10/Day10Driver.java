package Day10;

public class Day10Driver {

    public static void main(String[] args) {

        ConfigReader config1 =
                ConfigReader.getInstance();

        ConfigReader config2 =
                ConfigReader.getInstance();

        System.out.println(
                "Browser: " + config1.getBrowser()
        );

        System.out.println(
                "Environment: " + config1.getEnvironment()
        );

        System.out.println(
                "Same object? " + (config1 == config2)
        );

        Object driver =
                DriverFactory.createDriver("edge");

        System.out.println(driver);
    }
}