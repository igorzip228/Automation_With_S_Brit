package org.selenium.upload_download_page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.selenium.webDriver.DriverHolder;

import java.io.File;

public class UploadPage extends BasePage{
    @FindBy(id = "file-upload")
    private WebElement uploadFileInput;

    @FindBy(id = "file-submit")
    private WebElement submitButton;

    @FindBy(id = "uploaded-files")
    private WebElement successUploadBanner;

    public UploadPage uploadFile(File fileToUpload){
        uploadFileInput.sendKeys(fileToUpload.getAbsolutePath());
        return this;
    }

    public UploadPage submitUpload(){
        submitButton.click();
        return new UploadPage();
    }


    public String getTextFromBanner(){
        return successUploadBanner.getText();

    }



}
