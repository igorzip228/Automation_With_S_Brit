package org.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.selenium.webDriver.DriverHolder;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class HoverTests extends BaseClass {

    WebDriver driver = DriverHolder.getInstance().getDriver();

    @BeforeClass
    public void beforeHoverTestsClass(){
        goToUrl("https://the-internet.herokuapp.com/hovers");
    }

    @Test
    public void hоverTest(){
        List<WebElement> elements = driver.findElements(By.cssSelector(".figure"));
        Actions actions = new Actions(driver);

        for (int i = 0; i < elements.size(); i++){
            actions.moveToElement(elements.get(i)).build().perform();
            String text = elements.get(i).findElement(By.cssSelector(".figcaption > h5")).getText();
            Assert.assertEquals(text, "name: user" + (i + 1));
        }
    }
}
