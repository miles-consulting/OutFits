package com.outfittery.assignment.utils;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import java.util.HashMap;


public class ContextManager {

    public Logger LOGGER = LogManager.getLogger(this.getClass());

    private static ContextManager contextManager;
    private HashMap<Object, Object> contextMap = new HashMap<>();

    private ContextManager() {
    }

    public static ContextManager getInstance() {
        if (contextManager == null) {
            contextManager = new ContextManager();
        }
        return contextManager;
    }

    public void addToContext(KEYS keys, Object value) {
        addToContext(keys.name(), value);
    }

    private void addToContext(String keyName, Object value) {
        if (contextMap.containsKey(keyName))
            contextMap.remove(keyName);
        LOGGER.debug("Adding " + keyName + " to context with value = " + value);
        contextMap.put(keyName, value);
    }

    public WebDriver driver() {
        return (WebDriver) get(KEYS.DRIVER);
    }

    public Object get(KEYS keys) {
        return get(keys.name());
    }

    private Object get(String keyName) {
        return contextMap.get(keyName);
    }

}
