package com.studymate.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class AnnouncementsPage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    private static final String PAGE_URL =
            "https://codewise.studymate.us/admin/announcements?size=4&page=1";

    // Header & main elements
    private final By pageTitle = By.xpath("//h1[contains(text(),'Announcements')]");
    private final By addAnnouncementButton =
            By.xpath("//button[contains(.,'Add an announcement')]");
    private final By groupsDropdown = By.xpath("//div[contains(@class,'select') and .//span[text()='Groups']]");
    private final By fromDateInput = By.xpath("//input[@placeholder='From' or @name='from']");
    private final By tillDateInput = By.xpath("//input[@placeholder='Till' or @name='till']");

    // Announcement card (first card on the page)
    private final By announcementCards = By.xpath("//div[contains(@class,'announcement-card') or .//div[contains(text(),'For whom')]]");
    private final By statusText = By.xpath(".//span[contains(text(),'Hidden') or contains(text(),'Published')]");
    private final By forWhomValue = By.xpath(".//*[contains(text(),'For all') or contains(text(),'For whom')]/following::a[1]");
    private final By createdByValue = By.xpath(".//*[contains(text(),'Who created')]/following::a[1]");
    private final By textValue = By.xpath(".//*[contains(text(),'Text:')]/following-sibling::*[1]");
    private final By dateValue = By.xpath(".//time | .//div[matches(., '\\d{1,2}\\.\\d{1,2}\\.\\d{2}')]");

    public AnnouncementsPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public AnnouncementsPage open() {
        driver.get(PAGE_URL);
        wait.until(ExpectedConditions.urlContains("/admin/announcements"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(pageTitle));
        return this;
    }

    public String getPageTitle() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(pageTitle)).getText();
    }

    public boolean isAddAnnouncementButtonVisible() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(addAnnouncementButton)).isDisplayed();
    }

    public boolean isFilterSectionVisible() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(groupsDropdown));
        wait.until(ExpectedConditions.visibilityOfElementLocated(fromDateInput));
        wait.until(ExpectedConditions.visibilityOfElementLocated(tillDateInput));
        return true;
    }

    private WebElement getFirstAnnouncementCard() {
        List<WebElement> cards = wait.until(
                ExpectedConditions.visibilityOfAllElementsLocatedBy(announcementCards)
        );
        return cards.get(0);
    }

    public String getFirstAnnouncementStatus() {
        WebElement card = getFirstAnnouncementCard();
        return card.findElement(statusText).getText();
    }

    public String getFirstAnnouncementForWhom() {
        WebElement card = getFirstAnnouncementCard();
        return card.findElement(forWhomValue).getText();
    }

    public String getFirstAnnouncementCreatedBy() {
        WebElement card = getFirstAnnouncementCard();
        return card.findElement(createdByValue).getText();
    }

    public String getFirstAnnouncementText() {
        WebElement card = getFirstAnnouncementCard();
        return card.findElement(textValue).getText();
    }

    public String getFirstAnnouncementDate() {
        WebElement card = getFirstAnnouncementCard();
        return card.findElement(dateValue).getText();
    }

    public boolean hasAtLeastOneAnnouncement() {
        List<WebElement> cards = wait.until(
                ExpectedConditions.visibilityOfAllElementsLocatedBy(announcementCards)
        );
        return !cards.isEmpty();
    }
}
