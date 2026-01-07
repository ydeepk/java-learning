package selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

/**
 * This test class selects a value from the "Sort By" dropdown
 * on the practice test table page.
 */
public class SelectFirstValueFromDropDown {

    /**
     * Opens the practice test site, navigates to the test table page,
     * and selects the "Language" column from the "Sort By" dropdown.
     */
    @Test
    public void selectFirstValue() {
        // Setup SafariDriver using WebDriverManager
        WebDriverManager.safaridriver().setup();
        WebDriver driver = new SafariDriver();

        try {
            // Maximize the browser window
            driver.manage().window().maximize();

            // Open the main practice test automation website
            driver.get("https://practicetestautomation.com/");

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            // Navigate to the Practice page
            By practiceLinkLocator = By.cssSelector("a[href='https://practicetestautomation.com/practice/']");
            wait.until(ExpectedConditions.elementToBeClickable(practiceLinkLocator)).click();

            // Navigate to the Practice Test Table page
            By testTableLinkLocator = By.cssSelector("a[href='https://practicetestautomation.com/practice-test-table/']");
            wait.until(ExpectedConditions.elementToBeClickable(testTableLinkLocator)).click();

            // Locate the "Sort By" dropdown and wait until it is clickable
            By sortByLocator = By.cssSelector("#sortBy");
            WebElement sortByElement = driver.findElement(sortByLocator);
            wait.until(ExpectedConditions.elementToBeClickable(sortByLocator)).click();

            // Wrap the dropdown in a Select object and select the "Language" column
            Select sortBy = new Select(sortByElement);
            sortBy.selectByValue("col_lang");

        } finally {
            // Quit the driver to close the browser
            driver.quit();
        }
    }
}
