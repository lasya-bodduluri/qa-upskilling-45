package day17;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertsAndFramesTest {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();

        // ==========================================
        // 1. JAVASCRIPT ALERT
        // ==========================================

        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();

        Alert alert = driver.switchTo().alert();

        String alertText = alert.getText();

        if (alertText.equals("I am a JS Alert")) {
            System.out.println("JS Alert message verified");
        } else {
            throw new AssertionError("JS Alert message mismatch");
        }

        alert.accept();

        // ==========================================
        // 2. JAVASCRIPT CONFIRM
        // ==========================================

        driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();

        alert = driver.switchTo().alert();

        String confirmText = alert.getText();

        if (confirmText.equals("I am a JS Confirm")) {
            System.out.println("JS Confirm message verified");
        } else {
            throw new AssertionError(   "JS Confirm message mismatch");
        }

        alert.dismiss();

        // ==========================================
        // 3. JAVASCRIPT PROMPT
        // ==========================================

        driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();

        alert = driver.switchTo().alert();

        String promptText = alert.getText();

        if (promptText.equals("I am a JS prompt")) {
            System.out.println("JS Prompt message verified");
        } else {
            throw new AssertionError("JS Prompt message mismatch");
        }

        alert.sendKeys("Lasya");

        alert.accept();

        System.out.println("JS Prompt handled successfully");

        // ==========================================
        // 4. NESTED FRAMES
        // ==========================================

        driver.get("https://the-internet.herokuapp.com/nested_frames");

        WebElement topFrame = driver.findElement(By.name("frame-top"));

        driver.switchTo().frame(topFrame);

        WebElement leftFrame = driver.findElement(By.name("frame-left"));

        driver.switchTo().frame(leftFrame);

        String frameText = driver.findElement(By.tagName("body")).getText();

        if (frameText.equals("LEFT")) {
            System.out.println("Nested frame text verified");
        } else {
            throw new AssertionError("Nested frame text mismatch");
        }

        // Return to main page
        driver.switchTo().defaultContent();

        System.out.println("Returned to main page successfully");

        driver.quit();
    }
}