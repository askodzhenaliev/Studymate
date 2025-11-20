package com.qa.studymate.tests;

import com.qa.studymate.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.ConfigReader;

public class LoginTest extends StudymateTestBase{
    @Test
    public void happyPathLoginFunctionality() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginFunctionality(ConfigReader.readProperty("email"),
                ConfigReader.readProperty("password"));
        loginPage.clickLoginButton();
        Thread.sleep(2000);
        Assert.assertEquals(driver.getCurrentUrl(), ConfigReader.readProperty("mainPageUrl"));
    }



}
