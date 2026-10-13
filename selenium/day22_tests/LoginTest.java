package day22_tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import day22_pages.HomePage;
import day22_pages.LoginPage;

public class LoginTest {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
    }

    @Test
    public void testSuccessfulLogin() {
        // Initialize LoginPage
        LoginPage loginPage = new LoginPage(driver);

        // Perform login and transition to HomePage using fluent method
        HomePage homePage = loginPage.loginAs("standard_user", "secret_sauce");

        // Verify inventory page and title
        Assert.assertTrue(homePage.isInventoryPageDisplayed(), "Login failed or inventory page not displayed!");
        Assert.assertEquals(homePage.getPageTitle(), "Products", "Page title does not match!");
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}