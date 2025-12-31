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

public class BrowserStackSignUpTest {

    @Test
    public void shouldNavigateToSignUpPageWhenSignUpButtonIsClicked() {
        WebDriverManager.safaridriver().setup();
        WebDriver driver = new SafariDriver();

        try {
            driver.get("https://www.browserstack.com");

            WebDriverWait wait =
                    new WebDriverWait(driver, Duration.ofSeconds(10));

            WebElement signUpButton =
                    wait.until(ExpectedConditions.elementToBeClickable(
                            By.id("signupModalProductButton")));

            signUpButton.click();

            wait.until(ExpectedConditions.urlToBe(
                    "https://www.browserstack.com/users/sign_up"));

            Assert.assertEquals(
                    driver.getCurrentUrl(),
                    "https://www.browserstack.com/users/sign_up");
        } finally {
            driver.quit();
        }
    }
}
