package org.selenium.pageobjects.login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.selenium.upload_download_page.BasePage;
import org.selenium.webDriver.DriverHolder;
import sun.jvm.hotspot.debugger.Page;

public class AfterLoginPage extends BasePage {
//    private WebDriver driver;

    // описываем элементы аннотацией @FindBy
    @FindBy(css = ".flash.success")
    private WebElement successBanner;

    @FindBy(tagName = "h2")
    private WebElement header;

    @FindBy(css = "a.radius")
    private WebElement logoutButton;


//    public AfterLoginPage(WebDriver driver) {

    // сделали всe в BasePage
//    public AfterLoginPage() { // используем синглтон
////        this.driver = driver;
//        PageFactory.initElements(DriverHolder.getInstance().getDriver(), this);
//    }

    // описываем методы на странице, методы должны возвращать следующую страницу,
    // чтоб можно потом через точку вызывать
    public LoginPage logout(){
        logoutButton.click();
        return new LoginPage();
    }


    public boolean isSuccessfullBanerVisible(){
        return successBanner.isDisplayed();
    }

    public String getHeaderText(){
        return header.getText();
    }

    public AfterLoginPage waitTillPageLoaded(){
        new WebDriverWait(DriverHolder.getInstance().getDriver(), 20)
                .until(ExpectedConditions
                .visibilityOfAllElements(
                        logoutButton,
                        successBanner,
                        header)
                );
        return new AfterLoginPage();
    }
}
