package org.selenium;

import org.openqa.selenium.*;
import org.selenium.webDriver.DriverHolder;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AlertsTests extends BaseClass {
    /*
    * ДЗ: Написать все остальные алерты и промпты
    * */

    WebDriver driver = DriverHolder.getInstance().getDriver();

    @BeforeClass
    public void beforeAlertsTestsClass() {
        goToUrl(Constants.ALERTS_PAGE);
    }

    @Test
    public void clickFoJSAlert() {
/*
        WebElement jsButton = driver.findElement(By.xpath("xpath"));
        jsButton.click();

        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        alert.accept(); // есть кнопки на алерте OK / CANCEL
        driver.switchTo().defaultContent(); // переключаемся назад

        String result = driver.findElement(By.id("id")).getText();
        Assert.assertEquals(alertText, "I am JS alert");
        Assert.assertEquals(result, "You succesfully clicked");
*/

        clickAlertButtonAndOpenAlert();
        Assert.assertEquals(getTextFromAlertAndCloseIt(true), "I am a JS Confirm");
        checkResultText("You successfully clicked on alert");
    }

    @Test
    public void clickFoJSConfirm() {
/*
        WebElement jsButton = driver.findElement(By.xpath("xpath"));
        jsButton.click();

        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        alert.accept(); // есть кнопки на алерте OK / CANCEL
        driver.switchTo().defaultContent(); // переключаемся назад

        String result = driver.findElement(By.id("id")).getText();
        Assert.assertEquals(alertText, "I am JS confirm");
        Assert.assertEquals(result, "You clicked ok ");
*/

        clickConfirmButtonAndOpenConfirm();
        Assert.assertEquals(getTextFromAlertAndCloseIt(true), "I am a JS Confirm");
        checkResultText("You clicked ok");
    }

    @Test
    public void clickFoJSConfirmDismiss() {
        clickConfirmButtonAndOpenConfirm();
        Assert.assertEquals(getTextFromAlertAndCloseIt(false), "I am a JS Confirm");
        checkResultText("You clicked: Cancel ");
    }

    @Test
    public void clickToPrompt(){
        clickPromptButtonAndOpenPrompt();
        Assert.assertEquals(getTextFromAlertAndCloseIt(false), "I am a JS Confirm");
        checkResultText("You clicked: Cancel ");
    }

    @Test
    public void clickFoJSAlertWithJS() {

        clickAlertButtonAndOpenAlertWithJS();
        Assert.assertEquals(getTextFromAlertAndCloseIt(true), "I am a JS Confirm");
        checkResultText("You successfully clicked on alert");
    }




    private String getTextFromAlertAndCloseIt(boolean accept) {
        Alert alert = driver.switchTo().alert(); // переходим в алерт
        String alertText = alert.getText();

        if (accept) alert.accept();
        else alert.dismiss();

        driver.switchTo().defaultContent();
        return alertText;
    }




    private void checkResultText(String expectedText) {
        String text = driver.findElement(By.id("result")).getText();
        Assert.assertEquals(text, expectedText);
    }

    public void clickAlertButtonAndOpenAlert() {
        clickButton("Click for JS Alert");
    }

    public void clickAlertButtonAndOpenAlertWithJS() {
        ((JavascriptExecutor)driver).executeAsyncScript("return jsAlert()");
    }

    public void clickConfirmButtonAndOpenConfirm() {
        clickButton("Click for JS Confirm");
    }

    public void clickPromptButtonAndOpenPrompt() {
        clickButton("Click for JS Prompt");
    }




    public void clickButton(String buttonText) {
        String buttonXpath = String.format("//button[text()= '%s']", buttonText);
        driver.findElement(By.xpath(buttonXpath)).click();
    }

    public void clickButtonWithJS(String buttonText) {
        String buttonXpath = String.format("//button[text()= '%s']", buttonText);
        WebElement element = driver.findElement(By.xpath(buttonXpath));
//        ((JavascriptExecutor)driver).executeAsyncScript("return arguments[0].click;", element); // срабатывает событие на click
        DriverHolder.getInstance().getJavascriptExecutor().executeAsyncScript("return arguments[0].click;", element); // срабатывает событие на click
    }
}
