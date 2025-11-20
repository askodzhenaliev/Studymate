package com.qa.studymate.tests;

import com.qa.studymate.pages.GroupListDisplay;
import org.testng.annotations.Test;
import utils.BrowserUtils;

public class GroupListDisplayTest extends StudymateTestBase {
    @Test
    public void validateGroupListDisplayFunctionality() throws InterruptedException {
        GroupListDisplay groupListDisplay = new GroupListDisplay(driver);
        BrowserUtils.waitForPageLoad(driver);
        groupListDisplay.isTitleVisible();
        groupListDisplay.isGroupsMenuVisible();
        groupListDisplay.getGroupCardCount();
        groupListDisplay.getGroupNamesList();
        groupListDisplay.getGroupDatesList();
        groupListDisplay.getGroupDescriptionsList();
        groupListDisplay.allCardsHaveNames();
        groupListDisplay.allCardsHaveDates();
        groupListDisplay.allCardsHaveThreeDots();
        groupListDisplay.openFirstGroup();
        groupListDisplay.openGroupByName("aliyah");

    }

}
