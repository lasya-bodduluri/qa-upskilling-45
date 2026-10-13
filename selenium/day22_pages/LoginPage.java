package day22_pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    WebDriver driver;

    // 1. Declare locators using @FindBy
    @FindBy(id = "user-name")
    private WebElement usernameField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(id = "login-button")
    private WebElement loginButton;

    // 2. Constructor to initialize elements
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this); // Mandatory bridge!
    }

    // 3. Action methods
    public void enterUsername(String user) {
        usernameField.sendKeys(user);
    }

    public void enterPassword(String pass) {
        passwordField.sendKeys(pass);
    }

    public HomePage clickLogin() {
        loginButton.click();
        return new HomePage(driver); // Returns the HomePage object
    }

    // Fluent method option: returns the next page object
    public HomePage loginAs(String user, String pass) {
        usernameField.sendKeys(user);
        passwordField.sendKeys(pass);
        loginButton.click();
        return new HomePage(driver);
    }
}