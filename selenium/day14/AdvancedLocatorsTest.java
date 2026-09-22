package day14;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AdvancedLocatorsTest {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();

        driver.get("https://demoqa.com/text-box");

        // 1. ID
        driver.findElement(By.id("userName"));

        // 2. CSS attribute
        driver.findElement(By.cssSelector(
                "input[placeholder='Full Name']"
        ));

        // 3. CSS direct child
        driver.findElement(By.cssSelector(
                "div + div > input#userName"
        ));

        // 4. XPath using parent
        driver.findElement(By.xpath(
                "//input[@id='userName']/parent::div"
        ));

        // 5. XPath using following sibling
        driver.findElement(By.xpath(
                "//label[@id='userName-label']/parent::div/following-sibling::div[1]"
        ));

        // 6. XPath contains
        driver.findElement(By.xpath(
                "//button[contains(@id, 'submit')]"
        ));

        // 7. XPath starts-with
        driver.findElement(By.xpath(
                "//button[starts-with(@id, 'submit')]"
        ));

        // 8. XPath text
        driver.findElement(By.xpath(
                "//label[text()='Full Name']"
        ));

        // 9. XPath normalize-space
        driver.findElement(By.xpath(
                "//label[normalize-space()='Full Name']"
        ));

        // 10. Email input
        driver.findElement(By.id("userEmail"));

        // 11. Current address
        driver.findElement(By.cssSelector(
                "textarea#currentAddress"
        ));

        // 12. Permanent address
        driver.findElement(By.cssSelector(
                "textarea#permanentAddress"
        ));

        // 13. Placeholder
        driver.findElement(By.cssSelector(
                "textarea[placeholder='Current Address']"
        ));

        // 14. Label
        driver.findElement(By.id("userName-label"));

        // 15. Submit button
        driver.findElement(By.id("submit"));

        System.out.println("All locator statements executed successfully.");

        driver.quit();
    }
}