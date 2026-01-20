package utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class CleanRoomChallenge {

    /*
    Exercise 1: The "Clean Room" Challenge (File Management)
    Scenario: Every time you run your test suite, the screenshots folder
    gets cluttered with old images from last week.

    Task: Write a method called prepareDirectory() that:
    Checks if the screenshots folder exists.

    If it exists, deletes all files inside it so you start with a fresh folder.

    If it doesn't exist, creates it.

    Hint: Look at FileUtils.cleanDirectory(File directory) or FileUtils.deleteDirectory(File directory).
    * */
    public static void prepareDirectory() throws IOException {

        File screenshotDir = new File("screenshot");

        if(screenshotDir.exists()) FileUtils.deleteDirectory(screenshotDir);

        screenshotDir.mkdirs();
    }
}
