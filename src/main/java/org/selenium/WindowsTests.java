package org.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.selenium.webDriver.DriverHolder;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class WindowsTests extends BaseClass {

    // ДЗ работа с фреймами и iFrame

    WebDriver driver = DriverHolder.getInstance().getDriver();

    @BeforeClass
    public void beforeWindowTests(){
        goToUrl(Constants.WINDOWS_PAGE);
    }

    @Test
    public void windowTest(){
        getElement(By.linkText("ClickHere")).click();                       // linkText - нажимаем на текст, к которому приклеена ссылка

//        Object[] handles = driver.getWindowHandles().toArray();             // берем хендлы
//        driver.switchTo().window(handles[handles.length - 1].toString());   // переключаемся на дочернее окно по последнему элементу в handles
//      ^ выносим в отдельную функцию switchToLastWidow()
        switshToLastWindow();

        Assert.assertEquals(getElement(By.tagName("h3")).getText(), "New Window");

//        driver.close();                                     // закрываем текущее окно
//       ^ выносим в общий клас closeCurrentWindow()
        closeCurrentWindow();

//        driver.switchTo().window(handles[0].toString());    // переключаемся назад на основное окно
//        driver.switchTo().defaultContent();                 // defaultContent переключает на самый первый родительский контент
                                                            // или на главный документ. Вдруг что-то не так, на всяк случай
//      ^выносим в switchToDefaultWindow
        switchToDefaultWindow();

        Assert.assertEquals(getHeaderText(), "Opening a new window"); // проверяем что перешли на родительский контент

//        Assert. assertEquals(driver.getWindowHandles().size(), 1);     // проверяем что у нас осталось тольк оодно окно
//       ^ выносим в returnNumsOfOpenedWindows
        Assert. assertEquals(returnNumsOfOpenedWindows(), 1);
    }

    public void  switshToLastWindow(){
        Object[] handles = driver.getWindowHandles().toArray();
        driver.switchTo().window(handles[handles.length - 1].toString());
    }

    public void switchToDefaultWindow(){
        Object[] handles = driver.getWindowHandles().toArray();
        driver.switchTo().window(handles[0].toString());
        driver.switchTo().defaultContent();
    }

    public int returnNumsOfOpenedWindows(){
        return driver.getWindowHandles().size();
    }
}
