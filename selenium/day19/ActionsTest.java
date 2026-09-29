package day19;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;

public class ActionsTest {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();

        Actions actions = new Actions(driver);

        // --------------------------------
        // Exercise 1: Hover
        // --------------------------------

        driver.get("https://the-internet.herokuapp.com/hovers");

        WebElement firstImage = driver.findElements(By.cssSelector(".figure")).get(0);

        actions.moveToElement(firstImage).perform();

        WebElement profileLink = firstImage.findElement(By.linkText("View profile"));

        if (profileLink.isDisplayed()) {
            System.out.println("Hover successful - profile link displayed");
        } else {
            throw new AssertionError("Hover failed");
        }

        // --------------------------------
        // Exercise 2: JavaScript scrolling
        // --------------------------------

        JavascriptExecutor js =  (JavascriptExecutor) driver;

        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");

        System.out.println("JavaScript scroll executed");

        js.executeScript("window.scrollTo(0, 0);");

        System.out.println("Returned to top");

        // --------------------------------
        // Exercise 3: Drag and Drop
        // --------------------------------

        driver.get("https://jqueryui.com/droppable/");

        /*
         * The jQuery UI demo is inside an iframe.
         * Switch into that iframe first.
         */

        driver.switchTo().frame(driver.findElement(By.cssSelector(".demo-frame")));

        WebElement draggable = driver.findElement(By.id("draggable"));

        WebElement droppable = driver.findElement(By.id("droppable"));

        actions.dragAndDrop(draggable, droppable).perform();

        String dropText = droppable.findElement(By.tagName("p")).getText();

        if (dropText.equals("Dropped!")) {
            System.out.println("Drag and drop successful");

        } else {
            throw new AssertionError("Drag and drop failed");
        }

        driver.switchTo().defaultContent();

        System.out.println("Returned to main page");

        driver.quit();
    }
}