package selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class NykaaTest {

    /*
     * Application URL: https://www.nykaa.com/
     */

    @Test
    public void verifyTrimmerPrice() {

        // Setup Safari driver
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        // Explicit wait for handling dynamic elements
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Maximize browser window
        driver.manage().window().maximize();

        // Launch Nykaa application
        driver.get("https://www.nykaa.com/");

        SoftAssert softAssert = new SoftAssert();

        // Locator for search input field
        By searchInputLocator =
                By.xpath("//input[@name='search-suggestions-nykaa']");
        WebElement searchInputElement =
                wait.until(ExpectedConditions.elementToBeClickable(searchInputLocator));

        // Perform search operation for trimmer
        searchInputElement.click();
        searchInputElement.clear();
        searchInputElement.sendKeys("trimmer");

        // Locator for Men-related search suggestion
        By searchSuggestionLocator =
                By.xpath("//div[contains(@class,'suggestionQuery') and contains(@data-value,'Men')]");
        WebElement searchSuggestionElement =
                wait.until(ExpectedConditions.elementToBeClickable(searchSuggestionLocator));

        // Click suggestion to trigger search results
        searchSuggestionElement.click();

        // Locator for result page header
        By resultHeadingLabelLocator =
                By.xpath("//h1[contains(text(),'Men')]");
        WebElement resultHeadingLabelElement =
                wait.until(ExpectedConditions.visibilityOfElementLocated(resultHeadingLabelLocator));

        // Validate correct result page is loaded
        softAssert.assertEquals(
                resultHeadingLabelElement.getText(),
                "Trimmers for Men",
                "Actual Text does not match with expected");

        // a bit hack to hide the floating button causing, ElementClickInterceptedException while attempt to click add to cart button.
        WebElement helpWidget =
                driver.findElement(By.xpath("//div[contains(@class,'css')]//div[contains(.,'How may we help you')]/parent::div"));

        ((JavascriptExecutor)driver).executeScript("arguments[0].style.display='none';", helpWidget);



        // Locator to collect all product names from results
        By productNameLocator =
                By.xpath("//div[contains(@class,'productWrapper')]/div[1]/div/a/div[2]/div[1]");
        List<WebElement> productElements =
                wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(productNameLocator));

        // Total number of products displayed
        int totalProducts = productElements.size();

        // List to store names of products added to cart
        List<String> itemsAddedToCart = new ArrayList<>();

        int maxItemsInCart = 5;
        int currentCartCount = 0;

        // Random generator to select products
        Random random = new Random();
        int randomIndex;
        String productName;

        // Randomly add 5 products to the cart
        while (currentCartCount < maxItemsInCart) {
            randomIndex = random.nextInt(totalProducts);
            productName = productElements.get(randomIndex).getText();
            itemsAddedToCart.add(addItemToCart(driver, wait, productName, softAssert));
            currentCartCount++;
        }

        System.out.println("Items added to cart: " + itemsAddedToCart);

        // Locator for cart button
        By cartButtonLocator =
                By.xpath("//span[contains(@class,'cart')]/parent::button");
        WebElement cartButtonElement =
                wait.until(ExpectedConditions.elementToBeClickable(cartButtonLocator));

        // Open cart overlay
        cartButtonElement.click();

        // Locator for cart overlay header
        By cartOverlayHeaderLocator =
                By.xpath("//span[@data-test-id='header-title']");
        WebElement cartOverlayHeaderElement =
                wait.until(ExpectedConditions.visibilityOfElementLocated(cartOverlayHeaderLocator));

        // Validate cart overlay title
        softAssert.assertEquals(
                cartOverlayHeaderElement.getText(),
                "Bag",
                "Actual title does not match with expected header title.");

        // Locator to fetch product names from cart
        By cartItemNameLocator =
                By.xpath("//span[@data-test-id='product-name']");
        List<WebElement> cartItemElements =
                wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(cartItemNameLocator));

        List<String> cartItems = new ArrayList<>();

        // Extract product names from cart
        for (WebElement item : cartItemElements) {
            cartItems.add(item.getText().substring(0,25));
        }

        System.out.println("Items present in cart: " + cartItems);

        // Validate cart size consistency
        if (cartItems.size() != itemsAddedToCart.size()) {
            System.out.println("Mismatch in cart item count, please investigate.");
        } else {

            // Sort both lists before comparison
            Collections.sort(itemsAddedToCart);
            Collections.sort(cartItems);

            // Validate cart contents
            softAssert.assertEquals(
                    itemsAddedToCart,
                    cartItems,
                    "Actual items in cart do not match expected items");
        }

        // Assert all soft assertions
        softAssert.assertAll();

        // Close browser
        driver.quit();
    }

    private String addItemToCart(WebDriver driver,
                                 WebDriverWait wait,
                                 String productName,
                                 SoftAssert softAssert) {

        System.out.println("Adding product: " + productName);

        // Dynamic XPath built for product card
        String productCardXPath =
                "//div[contains(text(),'"+productName+"')]/ancestor::div[contains(@class,'productWrapper')]/div[1]";

        // Locator for product card
        By productCardLocator = By.xpath(productCardXPath);
        WebElement productCardElement =
                wait.until(ExpectedConditions.visibilityOfElementLocated(productCardLocator));

        // Hover over product card to reveal actions
        Actions actions = new Actions(driver);
        actions.moveToElement(productCardElement).perform();

        // Locator for Add To Cart button
        By addToCartLocator =
                By.xpath("//div[@class='showBottomAction show']//button[@type='button']//span[contains(text(),'Add To')]");
        WebElement addToCartElement =
                wait.until(ExpectedConditions.elementToBeClickable(addToCartLocator));

        // Click Add To Cart button
        addToCartElement.click();

        // Locator to validate product added to bag
        By addedToBagLocator =
                By.xpath("//div[@class='showBottomAction show']//button[contains(text(),'Added to Bag')]");
        WebElement addedToBagElement =
                wait.until(ExpectedConditions.visibilityOfElementLocated(addedToBagLocator));

        // Validate item added confirmation
        softAssert.assertEquals(
                addedToBagElement.getText(),
                "Added to Bag",
                "Actual text for added to bag does not match expected");


        // Locator to validate product added to bag disappear
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@id='add-to-cart-prompt' and contains(.,'Product Added to Cart')]")));

        // Return product name added to cart
        return productName.substring(0,25);
    }
}