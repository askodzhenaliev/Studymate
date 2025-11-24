package com.qa.studymate.tests;

import com.qa.studymate.pages.SidebarNavigation;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class SidebarNavigationTest extends TestBase {
    @Parameters({"myEmail","myPassword"})

    @Test
    public void validateSidebarNavigation() throws InterruptedException {
        SidebarNavigation sidebarNavigation=new SidebarNavigation(driver);
        sidebarNavigation.loginFunctionality("admin@codewise.com","codewise_123");
        sidebarNavigation.validateAllCategories();
        sidebarNavigation.setLanguage();
        sidebarNavigation.validateCategoriesInRussian();
    }


}
