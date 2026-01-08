package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

/**
 * Page Object Model representing the Practice Test Table page.
 *
 * This class encapsulates:
 * - Navigation actions
 * - Filter interactions
 * - Table state validation
 * - Reset button behavior
 */
public class PracticeAutomationTestTablePage {

    /** WebDriver instance used to interact with the browser. */
    private final WebDriver driver;

    /** Explicit wait used for synchronizing element states. */
    private final WebDriverWait wait;

    /** Base URL of the Practice Test Automation site. */
    private static final String BASE_URL = "https://practicetestautomation.com";

    // Navigation link locators
    private final By practiceLinkLocator =
            By.cssSelector("a[href='https://practicetestautomation.com/practice/']");
    private final By testTableLinkLocator =
            By.cssSelector("a[href='https://practicetestautomation.com/practice-test-table/']");

    // Language filter locators
    private final By anyLanguageFilterLocator = By.cssSelector("input[value='Any']");
    private final By pythonLanguageFilterLocator = By.cssSelector("input[value='Python']");
    private final By javaLanguageFilterLocator = By.cssSelector("input[value='Java']");

    // Level checkbox locators
    private final By beginnerLevelCheckboxLocator = By.cssSelector("input[value='Beginner']");
    private final By intermediateLevelCheckboxLocator = By.cssSelector("input[value='Intermediate']");
    private final By advancedLevelCheckboxLocator = By.cssSelector("input[value='Advanced']");
    private final By checkedLevelCheckboxesLocator =
            By.cssSelector("input[name='level']:checked");

    // Minimum enrollment dropdown locators
    private final By minEnrollmentDropdownLocator = By.cssSelector("div.dropdown-button");
    private final By tenThousandOptionLocator =
            By.cssSelector("ul.dropdown-menu li[data-value='10000']");

    // Result and table locators
    private final By noMatchingResultLocator = By.cssSelector("div#noData");
    private final By visibleTableRowsLocator =
            By.cssSelector("tbody tr:not([style])");

    // Reset button locator
    private final By resetButtonLocator = By.cssSelector("button#resetFilters");

    /**
     * Constructs the page object and initializes wait handling.
     *
     * @param driver WebDriver instance controlling the browser
     */
    public PracticeAutomationTestTablePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    /**
     * Clicks an element after waiting until it becomes clickable.
     *
     * @param locator locator of the element to click
     */
    public void userClicks(By locator) {
        WebElement element =
                wait.until(ExpectedConditions.elementToBeClickable(locator));
        element.click();
    }

    /**
     * Waits until all elements located by the given locator are visible.
     *
     * @param locator locator of elements to wait for
     */
    public void waitForElementsVisibility(By locator) {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    }

    /**
     * Returns all elements matching the given locator.
     *
     * @param locator locator to search for elements
     * @return list of matching WebElements
     */
    public List<WebElement> collectAllColumnElements(By locator) {
        return driver.findElements(locator);
    }

    /**
     * Returns all currently visible table rows.
     *
     * @return list of visible table row elements
     */
    public List<WebElement> collectAllRowElements() {
        return driver.findElements(visibleTableRowsLocator);
    }

    /** @return locator for Practice link */
    public By getPracticeLinkLocator() {
        return practiceLinkLocator;
    }

    /** @return locator for Test Table link */
    public By getTestTableLinkLocator() {
        return testTableLinkLocator;
    }

    /** @return base URL of the site */
    public String getBaseURL() {
        return BASE_URL;
    }

    /** @return locator for Any language filter */
    public By getAnyLanguage() {
        return anyLanguageFilterLocator;
    }

    /** @return locator for Python language filter */
    public By getPythonLanguageFilterLocator() {
        return pythonLanguageFilterLocator;
    }

    /** @return locator for Java language filter */
    public By getJavaLanguageFilterLocator() {
        return javaLanguageFilterLocator;
    }

    /** @return locator for Beginner level checkbox */
    public By getBeginnerLevelCheckboxLocator() {
        return beginnerLevelCheckboxLocator;
    }

    /** @return locator for Intermediate level checkbox */
    public By getIntermediateLevelCheckboxLocator() {
        return intermediateLevelCheckboxLocator;
    }

    /** @return locator for minimum enrollment dropdown */
    public By getMinDropDownEnrollment() {
        return minEnrollmentDropdownLocator;
    }

    /** @return locator for 10,000+ enrollment option */
    public By getTenThousandOptionLocator() {
        return tenThousandOptionLocator;
    }

    /**
     * Determines whether the No matching courses message is visible.
     *
     * @return true if the message is displayed, false otherwise
     */
    public boolean isNoMatchingResultDisplayed() {
        List<WebElement> elements =
                driver.findElements(noMatchingResultLocator);
        return !elements.isEmpty() && elements.get(0).isDisplayed();
    }

    /**
     * Validates the text of the No matching courses message.
     *
     * @return true if the message text matches the expected value
     */
    public boolean verifyNoMatchingCourseText() {
        WebElement element =
                wait.until(ExpectedConditions.visibilityOfElementLocated(
                        noMatchingResultLocator));
        return "No matching courses."
                .equals(element.getText().trim());
    }

    /**
     * Checks whether the Reset Filters button is visible.
     *
     * @return true if Reset button is displayed, false otherwise
     */
    public boolean isResetButtonDisplayed() {
        List<WebElement> buttons = driver.findElements(resetButtonLocator);
        return !buttons.isEmpty() && buttons.get(0).isDisplayed();
    }

    /** @return locator for Reset Filters button */
    public By getResetButton() {
        return resetButtonLocator;
    }

    /**
     * Returns the currently selected language filter.
     *
     * @return selected language value
     */
    public String getSelectedLanguage() {
        if (driver.findElement(anyLanguageFilterLocator).isSelected()) {
            return "Any";
        }
        if (driver.findElement(javaLanguageFilterLocator).isSelected()) {
            return "Java";
        }
        if (driver.findElement(pythonLanguageFilterLocator).isSelected()) {
            return "Python";
        }
        return "";
    }

    /**
     * Determines whether all level checkboxes are selected.
     *
     * @return true if all levels are checked
     */
    public boolean getAllLevelsChecked() {
        return driver.findElements(checkedLevelCheckboxesLocator).size() == 3;
    }

    /**
     * Returns the selected minimum enrollment value.
     *
     * @return selected enrollment text
     */
    public String getSelectedMinEnrollment() {
        WebElement dropdown =
                wait.until(ExpectedConditions.visibilityOfElementLocated(
                        minEnrollmentDropdownLocator));
        return dropdown.getText().trim();
    }
}