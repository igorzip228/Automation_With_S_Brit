package org.selenium.webDriver;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class DriverHolder {

    private WebDriver driver;

    private static DriverHolder instance = null;

    private DriverHolder() {                        // делаем приватный конструктор,чтоб никто больше не мог создать драйвер
    }

    public static DriverHolder getInstance() {
        if (instance == null)
            instance = new DriverHolder();

        return instance;
    }

    public void initDriver(WebDriverEnum webDriverEnum) throws IllegalAccessException {
        driver = WebDriverFactory.initDriver(webDriverEnum);
    }

    public WebDriver getDriver(){
        return driver;
    }

    public JavascriptExecutor getJavascriptExecutor(){
        return (JavascriptExecutor) driver;
    }
}


// многопоточный синглтон


/*public class DriverHolder {
    private Map<Long, WebDriver> drivers = new HashMap<>();
​
    private static DriverHolder instance = null;
​
    private DriverHolder() {
    }
​
    public static DriverHolder getInstance() {
        if (instance == null) {
            instance = new DriverHolder();
        }
        return instance;
    }
​
    public void initDriver(WebDriverEnum webDriverEnum) {
        Long threadId = Thread.currentThread().getId();
        if (!drivers.containsKey(threadId)) {
            drivers.put(threadId, WebDriverFactory.initDriver(webDriverEnum));
        }
    }
​
    public WebDriver getDriver() {
        Long threadId = Thread.currentThread().getId();
        return drivers.get(threadId);
    }
​
    public JavascriptExecutor getJavascriptExecutor() {
        return (JavascriptExecutor) getDriver();
    }
​
}*/

