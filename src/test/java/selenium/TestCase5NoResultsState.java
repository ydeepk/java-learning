package selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.Test;
import static org.testng.Assert.assertTrue;

/**
 * Test case for verifying the "No Results" state on the Practice Test Table page.
 * The test verifies that when specific filters are applied, the page displays the "No matching courses." message.
 */
public class TestCase5NoResultsState {

    /**
     * Verifies that when specific filters are applied (Any language, Beginner level,
     * Intermediate level deselected, and minimum enrollment set to 10,000+),
     * the page displays the "No matching courses." message.
     */
    @Test
    public void verifyNoResultCase() {
        // Set up WebDriver for Safari
        WebDriverManager.safaridriver().setup();
        WebDriver driver = new SafariDriver();

        // Initialize Page Object for PracticeAutomationTestTablePage
        PracticeAutomationTestTablePage page = new PracticeAutomationTestTablePage(driver);

        try {
            // Maximize browser window for better visibility during test execution
            driver.manage().window().maximize();

            // Navigate to the base URL
            driver.get(page.getBaseURL());

            // Navigate through the practice links to the test table page
            page.clickElement(page.getPracticeLinkLocator());
            page.clickElement(page.getTestTableLinkLocator());

            // Apply filter for language as 'Any' and level as 'Beginner'
            page.clickElement(page.getAnyLanguage());
            page.clickElement(page.getBeginnerLevelCheckboxLocator());

            // Deselect Intermediate level filter to check for no results case
            page.clickElement(page.getIntermediateLevelCheckboxLocator());

            // Apply filter for minimum enrollment to 10,000+
            page.clickElement(page.getMinDropDownEnrollment());
            page.clickElement(page.getTenThousandOptionLocator());

            // Verify that "No matching courses" message is displayed
            assertTrue(page.verifyNoMatchingCourseText(), "No matching courses message should be displayed.");

        } catch (Exception e) {
            // Log error message and stack trace if the test fails
            System.err.println("Test failed: " + e.getMessage());
            e.printStackTrace();
            throw e; // Re-throw the exception to mark the test as failed
        } finally {
            // Ensure the browser is closed after the test completes
            driver.quit();
        }
    }
}