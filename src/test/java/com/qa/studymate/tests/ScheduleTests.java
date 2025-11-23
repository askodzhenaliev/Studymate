package com.qa.studymate.tests;

import com.qa.studymate.pages.SchedulePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ScheduleTests extends StudymateTestBase {

    @Test
    public void schedulePageIsDisplayedWithMainElements() {
        SchedulePage schedulePage = new SchedulePage(driver).open();

        Assert.assertTrue(
                schedulePage.isCreateEventButtonVisible(),
                "'Create event' button should be visible on Schedule page"
        );

        Assert.assertTrue(
                schedulePage.isFiltersSectionVisible(),
                "Filters (group, status, view type) should be visible"
        );
    }

    @Test
    public void calendarGridIsVisibleOnSchedulePage() {
        SchedulePage schedulePage = new SchedulePage(driver).open();

        Assert.assertTrue(
                schedulePage.isCalendarGridVisible(),
                "Calendar grid (days of the month) should be visible"
        );

        String period = schedulePage.getCurrentPeriodText();
        Assert.assertFalse(
                period.isEmpty(),
                "Current period label (e.g., 'November 2025') should not be empty"
        );
    }
}
