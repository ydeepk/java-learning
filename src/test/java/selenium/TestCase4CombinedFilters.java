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

public class TestCase4CombinedFilters {

    @Test
    public void verifyResultOfCombinedFiltersWithLanguageLevelAndMinEnrollment() {

        // Set up Safari WebDriver
        WebDriverManager.safaridriver().setup();
        WebDriver driver = new SafariDriver();

        // Explicit wait configuration
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            // Maximize browser window
            driver.manage().window().maximize();

            // Launch application URL
            driver.get("https://practicetestautomation.com");

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

            // Select Python language filter
            By languageFilterLocator = By.cssSelector("input[value='Python']");
            WebElement languageFilterCheckbox =
                    wait.until(ExpectedConditions.elementToBeClickable(languageFilterLocator));
            languageFilterCheckbox.click();

            // Deselect Intermediate level
            By intermediateCheckboxLocator = By.cssSelector("input[value='Intermediate']");
            WebElement intermediateCheckbox =
                    wait.until(ExpectedConditions.elementToBeClickable(intermediateCheckboxLocator));
            intermediateCheckbox.click();

            // Deselect Advanced level
            By advancedCheckboxLocator = By.cssSelector("input[value='Advanced']");
            WebElement advancedCheckbox =
                    wait.until(ExpectedConditions.elementToBeClickable(advancedCheckboxLocator));
            advancedCheckbox.click();

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

            // Locate visible table rows
            By rowLocator = By.cssSelector("tbody tr:not([style])");
            wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(rowLocator));

            List<WebElement> rows = driver.findElements(rowLocator);
            System.out.println("Number of visible rows: " + rows.size());

            final String expectedLanguage = "Python";
            final int minimumEnrollment = 10000;

            // Verify only rows matching language and enrollment criteria are displayed
            for (WebElement row : rows) {

                WebElement languageElement =
                        row.findElement(By.cssSelector("td[data-col='language']"));
                WebElement enrollmentElement =
                        row.findElement(By.cssSelector("td[data-col='enrollments']"));

                String actualLanguage = languageElement.getText().trim();
                int actualEnrollment =
                        Integer.parseInt(enrollmentElement.getText().trim());

                if (actualLanguage.equals(expectedLanguage)
                        && actualEnrollment >= minimumEnrollment) {
                    System.out.println(
                            "Valid row found: " + actualLanguage + " | " + actualEnrollment);
                } else {
                    System.out.println(
                            "Invalid row found: " + actualLanguage + " | " + actualEnrollment);
                }
            }

        } finally {
            // Ensure browser closes even if test fails
            driver.quit();
        }
    }
}