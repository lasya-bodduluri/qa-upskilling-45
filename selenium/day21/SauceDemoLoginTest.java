package day21;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import day22_pages.HomePage;
import day22_pages.LoginPage;

public class SauceDemoLoginTest {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
    }

    @Test(groups = "smoke")
    public void loginTest() {

        LoginPage loginPage = new LoginPage(driver);

        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");

        HomePage homePage = loginPage.clickLogin();

        Assert.assertTrue(homePage.isInventoryPageDisplayed(), "Login should open the inventory page");

        Assert.assertEquals(homePage.getPageTitle(), "Products", "The page title should be Products");
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
