package com.carlos.automation.tests;

import com.carlos.automation.pages.LoginPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
    LoginPage loginPage;

    @BeforeMethod
    public void initPage() {
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
}
