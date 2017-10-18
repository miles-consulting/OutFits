package com.outfittery.assignment.stepdefs;


import com.outfittery.assignment.utils.ContextManager;
import com.outfittery.assignment.utils.DriverFactory;
import com.outfittery.assignment.utils.KEYS;
import com.outfittery.assignment.utils.ScreenShotUtils;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Properties;


public class Hooks {
    private ContextManager contextManager = ContextManager.getInstance();
    private DriverFactory driverFactory;
    public Logger LOGGER = LogManager.getLogger(this.getClass());

    private void loadConfigPropertiesToContext() {
        try {
            LOGGER.debug("Loading automation properties");
            Properties properties = new Properties();
            properties.load(ClassLoader.getSystemResource("AutomationConfig.properties").openStream());
            contextManager.addToContext(KEYS.BROWSER_TYPE, System.getProperty("browser.type"));
            contextManager.addToContext(KEYS.GECKO_DRIVER_PATH, properties.getProperty("firefox.driver.path"));
            contextManager.addToContext(KEYS.CHROME_DRIVER_PATH, properties.getProperty("chrome.driver.path"));
            contextManager.addToContext(KEYS.APPLICATION_URL, properties.getProperty("application.url"));
            contextManager.addToContext(KEYS.OUTFITTERY_USER,properties.getProperty("outfittery.user"));
            contextManager.addToContext(KEYS.OUTFITTERY_PASSWORD,properties.getProperty("outfittery.password"));
        } catch (IOException e) {
            LOGGER.debug("Properties file is  missing");
            e.printStackTrace();
        }
    }

    private void launchBrowser() {
        loadConfigPropertiesToContext();
        driverFactory = new DriverFactory();
        try {
            contextManager.addToContext(KEYS.DRIVER, driverFactory.getDriver());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Before
    public void init(Scenario scenario) {
        loadConfigPropertiesToContext();
        String applicationUrl = String.valueOf(contextManager.get(KEYS.APPLICATION_URL));
        String scenarioStartMessage = "\n" +
                "\n--------------------------------------------------------------------------------------------\n" +
                "\tScenario: '" + scenario.getName() + "\n" +
                "\n--------------------------------------------------------------------------------------------\n" +
                "\n";
        LOGGER.debug(scenarioStartMessage);
        launchBrowser();
        LOGGER.debug("Launching application URL " + applicationUrl);
        contextManager.driver().get(applicationUrl);
    }

    @After
    public void tearDown(Scenario scenario) {
        String scenarioEndMessage = "\n" +
                "\n--------------------------------------------------------------------------------------------\n" +
                "\tExecuted scenario  " + scenario.getName() + "\n " +
                "\tStatus : " + scenario.getStatus() + "\n" +
                "\n--------------------------------------------------------------------------------------------\n" +
                "\n";
        LOGGER.debug(scenarioEndMessage);
        ScreenShotUtils.embedScreenShotInReport(scenario, scenario.getName());
        ((WebDriver) contextManager.get(KEYS.DRIVER)).quit();
    }
}
