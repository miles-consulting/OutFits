package com.outfittery.assignment.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;

import java.util.concurrent.TimeUnit;


public class DriverFactory {

    public Logger LOGGER = LogManager.getLogger(this.getClass());

    private ContextManager contextManager = ContextManager.getInstance();

    public WebDriver getDriver() throws Exception {

//        DesiredCapabilities capabilities;
        String browserType = contextManager.get(KEYS.BROWSER_TYPE).toString();
        LOGGER.debug("Initializing " + browserType);
        WebDriver webDriver;
        switch (browserType) {
            case BrowserType.FIREFOX:
                System.setProperty("webdriver.gecko.driver", contextManager.get(KEYS.GECKO_DRIVER_PATH).toString());
//                capabilities = DesiredCapabilities.firefox();
//                capabilities.setCapability(FirefoxDriver.MARIONETTE, true);
//                FirefoxProfile geoDisabled = new FirefoxProfile();
//                geoDisabled.setPreference("geo.enabled", false);
//                geoDisabled.setPreference("geo.provider.use_corelocation", false);
//                geoDisabled.setPreference("geo.prompt.testing", false);
//                geoDisabled.setPreference("geo.prompt.testing.allow", false);
//                capabilities.setCapability(FirefoxDriver.PROFILE, geoDisabled);
                webDriver = new FirefoxDriver();
                break;
            case BrowserType.CHROME:
                System.setProperty("webdriver.chrome.driver", contextManager.get(KEYS.CHROME_DRIVER_PATH).toString());
                webDriver = new ChromeDriver();
                break;
            default:
                throw new IllegalArgumentException("Invalid browser type set in class injection " + browserType);
        }

        initWebDriver(webDriver);
        return webDriver;
    }

    private void initWebDriver(WebDriver webDriver) {
        webDriver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        webDriver.manage().window().maximize();
    }

}
