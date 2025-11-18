package com.qa.studymate.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class GroupListDisplay {
    public GroupListDisplay(WebDriver driver){
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//h2[.='Groups']")
    WebElement groupsTitle;

    @FindBy(xpath = "//li[contains(., 'Groups')]")
    WebElement groupsMenuItem;

    @FindBy(xpath = "//div[contains(@class, 'MuiCard-root')]")
    List<WebElement> groupCards;

    @FindBy(xpath = "//div[contains(@class, 'MuiTypography-h5')]")
    List<WebElement> groupNames;

    @FindBy(xpath = "//div[contains(@class, 'MuiCard-root')]//span[contains(text(), '-')]")
    List<WebElement> groupDates;

    @FindBy(xpath = "//p[contains(@class, 'MuiTypography-root')]")
    List<WebElement> groupDescription;

    @FindBy(xpath = "//div[contains(@class, 'MuiCard-root')]//button")
    List<WebElement> threeDotsButtons;

    public void isTitleVisible() throws InterruptedException {
        Thread.sleep(50000);
        Assert.assertTrue(groupsTitle.isDisplayed());
    }


    public void isGroupsMenuVisible() {
        Assert.assertTrue(groupsMenuItem.isDisplayed());
    }

    public int getGroupCardCount() {
        return groupCards.size();
    }

    public List<String> getGroupNamesList() {
        List<String> names = new ArrayList<>();
        for (WebElement name : groupNames) {
            names.add(name.getText().trim());
        }
        return names;
    }

    public List<String> getGroupDatesList() {
        List<String> dates = new ArrayList<>();
        for (WebElement date : groupDates) {
            dates.add(date.getText().trim());
        }
        return dates;
    }

    public List<String> getGroupDescriptionsList() {
        List<String> descriptions = new ArrayList<>();
        for (WebElement desc : groupDescription) {
            descriptions.add(desc.getText().trim());
        }
        return descriptions;
    }

    public boolean allCardsHaveNames() {
        for (WebElement name : groupNames) {
            if (name.getText().trim().isEmpty()) {
                return false;
            }
        }
        return true;
    }

    public boolean allCardsHaveDates() {
        for (WebElement date : groupDates) {
            if (date.getText().trim().isEmpty()) {
                return false;
            }
        }
        return true;
    }

    public boolean allCardsHaveThreeDots() {
        return threeDotsButtons.size() == groupCards.size();
    }

    public void openFirstGroup() {
        if (!groupCards.isEmpty()) {
            groupCards.get(0).click();
        }
    }

    public void openGroupByName(String groupName) {
        for (int i = 0; i < groupNames.size(); i++) {
            if (groupNames.get(i).getText().trim().equalsIgnoreCase(groupName)) {
                groupCards.get(i).click();
                break;
            }
        }
    }







}
