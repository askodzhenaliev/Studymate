package com.qa.studymate.tests;

import com.qa.studymate.pages.LanguageSwitcherComponent;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class LanguageSwitcherMainPageTests extends StudymateTestBase {

    List<String> expectedEnglish = Arrays.asList(
            "Groups",
            "Courses",
            "Teachers",
            "Students",
            "Announcements",
            "Trash",
            "Schedule"
    );

    List<String> expectedRussian = Arrays.asList(
            "Группы",
            "Курсы",
            "Учителя",
            "Студенты",
            "Объявления",
            "Корзина",
            "Расписание"
    );

    @Test
    public void validateMainPageLanguageSwitcherFunctionality() throws InterruptedException {
        LanguageSwitcherComponent languageSwitcherComponent = new LanguageSwitcherComponent(driver);
        Thread.sleep(10000);
        List<String> englishTexts = languageSwitcherComponent.getSidebarMenuTexts(driver);
        Assert.assertEquals(englishTexts, expectedEnglish);

        languageSwitcherComponent.clickRussianLanguage(driver);
        List<String> russianTexts = languageSwitcherComponent.getSidebarMenuTexts(driver);
        Assert.assertEquals(russianTexts, expectedRussian);

    }
}
