package com.qa.studymate.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateGroup {
    public CreateGroup(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//form[@id='group-form']//input[@type='file']")
    WebElement photo;
    @FindBy(xpath = "//input[@name='name']")
    WebElement groupName;
    @FindBy(xpath = "//input[@name='dateOfFinish']")
    WebElement date;
    @FindBy(xpath = "//textarea[@name='description']")
    WebElement description;
    @FindBy(xpath = "//button[normalize-space()='Create']")
    WebElement createButton;

    @FindBy(xpath = "//button[contains(text(), 'Create')]")
    WebElement createGroupButton;

    public void createGroupFunctionality(String groupName, String date, String description ) throws InterruptedException {

        createGroupButton.click();

        String photoPath = System.getProperty("user.dir") + "/src/test/resources/images/Test.png";
        photo.sendKeys(photoPath);

        this.groupName.sendKeys(groupName);
        this.date.sendKeys(date);
        this.description.sendKeys(description);
        createButton.click();

    }

}



