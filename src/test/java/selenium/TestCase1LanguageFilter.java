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
 * Test class to verify that the language filter on the practice test table
 * correctly updates the table content based on the selected language.
 */
public class TestCase1LanguageFilter {

    /**
     * Verifies that selecting a language filter updates the table content accordingly.
     */
    @Test
    public void verifyLanguageFilterUpdatesTableContent() {
        // Setup Safari driver using WebDriverManager
        WebDriverManager.safaridriver().setup();
        WebDriver driver = new SafariDriver();

        try {
            // Maximize browser window
            driver.manage().window().maximize();

            // Navigate to the homepage
            driver.get("https://practicetestautomation.com");

            // Explicit wait for elements
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            // Click on "Practice" link from the menu
            By practiceLinkLocator = By.cssSelector("nav.menu a[href='https://practicetestautomation.com/practice/']");
            WebElement practiceLink = wait.until(ExpectedConditions.elementToBeClickable(practiceLinkLocator));
            practiceLink.click();

            // Click on "Practice Test Table" link
            By testTableLocator = By.cssSelector("a[href='https://practicetestautomation.com/practice-test-table/']");
            WebElement practiceTestTableLink = wait.until(ExpectedConditions.elementToBeClickable(testTableLocator));
            practiceTestTableLink.click();

            // Language to filter
            String languageToFilter = "Java";

            // Select the checkbox for the desired language
            By languageFilterLocator = By.cssSelector("input[value='" + languageToFilter + "']");
            WebElement languageFilterCheckbox = wait.until(ExpectedConditions.elementToBeClickable(languageFilterLocator));
            languageFilterCheckbox.click();

            // Wait until at least one row with the selected language is visible
            By languageColumnLocator = By.cssSelector("tr:not([style]) td[data-col='language']");
            wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(languageColumnLocator));

            // Locate all visible table rows for the selected language
            List<WebElement> languageCells = driver.findElements(languageColumnLocator);

            System.out.println("Number of filtered rows: " + languageCells.size());

            // Verify that each row matches the selected language
            for (WebElement cell : languageCells) {
                String actualLanguage = cell.getText();
                if (actualLanguage.equals(languageToFilter)) {
                    System.out.println("Language matched: " + actualLanguage);
                } else {
                    System.out.println("Language did not match: " + actualLanguage);
                }
            }

        } catch (Exception e) {
            // Rethrow exception for test framework to handle
            throw e;
        } finally {
            // Quit the driver in all cases to close the browser
            driver.quit();
        }
    }
}