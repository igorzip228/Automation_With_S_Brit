package org.selenium;

import org.selenium.BaseClass;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BasicAuthTest extends BaseClass {

    @Test
    public void basicAuthTest(){
        // добавляем впереди нашего url - admin:admin сразу для аутентификации
        goToUrl("https:admin:admin@the-internet.herokuapp.com/basic_auth"); // добавляем впереди admin:admin сразу для аутентификации
        Assert.assertEquals(getHeaderText(), "Basic Auth");

    }
}
