package day20;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AdvancedInteractionsTest {

    public static void main(String[] args) throws IOException {

        WebDriver driver = new ChromeDriver();

        Path screenshotFolder = Paths.get("screenshots/selenium");

        Files.createDirectories(screenshotFolder);

        // ==========================================
        // 1. SHADOW DOM
        // ==========================================

        driver.get("https://the-internet.herokuapp.com/shadowdom");

        WebElement shadowHost = driver.findElement(By.cssSelector("my-paragraph"));

        SearchContext shadowRoot = shadowHost.getShadowRoot();

        WebElement shadowText = shadowRoot.findElement(By.cssSelector("p"));

        String text = shadowText.getText();

        System.out.println("Shadow DOM text: " + text);

        if (text.isEmpty()) {
            throw new AssertionError("Shadow DOM text was empty");
        }

        takeScreenshot(driver, "screenshots/selenium/01-shadow-dom.png");

        // ==========================================
        // 2. FILE UPLOAD
        // ==========================================

        driver.get("https://the-internet.herokuapp.com/upload");

        Path testFile = Paths.get("screenshots/selenium/day20-test-file.txt");

        Files.writeString(testFile, "Day 20 Selenium file upload test");

        WebElement fileInput = driver.findElement(By.cssSelector("input[type='file']"));

        fileInput.sendKeys(testFile.toAbsolutePath().toString());

        driver.findElement(By.id("file-submit")).click();

        String uploadedFile = driver.findElement(By.id("uploaded-files")).getText();

        System.out.println("Uploaded file: " + uploadedFile);

        if (!uploadedFile.contains("day20-test-file.txt")) {
            throw new AssertionError("File upload failed");
        }

        takeScreenshot(driver, "screenshots/selenium/02-file-upload.png");

        // ==========================================
        // 3. COOKIES
        // ==========================================

        driver.get("https://the-internet.herokuapp.com/");

        Cookie testCookie = new Cookie("day20Cookie", "Lasya");

        driver.manage().addCookie(testCookie);

        Cookie savedCookie = driver.manage().getCookieNamed("day20Cookie");

        if (savedCookie == null || !savedCookie.getValue().equals("Lasya")) {

            throw new AssertionError("Cookie verification failed");
        }

        System.out.println("Cookie created and verified successfully");

        takeScreenshot(driver, "screenshots/selenium/03-cookie.png");

        // ==========================================
        // FINISH
        // ==========================================

        driver.quit();

        System.out.println("Day 20 Selenium test completed successfully");
    }

    private static void takeScreenshot(WebDriver driver, String path) throws IOException {

        TakesScreenshot screenshot = (TakesScreenshot) driver;

        File source = screenshot.getScreenshotAs(OutputType.FILE);

        Files.copy(source.toPath(), Paths.get(path));

        System.out.println("Screenshot saved: " + path);
    }
}