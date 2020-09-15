package org.selenium;

import org.selenium.upload_download_page.UploadPage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;

public class UploadFileTests extends BaseClass{
    private File fileForUpload = new File("fileForUplosd.txt");

    @BeforeClass
    public void beforeAlertsTestsClass() {
        goToUrl(Constants.UPLOAD_FILE);
    }

    @Test
    public void uoploadFileTest(){
        String testFromBanner = new UploadPage()
                .uploadFile(fileForUpload)
                .submitUpload()
                .getTextFromBanner();

        Assert.assertTrue(testFromBanner.contains(fileForUpload.getName()));
    }

}
