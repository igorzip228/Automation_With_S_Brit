package org.selenium.webDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Фабрика - это патерн проэктирования, при котором инициялезируется нужный обьект. В даном случае мы будем инициализировать
 * браузер, который нам нужен.
 * Factory (Фабрика) - используется, когда у нас есть суперкласс с несколькими подклассами и на основе ввода, нам нужно вернуть один из подкласса
 **/

public class WebDriverFactory {
    public static WebDriver initDriver(WebDriverEnum driverType) throws IllegalAccessException {
        WebDriver driver;
        switch (driverType) {
            case FIREFOX: {
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            }
            case CHROME: {
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
            }
            default:
                throw new IllegalAccessException("Unexpected value: " + driverType);

        }
        driver.manage().window().maximize();
        return driver;
    }
}
