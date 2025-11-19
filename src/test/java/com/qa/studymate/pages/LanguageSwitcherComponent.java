package com.qa.studymate.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class LanguageSwitcherComponent {
    public LanguageSwitcherComponent(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@role='button']")
    WebElement languageSwitcherButton;

    @FindBy(xpath = "//li[@data-value='ru']")
    WebElement russianLanguage;

    @FindBy(xpath = "//fieldset/legend/span")
    List<WebElement> texts;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement loginButton;






    public void validateLoginPageLanguageSwitcherFunctionality(String expectedEmailText, String expectedPasswordText, String expectedLanguageText, String expectedLoginText) throws InterruptedException {
        languageSwitcherButton.click();
        russianLanguage.click();
        String emailLabelText = texts.get(0).getAttribute("textContent");
        String passwordLabelText = texts.get(1).getAttribute("textContent");
        String languageLabelText = texts.get(2).getAttribute("textContent");


        Assert.assertEquals(emailLabelText, expectedEmailText);
        Assert.assertEquals(passwordLabelText, expectedPasswordText);
        Assert.assertEquals(languageLabelText, expectedLanguageText);

        Assert.assertEquals(loginButton.getText(), expectedLoginText);




    }
}
