package org.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.selenium.BaseClass;
import org.selenium.Constants;
import org.selenium.webDriver.DriverHolder;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Set;

public class CoociesTests extends BaseClass {
    WebDriver driver = DriverHolder.getInstance().getDriver();

    private String userName = "tomsmith";
    private String userPass = "superSecretPassword";

    @BeforeClass
    public void beforeCookiesTestsClass(){
        goToUrl(Constants.LOGIN_FORM);
    }


    @Test
    public void printCookies(){
        login(userName, userPass);
        Set<Cookie> cookies = driver.manage().getCookies();
        for (Cookie cookie : cookies){
            System.out.println(cookie.getName() + " - " + cookie.getValue());
        }
    }

    @Test
    public void addRemoveCookies(){
        login(userName, userPass);
        printAllCookies();

        Cookie cookie = new Cookie("MyCookie", "MyValue"); // создаем куку

        driver.manage().addCookie(cookie);  // добавояем мою куку
        printAllCookies();

        driver.manage().deleteCookieNamed(cookie.getName()); // удаляем куку по имени
        printAllCookies();
    }

    @Test
    public void removeCookiesAndLogout(){
        login(userName, userPass);
        driver.manage().deleteAllCookies();
        driver.navigate().refresh();

        Assert.assertTrue(getElement(By.id("username")).isDisplayed());
        Assert.assertTrue(getElement(By.id("password")).isDisplayed());
        WebElement element = getElement(By.cssSelector(".flash.error"));
        Assert.assertTrue(element.getText()
                .contains("You must login to view the secure area!"));
    }





    private void login(String userName, String password){
        getElement(By.id("username")).sendKeys(userName);
        getElement(By.id("password")).sendKeys(password);
        getElement(By.id("password")).submit();

    }

    public void printAllCookies(){
        Set<Cookie> cookies = driver.manage().getCookies();
        for (Cookie cookie : cookies){
            System.out.println(cookie.getName() + " - " + cookie.getValue());
        }
    }
}
