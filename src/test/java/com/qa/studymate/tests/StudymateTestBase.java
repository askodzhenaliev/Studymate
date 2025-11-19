package com.qa.studymate.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.ConfigReader;
import utils.DriverHelper;

public class StudymateTestBase {
    public WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = DriverHelper.getDriver();
//        driver.get("https://codewise.studymate.us/login");
        driver.get(ConfigReader.readProperty("studymate_url"));
    }

    @AfterMethod
    public void tearDown() {
//        driver.quit();
    }
}
