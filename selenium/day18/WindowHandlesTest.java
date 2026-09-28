package day18;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandlesTest {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();

        // ==========================================
        // 1. OPEN PARENT PAGE
        // ==========================================

        driver.get("https://the-internet.herokuapp.com/windows");

        String parentHandle = driver.getWindowHandle();

        System.out.println("Parent window saved");


        // ==========================================
        // 2. CLICK LINK THAT OPENS NEW WINDOW
        // ==========================================

        driver.findElement(By.linkText("Click Here")).click();


        // ==========================================
        // 3. GET ALL WINDOW HANDLES
        // ==========================================

        Set<String> allHandles = driver.getWindowHandles();


        // ==========================================
        // 4. FIND AND SWITCH TO CHILD
        // ==========================================

        for (String handle : allHandles) {

            if (!handle.equals(parentHandle)) {

                driver.switchTo().window(handle);

                String childText = driver.findElement(By.tagName("h3")).getText();

                if (childText.equals("New Window")) {

                    System.out.println("Child window verified");

                } else {

                    throw new AssertionError("Child window content mismatch");
                }

                // ==================================
                // 5. CLOSE CHILD
                // ==================================

                driver.close();

                System.out.println("Child window closed");
            }
        }


        // ==========================================
        // 6. RETURN TO PARENT
        // ==========================================

        driver.switchTo().window(parentHandle);

        // ==========================================
        // 7. VERIFY PARENT
        // ==========================================

        String parentHeading = driver.findElement(By.tagName("h3")).getText();

        if (parentHeading.equals("Opening a new window")) {

            System.out.println("Returned to parent successfully");

        } else {

            throw new AssertionError("Not on parent window");
        }

        // ==========================================
        // 8. CLOSE BROWSER
        // ==========================================

        driver.quit();
    }
}