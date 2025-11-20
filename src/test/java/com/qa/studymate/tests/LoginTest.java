package com.qa.studymate.tests;

import com.qa.studymate.pages.LoginPage;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;
import utils.ConfigReader;

import java.time.Duration;

public class LoginTest extends StudymateTestBase{
    @Test(priority = 2)
    public void happyPathLoginFunctionality() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginFunctionality(ConfigReader.readProperty("email"),
                ConfigReader.readProperty("password"));
        loginPage.clickLoginButton();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlContains("/admin"));

        Assert.assertEquals(driver.getCurrentUrl(), ConfigReader.readProperty("mainPageUrl"));
    }


    @Test(priority = 1)
    public void negativeLoginFunctionality(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.negativeLoginFunctionality(ConfigReader.readProperty("email"), "asdasda");

        String actualError = loginPage.getErrorMessageText(driver);
        String expectedError = "Invalid email or password";

        Assert.assertEquals(actualError, expectedError);
    }

}
