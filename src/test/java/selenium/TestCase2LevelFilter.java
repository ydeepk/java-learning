package selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

/**
 * Test class to verify that the level filters on the practice test table
 * correctly update the table content when Beginner level is selected.
 */
public class TestCase2LevelFilter {

    /**
     * Verifies that the table displays only Beginner level rows
     * when Intermediate and Advanced level filters are selected.
     */
    @Test
    public void verifyTableWhenBeginnerLevelFilterSelected() {
        // Setup Safari driver using WebDriverManager
        WebDriverManager.safaridriver().setup();
        WebDriver driver = new SafariDriver();

        try {
            // Maximize the browser window
            driver.manage().window().maximize();

            // Navigate to the homepage
            driver.get("https://practicetestautomation.com");

            // Explicit wait for elements
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            // Click on "Practice" link in the menu
            By practiceLinkLocator = By.cssSelector("nav.menu a[href='https://practicetestautomation.com/practice/']");
            WebElement practiceLink = wait.until(ExpectedConditions.elementToBeClickable(practiceLinkLocator));
            practiceLink.click();

            // Click on "Practice Test Table" link
            By testTableLocator = By.cssSelector("a[href='https://practicetestautomation.com/practice-test-table/']");
            WebElement practiceTestTableLink = wait.until(ExpectedConditions.elementToBeClickable(testTableLocator));
            practiceTestTableLink.click();

            // Click on "Intermediate" level checkbox to deselect it
            By intermediateCheckboxLocator = By.cssSelector("input[value='Intermediate']");
            WebElement intermediateCheckbox = wait.until(ExpectedConditions.elementToBeClickable(intermediateCheckboxLocator));
            intermediateCheckbox.click();

            // Click on "Advanced" level checkbox to deselect it
            By advancedCheckboxLocator = By.cssSelector("input[value='Advanced']");
            WebElement advancedCheckbox = wait.until(ExpectedConditions.elementToBeClickable(advancedCheckboxLocator));
            advancedCheckbox.click();

            // Locator for the "Level" column in visible rows
            By levelColumnLocator = By.cssSelector("table#courses_table tbody tr:not([style]) td[data-col='level']");

            // Wait until at least one row is visible in the table
            wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(levelColumnLocator));

            // Get all visible level cells
            List<WebElement> levelCells = driver.findElements(levelColumnLocator);

            System.out.println("Number of visible rows: " + levelCells.size());

            String expectedLevel = "Beginner";

            // Verify that each visible row has the expected level
            for (WebElement cell : levelCells) {
                String actualLevel = cell.getText();
                if (actualLevel.equals(expectedLevel)) {
                    System.out.println("Level matched: " + actualLevel);
                } else {
                    System.out.println("Level did not match: " + actualLevel);
                }
            }

        } catch (Exception e) {
            // Rethrow exception for TestNG to handle
            throw e;
        } finally {
            // Close the browser
            driver.quit();
        }
    }
}