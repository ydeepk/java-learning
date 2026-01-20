package utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class ScreenshotUtils {

    public static void captureScreenshot(WebDriver driver) throws IOException {

        // define the screenshot folder
        File screenshotDir = new File("screenshot");

        // create new if it does not exists
        if(!screenshotDir.exists()) screenshotDir.mkdirs();

        // capture screenshot and keep in sourcefile
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);

        // create string path and destination where to store the screenshots
        String destinationPath = "screenshot_"+System.currentTimeMillis()+".png";
        File destinationfile = new File(screenshotDir, destinationPath);

        // copy source to destination
        FileUtils.copyFile(sourceFile, destinationfile);

        System.out.println("Screenshot saved at "+destinationfile.getAbsolutePath());
    }
}
