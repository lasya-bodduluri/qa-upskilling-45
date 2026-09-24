package day16;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class FormAutomationTest {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.selenium.dev/selenium/web/web-form.html");

        // -----------------------------
        // 1. TEXT INPUT
        // -----------------------------

        WebElement textInput = driver.findElement(By.name("my-text"));

        System.out.println(
                "Text input displayed: " + textInput.isDisplayed()
        );

        System.out.println(
                "Text input enabled: " + textInput.isEnabled()
        );

        textInput.sendKeys("Lasya");

        String enteredText = textInput.getAttribute("value");

        if (enteredText.equals("Lasya")) {
            System.out.println("Text entered successfully");
        }

        // clear()
        textInput.clear();

        textInput.sendKeys("QA Automation");

        System.out.println(
                "Text after clear and re-entry: "
                        + textInput.getAttribute("value")
        );


        // -----------------------------
        // 2. GET ATTRIBUTE
        // -----------------------------

        String placeholder = textInput.getAttribute("placeholder");

        System.out.println(
                "Placeholder: " + placeholder
        );


        // -----------------------------
        // 3. DROPDOWN
        // -----------------------------

        WebElement dropdownElement =
                driver.findElement(By.name("my-select"));

        Select dropdown = new Select(dropdownElement);

        dropdown.selectByVisibleText("Two");

        String selectedOption =
                dropdown.getFirstSelectedOption().getText();

        if (selectedOption.equals("Two")) {
            System.out.println("Dropdown selected successfully");
        }


        // -----------------------------
        // 4. CHECKBOX
        // -----------------------------

        WebElement checkbox =
                driver.findElement(By.id("my-check-1"));

        System.out.println(
                "Checkbox initially selected: "
                        + checkbox.isSelected()
        );

        if (!checkbox.isSelected()) {
            checkbox.click();
        }

        if (checkbox.isSelected()) {
            System.out.println("Checkbox selected successfully");
        }


        // -----------------------------
        // 5. RADIO BUTTON
        // -----------------------------

        WebElement radio =
                driver.findElement(By.id("my-radio-2"));

        radio.click();

        if (radio.isSelected()) {
            System.out.println("Radio button selected successfully");
        }


        // -----------------------------
        // 6. SUBMIT BUTTON
        // -----------------------------

        WebElement submitButton =
                driver.findElement(By.cssSelector("button"));

        System.out.println(
                "Submit button displayed: "
                        + submitButton.isDisplayed()
        );

        System.out.println(
                "Submit button enabled: "
                        + submitButton.isEnabled()
        );

        String buttonText = submitButton.getText();

        System.out.println(
                "Button text: " + buttonText
        );


        // -----------------------------
        // 7. SUBMIT
        // -----------------------------

        submitButton.click();


        // -----------------------------
        // 8. VERIFY RESULT
        // -----------------------------

        String currentUrl = driver.getCurrentUrl();

        if (currentUrl.contains("submitted-form")) {
            System.out.println("Form submitted successfully");
        } else {
            throw new AssertionError(
                    "Form submission failed"
            );
        }

        driver.quit();
    }
}