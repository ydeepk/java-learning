package utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

/**
 * ScreenshotUtil provides utility methods for capturing screenshots
 * in multiple output formats using Selenium WebDriver.
 */
public final class MultiFormatChallenge {

    private static final String SCREENSHOT_DIR_NAME = "screenshots";
    private static final String TIMESTAMP_PATTERN = "yyyy.MM.dd_HH.mm.ss";

    private MultiFormatChallenge() {
        // Utility class; prevent instantiation
    }

    /**
     * Captures a screenshot using the specified output format.
     *
     * Supported formats:
     * - "file"   : Saves screenshot as a PNG file
     * - "base64" : Returns screenshot as a Base64 string
     *
     * @param driver the active WebDriver instance
     * @param outputFormat the screenshot output format
     * @return Base64 screenshot string if requested, otherwise null
     * @throws IOException if file operations fail
     * @throws IllegalArgumentException if an unsupported format is provided
     */
    public static String captureScreenshot(
            WebDriver driver, String outputFormat) throws IOException {

        File screenshotDirectory = new File(SCREENSHOT_DIR_NAME);
        prepareScreenshotDirectory(screenshotDirectory);

        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;

        switch (outputFormat.trim().toLowerCase()) {
            case "file":
                return captureAsFile(takesScreenshot, screenshotDirectory);

            case "base64":
                return takesScreenshot.getScreenshotAs(OutputType.BASE64);

            default:
                throw new IllegalArgumentException(
                        "Unsupported screenshot format: " + outputFormat);
        }
    }

    /**
     * Captures a screenshot as a PNG file.
     *
     * @param takesScreenshot the Selenium screenshot interface
     * @param screenshotDirectory destination directory
     * @return null (file-based screenshots do not return content)
     * @throws IOException if the file cannot be written
     */
    private static String captureAsFile(
            TakesScreenshot takesScreenshot,
            File screenshotDirectory) throws IOException {

        File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
        String timestamp =
                new SimpleDateFormat(TIMESTAMP_PATTERN).format(new Date());

        File destinationFile =
                new File(screenshotDirectory, "screenshot_" + timestamp + ".png");

        FileUtils.copyFile(sourceFile, destinationFile);
        return null;
    }

    /**
     * Ensures the screenshot directory exists and is clean.
     *
     * @param directory the screenshot directory
     * @throws IOException if cleanup fails
     */
    private static void prepareScreenshotDirectory(File directory)
            throws IOException {

        if (directory.exists()) {
            FileUtils.deleteDirectory(directory);
        }

        directory.mkdirs();
    }
}