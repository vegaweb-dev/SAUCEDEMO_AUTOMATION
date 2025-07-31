package com.carlos.automation.tests;

import com.carlos.automation.utils.DriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    protected WebDriver driver;

    @BeforeMethod
    public void setUp() {
        DriverManager.initDriver();
        driver = DriverManager.getDriver();
    }

    @AfterMethod
    public void tearDown() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        DriverManager.quitDriver();
    }
}
