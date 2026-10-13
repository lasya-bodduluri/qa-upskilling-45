
package day22_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class FormPage {

    private WebDriver driver;

    private By textInput = By.name("my-text");
    private By passwordInput = By.name("my-password");
    private By dropdown = By.name("my-select");
    private By checkbox = By.id("my-check-1");
    private By radioButton = By.id("my-radio-2");

    private By submitButton = By.cssSelector("button");

    public FormPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterText(String text) {
        driver.findElement(textInput).sendKeys(text);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordInput).sendKeys(password);
    }

    public void selectOption(String option) {
        Select select = new Select(driver.findElement(dropdown));
        select.selectByVisibleText(option);
    }

    public void selectCheckbox() {
        if (!driver.findElement(checkbox).isSelected()) {
            driver.findElement(checkbox).click();
        }
    }

    public void selectRadioButton() {
        if (!driver.findElement(radioButton).isSelected()) {
            driver.findElement(radioButton).click();
        }
    }

    public void submitForm() {
        driver.findElement(submitButton).click();
    }
}
