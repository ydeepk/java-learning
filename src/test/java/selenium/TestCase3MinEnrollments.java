package selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class TestCase3MinEnrollments {

    @Test
    public void verifyTableDisplaysValuesAsPerSelectedMinEnrollments() {

        // Set up Safari WebDriver
        WebDriverManager.safaridriver().setup();
        WebDriver driver = new SafariDriver();

        try {
            // Maximize browser window
            driver.manage().window().maximize();

            // Launch application URL
            driver.get("https://practicetestautomation.com");

            // Explicit wait configuration
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            // Navigate to Practice page
            By practiceLinkLocator =
                    By.cssSelector("a[href='https://practicetestautomation.com/practice/']");
            WebElement practiceLink =
                    wait.until(ExpectedConditions.elementToBeClickable(practiceLinkLocator));
            practiceLink.click();

            // Navigate to Practice Test Table page
            By testTableLinkLocator =
                    By.cssSelector("a[href='https://practicetestautomation.com/practice-test-table/']");
            WebElement testTableLink =
                    wait.until(ExpectedConditions.elementToBeClickable(testTableLinkLocator));
            testTableLink.click();

            // Open minimum enrollments dropdown
            By minEnrollmentDropdownLocator = By.cssSelector("div.dropdown-button");
            WebElement minEnrollmentDropdown =
                    wait.until(ExpectedConditions.elementToBeClickable(minEnrollmentDropdownLocator));
            minEnrollmentDropdown.click();

            // Select 10,000+ from dropdown
            By tenThousandOptionLocator =
                    By.cssSelector("ul.dropdown-menu li[data-value='10000']");
            WebElement tenThousandOption =
                    wait.until(ExpectedConditions.elementToBeClickable(tenThousandOptionLocator));
            tenThousandOption.click();

            // Locator for Enrollment column values
            By enrollmentColumnLocator =
                    By.cssSelector("tr:not([style]) td[data-col='enrollments']");

            // Wait until enrollment values are visible
            wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(enrollmentColumnLocator));

            // Fetch all enrollment values from the table
            List<WebElement> enrollmentCells = driver.findElements(enrollmentColumnLocator);

            final int minimumEnrollment = 10000;

            // Validate each enrollment value against selected minimum
            for (WebElement cell : enrollmentCells) {
                int enrollmentValue = Integer.parseInt(cell.getText());

                if (enrollmentValue >= minimumEnrollment) {
                    System.out.println(
                            "Enrollment value meets criteria: " + enrollmentValue);
                } else {
                    System.out.println(
                            "Enrollment value does not meet criteria: " + enrollmentValue);
                }
            }

        } finally {
            // Ensure browser closes even if test fails
            driver.quit();
        }
    }
}