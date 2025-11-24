package com.qa.studymate.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;
import java.util.logging.XMLFormatter;

public class SidebarNavigation {

    public SidebarNavigation(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy (xpath = "//input[@name='email']")
    WebElement email;

    @FindBy(xpath = "//input[@name='password']")
    WebElement password;

    @FindBy(xpath = "//button[@type=\"submit\"]")
    WebElement loginButton;

    @FindBy(xpath = "//li[@class=\"MuiListItem-root MuiListItem-gutters MuiListItem-padding sc-idXgbr VObHa css-1yo8bqd\"]")
    List<WebElement>allCategories;

    @FindBy(xpath = "//*[local-name()='svg' and contains(@class, 'jam-world')]")
    WebElement globeIcon;

    @FindBy(xpath = "//li[@tabindex='0']")
    WebElement ruLanguage;

    @FindBy(xpath = "//li[@class='MuiListItem-root MuiListItem-gutters MuiListItem-padding sc-hLBbgP kzZhbr css-1yo8bqd']")
    List<WebElement>categoriesInRussian;

    public void loginFunctionality(String myEmail, String myPassword) throws InterruptedException {
        email.sendKeys("admin@codewise.com");
        password.sendKeys("codewise_123");
        loginButton.click();
        Thread.sleep(3000);
    }

    public void validateAllCategories() throws InterruptedException {
        for (WebElement eachCategory:allCategories){
            Assert.assertTrue(eachCategory.isDisplayed());
            eachCategory.click();
            Thread.sleep(2000);
        }

    }

    public void setLanguage() throws InterruptedException {

        globeIcon.click();
        Thread.sleep(2000);
        ruLanguage.click();

    }

    public void validateCategoriesInRussian() throws InterruptedException {
        for (WebElement items:categoriesInRussian){
            Assert.assertTrue(items.isDisplayed());
            items.click();
            Thread.sleep(3000);
        }
    }

}

