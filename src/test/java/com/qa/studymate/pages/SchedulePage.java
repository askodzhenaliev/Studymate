package com.qa.studymate.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class SchedulePage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    private static final String PAGE_URL = "https://codewise.studymate.us/admin/schedule";

    public SchedulePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    // ------------------------- ELEMENTS -------------------------

    @FindBy(xpath = "//button[contains(.,'Create event')]")
    WebElement createEventButton;

    @FindBy(xpath = "//div[@id='mui-component-select-groupId']")
    WebElement groupFilter;

    @FindBy(xpath = "//div[@id='mui-component-select-eventStatus']")
    WebElement statusFilter;

    @FindBy(xpath = "//div[contains(text(), 'Month')]")
    WebElement viewSwitcher;

    @FindBy(xpath = "//p[contains(text(), '20')]")
    WebElement currentPeriodLabel;

    // FIXED: Use contains for reliability
    @FindBy(xpath = "//div[contains(@class,'fc-daygrid-day-frame')]")
    List<WebElement> calendarCells;

    // ------------------------- METHODS -------------------------

    public SchedulePage open() {
        driver.get(PAGE_URL);
        wait.until(ExpectedConditions.urlContains("/admin/schedule"));
        wait.until(ExpectedConditions.visibilityOf(createEventButton));
        return this;
    }

    public boolean isCreateEventButtonVisible() {
        wait.until(ExpectedConditions.visibilityOf(createEventButton));
        return createEventButton.isDisplayed();
    }

    public boolean isFiltersSectionVisible() {
        wait.until(ExpectedConditions.visibilityOf(groupFilter));
        wait.until(ExpectedConditions.visibilityOf(statusFilter));
        wait.until(ExpectedConditions.visibilityOf(viewSwitcher));
        return true;
    }

    public String getCurrentPeriodText() {
        wait.until(ExpectedConditions.visibilityOf(currentPeriodLabel));
        return currentPeriodLabel.getText().trim();
    }

    // FIXED LOGIC + FIXED LOCATOR + SAME STYLE AS YOUR COMPONENT
    public boolean isCalendarGridVisible() {
        wait.until(ExpectedConditions.visibilityOfAllElements(calendarCells));
        return !calendarCells.isEmpty();
    }
}
