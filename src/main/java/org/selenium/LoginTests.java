package org.selenium;

import org.selenium.pageobjects.login.AfterLoginPage;
import org.selenium.pageobjects.login.LoginPage;
import org.selenium.webDriver.DriverHolder;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginTests extends BaseClass {

    private String userName = "tomsmith";
    private String userPass = "superSecretPassword";

    @BeforeTest
    public void beforeLoginTestClass(){
        goToUrl(Constants.LOGIN_FORM);
    }

    @Test
    public void loginLogouttest(){
        AfterLoginPage afterLoginPage = new LoginPage()
                .seccessLogin(userName, userPass)
                .waitTillPageLoaded();

        Assert.assertEquals(afterLoginPage.getHeaderText(), "Secure Area");
        LoginPage logourPage =
                afterLoginPage
                        .logout();
        Assert.assertEquals(logourPage.getHeaderText(), "Login Page");

    }
}
