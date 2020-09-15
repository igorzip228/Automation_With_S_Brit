package org.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.selenium.webDriver.DriverHolder;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class ActionsTests extends BaseClass {

    @Test
    public void dragAndDropTest() {
        goToUrl("http://www.pureexample.com/jquery-ui/basic-droppable.html");

        WebElement dragable = getElement(By.cssSelector("square ui_draggable"));
        WebElement dragToElemett = getElement(By.cssSelector("squaredotted ui-droppable"));

//        driver.switchTo().frame("ExampleFrame-94");
        DriverHolder.getInstance().getDriver().switchTo().frame("ExampleFrame-94"); // меняем на метод в синглтоне

//        WebDriverWait wait = new WebDriverWait(driver, 15);         // добавляем ожидание
//        wait.until(ExpectedConditions
//                .visibilityOfAllElementsLocatedBy(By.cssSelector("square ui_draggable"))); // ожидание по условии

//        Actions actions = new Actions(driver);                  // создаем класс Action
        Actions actions = new Actions(DriverHolder.getInstance().getDriver());                  // меняем на метод в синглтоне
//        actions.dragAndDrop(dragable, dragToElemett).perform(); // выполняем любой метод в Actions

        actions
                .moveToElement(dragable)                            // перемещаемся к элементу
                .pause(Duration.ofSeconds(3))                       // пауза после  действия
                .clickAndHold(dragable)                             // нажимаем и удерживаем элемент
                .moveToElement(dragToElemett, 20, 20)   // перемещаем элемент по координатам
                .release()                                          // отпускаем элемент
                .build()                                            // собираем
                .perform();                                         // и выполняем


        Assert.assertEquals(getElement(By.id("info")).getText(), "dropped!");

    }


    @Test
    public void sendKeysTest() {
        goToUrl("the internet...");
        WebElement email = getElement(By.id("email"));
//        Actions actions = new Actions(driver);
        Actions actions = new Actions(DriverHolder.getInstance().getDriver()); // меняем на метод в синглтоне
        actions
                .sendKeys(email, "Test text!!!")
                // делаем СTRL + A
                .keyDown(email, Keys.CONTROL) // нажимаем на кнопку
                .sendKeys("A")                // и посылаем к ней последовательность символов A
                .keyUp(email, Keys.CONTROL)   // отпускаем кнопку
                // делаем СTRL + C
                .keyDown(email, Keys.CONTROL)
                .sendKeys("C")
                .keyUp(email, Keys.CONTROL)
                // делаем BACK_SPACE
                .sendKeys(Keys.BACK_SPACE)
                // делаем СTRL + V
                .keyDown(email, Keys.CONTROL)
                .sendKeys("V")
                .keyUp(email, Keys.CONTROL)
                .build()
                .perform();

    }
}
