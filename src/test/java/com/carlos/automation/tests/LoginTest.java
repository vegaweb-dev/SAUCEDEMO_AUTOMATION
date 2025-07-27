package com.carlos.automation.tests;

import com.carlos.automation.pages.LoginPage;
import com.carlos.automation.utils.DriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest {
    WebDriver driver;
    LoginPage loginPage;

    @BeforeMethod
    public void setUp() {
        DriverManager.initDriver();
        driver = DriverManager.getDriver();
        loginPage = new LoginPage(driver);
    }

    @Test
    public void testValidLogin() {
        driver.get("https://www.saucedemo.com");
        loginPage.loginAs("standard_user", "secret_sauce");

        System.out.println("page after login " + driver.getCurrentUrl());
        String expectedUrl = "https://www.saucedemo.com/inventory.html";
        String actualUrl = driver.getCurrentUrl();
        assert actualUrl.equals(expectedUrl) : "URL mismatch: Expected " + expectedUrl + ", but got " + actualUrl;
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
