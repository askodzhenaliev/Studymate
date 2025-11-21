package com.studymate.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class SchedulePage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    private static final String PAGE_URL = "https://codewise.studymate.us/admin/schedule";

    private final By pageTitle = By.xpath("//h1[contains(text(),'Schedule') or contains(text(),'Calendar')]");
    private final By currentPeriodLabel =
            By.xpath("//div[contains(@class,'toolbar')]//span[contains(@class,'label') or contains(.,'20')]");
    private final By groupFilter = By.xpath("//div[contains(@class,'select')][.//div[text()='all']]");
    private final By statusFilter = By.xpath("//div[contains(@class,'select')][.//div[text()='All']]");
    private final By viewSwitcher = By.xpath("//div[contains(@class,'select')][.//div[text()='Month']]");
    private final By createEventButton = By.xpath("//button[contains(.,'Create event')]");
    private final By calendarCells = By.xpath("//div[contains(@class,'rbc-day-bg') or contains(@class,'rbc-date-cell')]");

    public SchedulePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public SchedulePage open() {
        driver.get(PAGE_URL);
        wait.until(ExpectedConditions.urlContains("/admin/schedule"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(createEventButton));
        return this;
    }

    public boolean isCreateEventButtonVisible() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(createEventButton)).isDisplayed();
    }

    public String getCurrentPeriodText() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(currentPeriodLabel)).getText();
    }

    public boolean isFiltersSectionVisible() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(groupFilter));
        wait.until(ExpectedConditions.visibilityOfElementLocated(statusFilter));
        wait.until(ExpectedConditions.visibilityOfElementLocated(viewSwitcher));
        return true;
    }

    public boolean isCalendarGridVisible() {
        List<WebElement> cells = wait.until(
                ExpectedConditions.visibilityOfAllElementsLocatedBy(calendarCells)
        );
        return !cells.isEmpty();
    }
}
