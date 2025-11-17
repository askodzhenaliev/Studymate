package com.qa.studymate.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LanguageSwitcherComponent {
    public LanguageSwitcherComponent(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@role='button']")
    WebElement languageSwitcherButton;

    @FindBy(xpath = "//li[@data-value='ru']")
    WebElement russianLanguage;

    @FindBy(xpath = "//fieldset/legend/span")
    WebElement email;



    public void validateLoginPageLanguageSwitcherFunctionality(String expectedEmailText) throws InterruptedException {
        languageSwitcherButton.click();
        russianLanguage.click();
        String emailLabelText = email.getAttribute("textContent");

        Assert.assertEquals(emailLabelText, expectedEmailText);


    }
}
