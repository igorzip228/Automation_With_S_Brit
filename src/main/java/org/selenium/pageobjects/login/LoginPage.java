package org.selenium.pageobjects.login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.selenium.upload_download_page.BasePage;
import org.selenium.webDriver.DriverHolder;

public class LoginPage extends BasePage {
//    private WebDriver driver;

    @FindBy(id = "username")
    private WebElement userNameInput;

    @FindBy(id = "password")
    private WebElement userPassInput;

    @FindBy(css = "button.radius")
    private WebElement submitButton;

    @FindBy(css = ".flash.success")
    private WebElement successBanner;

    @FindBy(css = ".flash.error")
    private WebElement errorBanner;

    @FindBy(tagName = "h2")
    private WebElement header;

// делаем конструктор гдебудем брать драйвер и инициализировать элементы.
// PageFactory нужна для ленивой инициализации - тогда когда нужно
//    public LoginPage(WebDriver driver) {
//    public LoginPage() { //меняем на метод из синглтона
////        this.driver = driver;
////        PageFactory.initElements(driver, this);
//        PageFactory.initElements(DriverHolder.getInstance().getDriver(), this); //меняем на метод из синглтона
//    }

    public LoginPage inputName(String name){
        userNameInput.sendKeys(name);
        return this;
    }

    public LoginPage inputPass(String pass){
        userPassInput.sendKeys(pass);
        return this;
    }

    public AfterLoginPage seccessLogin(String userName, String userPass){
        inputName(userName)
                .inputPass(userPass)
                .submitButton.click();
//        return new AfterLoginPage(driver);
        return new AfterLoginPage();
    }

    public LoginPage unSeccessLogin(String userName, String userPass){
        inputName(userName)
                .inputPass(userPass)
                .submitButton.click();
//        return new LoginPage(driver); // возвращаем не this, а new LoginPage, потому что привязки ломаются
        return new LoginPage(); //меняем на метод из синглтона
    }

    public boolean isSuccessfullBanerVisible(){
        return successBanner.isDisplayed();
    }

    public boolean isErrorBanerVisible(){
        return errorBanner.isDisplayed();
    }

    public String getHeaderText(){
        return header.getText();
    }

    public AfterLoginPage waitTillPageLoaded(){
//        new WebDriverWait(driver, 20)
        new WebDriverWait(DriverHolder.getInstance().getDriver(), 20)
                .until(ExpectedConditions
                        .visibilityOfAllElements(
                                submitButton,
                                successBanner,
                                header)
                );
//        return new AfterLoginPage(driver);
        return new AfterLoginPage();
    }


}
