package utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class ScreenshotOfElement {

    ScreenshotOfElement() {} // prevent from instantiate

    public static void captureScreenshotOfElement(WebElement element) throws IOException {

        if(element == null) return;

        File screenshotFolder = new File("elementScreenshots");
        if(!screenshotFolder.exists()) screenshotFolder.mkdirs();

        File fileSrc = element.getScreenshotAs(OutputType.FILE);

        String timeStamp = new SimpleDateFormat("yyyy.MM.dd_HH.mm.ss").format(new Date());
        String destFilePath = element.getText()+"_"+timeStamp+".png";
        File destFile = new File(screenshotFolder, destFilePath);

        // Save to location
        FileUtils.copyFile(fileSrc, destFile);
        System.out.println(destFile.getAbsolutePath());

    }

}
