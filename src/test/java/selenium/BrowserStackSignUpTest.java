package selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * This class demonstrates a simple Selenium test
 * that verifies navigation to BrowserStack's sign-up page.
 */
public class BrowserStackSignUpTest {

    /**
     * Test case:
     * 1. Open BrowserStack homepage
     * 2. Click on the Sign Up button
     * 3. Verify the user is navigated to the Sign Up page
     */
    @Test
    public void shouldNavigateToSignUpPageWhenSignUpButtonIsClicked() {

        // Step 1: Setup Safari WebDriver using WebDriverManager
        // This automatically handles driver binaries
        WebDriverManager.safaridriver().setup();

        // Step 2: Launch the Safari browser
        WebDriver driver = new SafariDriver();

        try {
            // Step 3: Navigate to the BrowserStack homepage
            driver.get("https://www.browserstack.com");

            // Step 4: Create an explicit wait with a maximum timeout of 10 seconds
            // Explicit wait is used to wait for specific conditions
            WebDriverWait wait =
                    new WebDriverWait(driver, Duration.ofSeconds(10));

            // Step 5: Wait until the Sign Up button is clickable
            // This handles cases where the element loads slowly
            WebElement signUpButton =
                    wait.until(ExpectedConditions.elementToBeClickable(
                            By.id("signupModalProductButton")));

            // Step 6: Click the Sign Up button
            signUpButton.click();

            // Step 7: Wait until the URL changes to the expected Sign Up page
            wait.until(ExpectedConditions.urlToBe(
                    "https://www.browserstack.com/users/sign_up"));

            // Step 8: Verify that the current URL is the Sign Up page
            Assert.assertEquals(
                    driver.getCurrentUrl(),
                    "https://www.browserstack.com/users/sign_up");
        } finally {
            // Step 9: Close the browser
            // This ensures the browser is closed even if the test fails
            driver.quit();
        }
    }
}