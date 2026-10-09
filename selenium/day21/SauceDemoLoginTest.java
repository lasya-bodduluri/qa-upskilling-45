package day21;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SauceDemoLoginTest {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {

        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
    }

    @Test(groups = "smoke")
    public void loginTest() {

        driver.findElement(By.id("user-name")).sendKeys("standard_user");

        driver.findElement(By.name("password")).sendKeys("secret_sauce");

        driver.findElement(By.id("login-button")).click();

        Assert.assertTrue(driver.getCurrentUrl().contains("inventory.html"));

        Assert.assertTrue(driver.findElement(By.className("title")).isDisplayed());
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}