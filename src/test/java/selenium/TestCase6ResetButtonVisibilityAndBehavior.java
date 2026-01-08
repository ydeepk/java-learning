package selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Test case to verify the visibility and behavior of the Reset Filters button
 * on the Practice Test Table page.
 *
 * The test validates that:
 * - The Reset button is hidden by default
 * - The Reset button becomes visible after changing any filter
 * - Clicking Reset restores default filter values
 * - The Reset button is hidden again after reset
 */
public class TestCase6ResetButtonVisibilityAndBehavior {

    /**
     * Verifies Reset button visibility and reset behavior after modifying filters.
     */
    @Test
    public void verifyResetButtonVisibilityAndBehavior() {

        // Set up Safari WebDriver
        WebDriverManager.safaridriver().setup();
        WebDriver driver = new SafariDriver();

        // Initialize page object
        PracticeAutomationTestTablePage page =
                new PracticeAutomationTestTablePage(driver);

        try {
            // Maximize browser window
            driver.manage().window().maximize();

            // Navigate to application base URL
            driver.get(page.getBaseURL());

            /*
             * Test Steps:
             * 1. Navigate to Practice Test Table page
             * 2. Verify Reset button is hidden by default
             * 3. Change any filter
             * 4. Verify Reset button becomes visible
             * 5. Click Reset
             * 6. Verify all filters reset to default values
             * 7. Verify Reset button is hidden again
             */

            // Navigate to Practice Test Table page
            page.userClicks(page.getPracticeLinkLocator());
            page.userClicks(page.getTestTableLinkLocator());

            // Verify Reset button is hidden before any filter change
            Assert.assertFalse(
                    page.isResetButtonDisplayed(),
                    "Reset button should not be visible before changing any filter."
            );

            // Change language filter to Java
            page.userClicks(page.getJavaLanguageFilterLocator());

            // Verify Reset button becomes visible after filter change
            Assert.assertTrue(
                    page.isResetButtonDisplayed(),
                    "Reset button should be visible after changing language filter."
            );

            // Change level filter
            page.userClicks(page.getIntermediateLevelCheckboxLocator());

            // Verify Reset button remains visible after another filter change
            Assert.assertTrue(
                    page.isResetButtonDisplayed(),
                    "Reset button should remain visible after changing level filter."
            );

            // Click Reset button
            page.userClicks(page.getResetButton());

            // Verify filters are reset to default values
            Assert.assertEquals(
                    page.getSelectedLanguage(),
                    "Any",
                    "Language filter did not reset to 'Any'."
            );

            Assert.assertTrue(
                    page.getAllLevelsChecked(),
                    "Not all level checkboxes were reset to checked state."
            );

            Assert.assertEquals(
                    page.getSelectedMinEnrollment(),
                    "Any",
                    "Minimum enrollment filter did not reset to 'Any'."
            );

            // Verify Reset button is hidden after reset
            Assert.assertFalse(
                    page.isResetButtonDisplayed(),
                    "Reset button should be hidden after resetting filters."
            );

        } catch (Exception exception) {
            // Log failure details and rethrow exception
            System.err.println("Test failed: " + exception.getMessage());
            exception.printStackTrace();
            throw exception;
        } finally {
            // Ensure browser is closed after test execution
            driver.quit();
        }
    }
}