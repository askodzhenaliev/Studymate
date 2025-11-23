package com.qa.studymate.tests;

import com.qa.studymate.pages.CreateGroup;
import org.testng.annotations.Test;

public class CreateGroupTest extends StudymateTestBase {

    @Test
    public void validateCreateGroupFunctionality () throws InterruptedException {

        CreateGroup createGroup = new CreateGroup(driver);
        createGroup.createGroupFunctionality("TeamOne","15.12.2025", "We love QA");
    }
}
