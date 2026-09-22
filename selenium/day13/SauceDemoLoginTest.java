package day13;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SauceDemoLoginTest {

    public static void main(String[] args){
    WebDriver driver = new ChromeDriver();
    driver.get("https://www.saucedemo.com/");
    driver.findElement(By.id("user-name")).sendKeys("standard_user");
    driver.findElement(By.name("password")).sendKeys("secret_sauce");
    driver.findElement(By.id("login-button")).click();

    String currentUrl= driver.getCurrentUrl();
    if (currentUrl.contains("inventory.html")) {
        System.out.println("Login successful");
    } else {
        throw new AssertionError("Login failed");
    }

    driver.quit();
}
}