package Day10;

public class DriverFactory {

    public static Object createDriver(String browser) {

        if (browser.equalsIgnoreCase("chrome")) {

            return "ChromeDriver created";

        } else if (browser.equalsIgnoreCase("firefox")) {

            return "FirefoxDriver created";

        } else if (browser.equalsIgnoreCase("edge")) {

            return "EdgeDriver created";

        } else {

            throw new IllegalArgumentException(
                    "Unsupported browser: " + browser
            );
        }
    }
}