package org.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.selenium.webDriver.DriverHolder;
import org.selenium.webDriver.WebDriverEnum;
import org.selenium.webDriver.WebDriverFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BaseClass {
//    proyected static WebDriver driver = null;


    @BeforeSuite(alwaysRun = true)
    public void beforeSuite() throws IllegalAccessException {

//        driver = WebDriverFactory.initDriver(WebDriverEnum.CHROME);
        // ^ меняем на методы в синглтоне
        DriverHolder.getInstance().initDriver(WebDriverEnum.CHROME);
    }

    @AfterSuite(alwaysRun = true)
    public void afterSuite() {
//        if (driver != null) {
//            driver.quit(); // есть close() - закрывает окно, а драйвер живой, а quit() - закрывает и окно и драйвер
//        }

        if (DriverHolder.getInstance().getDriver() != null) {
            DriverHolder.getInstance().getDriver().quit(); // есть close() - закрывает окно, а драйвер живой, а quit() - закрывает и окно и драйвер
    }
    }

    protected void goToUrl(String url){
        DriverHolder.getInstance().getDriver().get(url);
    }

    protected String getHeaderText(){
        return DriverHolder.getInstance().getDriver().findElement(By.cssSelector("#content h3")).getText();
    }

    protected WebElement getElement(By element){
        return DriverHolder.getInstance().getDriver().findElement(element);
    }

    protected void closeCurrentWindow(){
        DriverHolder.getInstance().getDriver().close();
    }

    protected void sleep (long secs) {
        try {
            Thread.sleep(secs * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
