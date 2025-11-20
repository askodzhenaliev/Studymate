package com.qa.studymate.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

public class LanguageSwitcherComponent {
    public LanguageSwitcherComponent(WebDriver driver) {
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

    @FindBy(xpath = "//*[local-name()='svg' and contains(@class, 'jam-world')]")
    WebElement globeIcon;

    @FindBy(xpath = "//li[normalize-space()='Русский']")
    WebElement russianOptionMainPage;

    @FindBy(xpath = "//li[normalize-space()='English']")
    WebElement englishOptionMainPage;

    @FindBy(tagName = "a")
    List<WebElement> sidebarMenuItems;


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


    public void clickRussianLanguage(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(globeIcon));
        globeIcon.click();
        russianOptionMainPage.click();
    }

    public void clickEnglishLanguage(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(globeIcon));
        globeIcon.click();
        englishOptionMainPage.click();
    }

    public List<String> getSidebarMenuTexts(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.visibilityOfAllElements(sidebarMenuItems));

        return sidebarMenuItems
                .stream()
                .map(el -> el.getText().trim())
                .collect(Collectors.toList());
    }
}

