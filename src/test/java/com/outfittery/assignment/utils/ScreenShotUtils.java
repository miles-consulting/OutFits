package com.outfittery.assignment.utils;

import cucumber.api.Scenario;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class ScreenShotUtils {
    public static Logger LOGGER = LogManager.getLogger(ScreenShotUtils.class);

    private static ContextManager contextManager = ContextManager.getInstance();

    private static int screenShotCounter;

    private ScreenShotUtils() {

        reset();
    }

    public static String saveScreenShotAs(String fileName, String comment) {
        return saveScreenShotAndPageSourceAs(fileName, comment, null);
    }

    public static String saveScreenShotAndPageSourceAs(String fileName, String comment, String pageSource) {
        WebDriver driver = contextManager.driver();
        String savedFileName = "";
        if (null != driver) {
            String counter = getScreenShotCounter();
            try {
                FileUtils.forceMkdir(new File("target/screenshots"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            savedFileName = "target/screenshots/" + counter + "-" + comment.replace(" ", "");
            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            screenshot.renameTo(new File(savedFileName + ".jpg"));
            LOGGER.debug("\n\t" + comment + "\n\t\tScreen shot saved in: " + savedFileName + ".jpg");
        }
        return savedFileName;
    }

    public static void embedScreenShotInReport(Scenario scenario, String scenarioName) {
        LOGGER.debug("Finished running scenario - '" + scenarioName + "', Embedding screenshot in report");
        WebDriver driver = contextManager.driver();
        if (null != driver) {
            final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.embed(screenshot, "image/png"); // ... and embed it in the report.
        }
    }

    private static String getScreenShotCounter() {
        return String.format("%03d", ++screenShotCounter);
    }

    static void reset() {
        LOGGER.debug("Setting ScreenShot Counter to 0");
        screenShotCounter = 0;
    }
}
