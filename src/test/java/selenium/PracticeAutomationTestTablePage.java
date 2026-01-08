package selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

/**
 * Page Object Model for the Practice Test Table page.
 * Encapsulates interactions with the page, including filters, table rows, and messages.
 */
public class PracticeAutomationTestTablePage {

    /** WebDriver instance for interacting with the browser. */
    private WebDriver driver;

    /** WebDriverWait instance for waiting on elements. */
    private WebDriverWait wait;

    /** Base URL for the Practice Test Automation site. */
    private final String baseURL = "https://practicetestautomation.com";

    // Locators for navigation links
    private final By practiceLinkLocator = By.cssSelector("a[href='https://practicetestautomation.com/practice/']");
    private final By testTableLinkLocator = By.cssSelector("a[href='https://practicetestautomation.com/practice-test-table/']");

    // Locators for language filters
    private final By anyLanguageFilterLocator = By.cssSelector("input[value='Any']");
    private final By pythonLanguageFilterLocator = By.cssSelector("input[value='Python']");
    private final By javaLanguageFilterLocator = By.cssSelector("input[value='Java']");

    // Locators for level checkboxes
    private final By beginnerLevelCheckboxLocator = By.cssSelector("input[value='Beginner']");
    private final By intermediateLevelCheckboxLocator = By.cssSelector("input[value='Intermediate']");
    private final By advancedLevelCheckboxLocator = By.cssSelector("input[value='Advanced']");

    // Locators for minimum enrollment dropdown and options
    private final By minEnrollmentDropdownLocator = By.cssSelector("div.dropdown-button");
    private final By tenThousandOptionLocator = By.cssSelector("ul.dropdown-menu li[data-value='10000']");

    // Locator for "No matching courses" message
    private final By noMatchingResultLocator = By.cssSelector("div#noData");

    // Locator for visible rows in the courses table
    private final By rowLocator = By.cssSelector("tbody tr:not([style])");

    /**
     * Constructor to initialize WebDriver and WebDriverWait.
     *
     * @param driver the WebDriver instance to use for this page object.
     */
    public PracticeAutomationTestTablePage(WebDriver driver) {
        this.driver = driver;
        // Initialize WebDriverWait with a 10-second timeout
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    /**
     * Clicks an element after waiting for it to be clickable.
     *
     * @param locator the locator for the element to click
     */
    public void clickElement(By locator) {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
        element.click();
    }

    /**
     * Waits for all elements matching the given locator to be visible.
     *
     * @param locator the locator for the elements to wait for
     */
    public void waitForElementsVisibility(By locator) {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    }

    /**
     * Collects all elements matching the given locator.
     *
     * @param locator the locator for the column to collect elements from
     * @return a list of WebElements found by the locator
     */
    public List<WebElement> collectAllColumnElements(By locator) {
        return driver.findElements(locator);
    }

    /**
     * Collects all visible rows from the courses table.
     *
     * @return a list of WebElements representing the visible rows
     */
    public List<WebElement> collectAllRowElements() {
        return driver.findElements(rowLocator);
    }

    // -------------------------------
    // Getter methods for locators
    // -------------------------------

    /** @return locator for the "Practice" link */
    public By getPracticeLinkLocator() {
        return practiceLinkLocator;
    }

    /** @return locator for the "Test Table" link */
    public By getTestTableLinkLocator() {
        return testTableLinkLocator;
    }

    /** @return the base URL of the site */
    public String getBaseURL() {
        return baseURL;
    }

    /** @return locator for the "Any Language" filter */
    public By getAnyLanguage() {
        return anyLanguageFilterLocator;
    }

    /** @return locator for the "Python" language filter */
    public By getPythonLanguageFilterLocator() {
        return pythonLanguageFilterLocator;
    }

    /** @return locator for the "Java" language filter */
    public By getJavaLanguageFilterLocator() {
        return javaLanguageFilterLocator;
    }

    /** @return locator for the "Beginner" level checkbox */
    public By getBeginnerLevelCheckboxLocator() {
        return beginnerLevelCheckboxLocator;
    }

    /** @return locator for the "Intermediate" level checkbox */
    public By getIntermediateLevelCheckboxLocator() {
        return intermediateLevelCheckboxLocator;
    }

    /** @return locator for the minimum enrollments dropdown */
    public By getMinDropDownEnrollment() {
        return minEnrollmentDropdownLocator;
    }

    /** @return locator for the "10,000+" option in the minimum enrollments dropdown */
    public By getTenThousandOptionLocator() {
        return tenThousandOptionLocator;
    }

    /**
     * Checks if the "No matching courses" message is displayed on the page.
     *
     * @return true if the message is displayed, false otherwise
     */
    public boolean isNoMatchingResultDisplayed() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(noMatchingResultLocator));
        WebElement element = driver.findElement(noMatchingResultLocator);
        return element.isDisplayed();
    }

    /**
     * Verifies that the "No matching courses" text matches the expected message.
     *
     * @return true if the message matches "No matching courses.", false otherwise
     */
    public boolean verifyNoMatchingCourseText() {
        WebElement noMatchingElement = wait.until(ExpectedConditions.visibilityOfElementLocated(noMatchingResultLocator));
        String verifyText = noMatchingElement.getText().trim();
        return "No matching courses.".equals(verifyText);
    }
}