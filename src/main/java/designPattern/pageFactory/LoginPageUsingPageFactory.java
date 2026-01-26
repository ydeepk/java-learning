package designPattern.pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class LoginPageUsingPageFactory {

    WebDriver driver;

    // username field
    @FindBy(id="username")
    WebElement userNameInput;

    // password field
    @FindBy(id="password")
    WebElement passwordInput;

    // login button
    @FindBy(xpath="//input[role='submit']")
    WebElement loginButton;

    // initialize webelements
    LoginPageUsingPageFactory(WebDriver driver) {
        this.driver = driver;

        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 15), this);
    }
}
