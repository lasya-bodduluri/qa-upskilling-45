package day15;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GoogleSearchStableTest {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.google.com");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        By searchBox = By.name("q");

        // Wait until the search box is visible
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchBox));

        // Search
        driver.findElement(searchBox).sendKeys("Playwright");
        driver.findElement(searchBox).sendKeys(Keys.ENTER);

        // Wait until the page title contains Playwright
        wait.until(ExpectedConditions.titleContains("Playwright"));

        String title = driver.getTitle();

        System.out.println("Page title: " + title);
        System.out.println("Test Passed: Title contains Playwright");

        driver.quit();
    }
}