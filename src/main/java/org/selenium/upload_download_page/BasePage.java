package org.selenium.upload_download_page;

import org.openqa.selenium.support.PageFactory;
import org.selenium.webDriver.DriverHolder;

public class BasePage {
    public BasePage() {
        PageFactory.initElements(DriverHolder.getInstance().getDriver(), this);
    }
}
