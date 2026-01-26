package threads;


import net.bytebuddy.implementation.bytecode.Throw;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

/*
* Exercise 1: The "Parallel Safe" BaseTest
The Scenario: Your manager wants to run tests in parallel on 3 different browsers. You must ensure that if Test A and Test B run at the same time, they don't interfere with each other.
Task:
1. Create a BaseTest class.
2. Use ThreadLocal<WebDriver> to store the driver.
3. Create a @BeforeMethod that accepts a String browser parameter (from TestNG XML).
4. Create a getDriver() method so your test classes can access the correct thread's driver.

* */
public class ParallelSafe {

    private static final ThreadLocal<WebDriver> driverThread = new ThreadLocal<>();

    @BeforeMethod
    public WebDriver getDriver() {
        return driverThread.get();
    }

    @Parameters("browser")
    @BeforeMethod
    public void setUp(String browser) {
     WebDriver driver;

     switch (browser.toLowerCase()) {
         case "chrome":
             driver = new ChromeDriver();
             break;
         case "firefox":
             driver = new SafariDriver();
             break;
         default:
             throw new RuntimeException("Invalid browser name provided");
     }

     driverThread.set(driver);
     getDriver().get("https://www.codeInsider.com");

    }

    @AfterMethod
    public void tearDown() {
        if(getDriver()!= null) {
            getDriver().quit();
            driverThread.remove();
        }
    }

}
