package streamsAPI;

import org.openqa.selenium.WebElement;

import java.util.List;

public class CombineAllFunctionsExercise {

    /*
    * You have List<WebElement> buttons.
        Filter for buttons that are isDisplayed().
        Map to get their getText().
        Filter for text that startsWith("Login").
        Find the first one.
        If not found, return a String: "No Login Button".
        Can you put those 5 steps into one chain?
* */


    public static void main(String[] args) {

        /*
        * List<WebElement> buttons = driver.findElements(By.className("price-tag"));
        *
        * String buttonStatus = buttons.stream()
        *                       .filter(button -> button.isDisplayed())
        *                       .map(button -> button.getText())
        *                       .filter(button -> button.startsWith("Login"))
        *                       .firstElement(button)
        *                       .orElse("No Login button");
        * */

    }

}
