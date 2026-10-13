package day22_pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    WebDriver driver;

    @FindBy(css = ".title")
    private WebElement pageTitle;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // 1. Add this method for isInventoryPageDisplayed()
    public boolean isInventoryPageDisplayed() {
        return pageTitle.isDisplayed();
    }

    // 2. Add this method for getPageTitle()
    public String getPageTitle() {
        return pageTitle.getText();
    }
}