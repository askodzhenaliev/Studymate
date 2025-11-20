package com.qa.studymate.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

public class LoginPage {
    public LoginPage (WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@name='email']")
    WebElement email;

    @FindBy(xpath = "//input[@name='password']")
    WebElement password;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement loginButton;

    @FindBy(xpath = "//div[contains(@class,'MuiAlert-message')]")
    WebElement loginErrorMessage;

    public void clickLoginButton() {
        loginButton.click();

    }

    public void loginFunctionality( String email, String password) {
        this.email.sendKeys(email);
        this.password.sendKeys(password);
    }

    public String getErrorMessageText(WebDriver driver) {
        BrowserUtils.waitTimes(driver, loginErrorMessage);
        return loginErrorMessage.getText();
    }

    public void negativeLoginFunctionality(String email, String password){
        this.email.sendKeys(email);
        this.password.sendKeys(password);
        loginButton.click();
    }
}