package day12;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class GoogleSearchTest{

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com");
        driver.findElement(By.name("q")).sendKeys("Playwright");
        driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
        Thread.sleep(3000);
        String title = driver.getTitle();
        if (title.contains("Playwright")) {
            System.out.println("Test Passed: Title contains Playwright");
        } else {
            throw new AssertionError("Test Failed: Title does not contain Playwright");
        }
        driver.quit();
    }
}