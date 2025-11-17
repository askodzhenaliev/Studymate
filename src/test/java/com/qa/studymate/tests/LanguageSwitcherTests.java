package com.qa.studymate.tests;

import com.qa.studymate.pages.LanguageSwitcherComponent;
import org.testng.annotations.Test;

public class LanguageSwitcherTests extends StudymateTestBase {

    @Test
    public void validateLoginPageLanguageSwitcherFunctionality() throws InterruptedException {
        LanguageSwitcherComponent languageSwitcherComponent = new LanguageSwitcherComponent(driver);
        languageSwitcherComponent.validateLoginPageLanguageSwitcherFunctionality("Логин");
    }
}
