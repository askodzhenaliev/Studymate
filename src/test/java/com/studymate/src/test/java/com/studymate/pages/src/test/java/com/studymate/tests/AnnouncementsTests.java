package com.studymate.tests;

import com.studymate.base.BaseTest;
import com.studymate.pages.AnnouncementsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AnnouncementsTests extends BaseTest {

    @Test
    public void announcementsPageIsDisplayedWithMainElements() {
        AnnouncementsPage announcementsPage = new AnnouncementsPage(driver).open();

        Assert.assertEquals(
                announcementsPage.getPageTitle(),
                "Announcements",
                "Page title should be 'Announcements'"
        );

        Assert.assertTrue(
                announcementsPage.isAddAnnouncementButtonVisible(),
                "'Add an announcement' button should be visible"
        );

        Assert.assertTrue(
                announcementsPage.isFilterSectionVisible(),
                "Filter section (Groups / From / Till) should be visible"
        );
    }

    @Test
    public void firstAnnouncementCardShowsMainInformation() {
        AnnouncementsPage announcementsPage = new AnnouncementsPage(driver).open();

        Assert.assertTrue(
                announcementsPage.hasAtLeastOneAnnouncement(),
                "There should be at least one announcement card"
        );

        String status = announcementsPage.getFirstAnnouncementStatus();
        String forWhom = announcementsPage.getFirstAnnouncementForWhom();
        String createdBy = announcementsPage.getFirstAnnouncementCreatedBy();
        String text = announcementsPage.getFirstAnnouncementText();
        String date = announcementsPage.getFirstAnnouncementDate();

        Assert.assertFalse(status.isEmpty(), "Status should not be empty");
        Assert.assertFalse(forWhom.isEmpty(), "'For whom' should not be empty");
        Assert.assertFalse(createdBy.isEmpty(), "'Who created' should not be empty");
        Assert.assertFalse(text.isEmpty(), "Announcement text should not be empty");
        Assert.assertFalse(date.isEmpty(), "Announcement date should not be empty");
    }
}
