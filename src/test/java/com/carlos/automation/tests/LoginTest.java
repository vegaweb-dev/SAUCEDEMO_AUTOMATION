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

    @Test
    public void testInvalidLogin() {
        driver.get("https://www.saucedemo.com");
        loginPage.loginAs("invalid_user", "wrong_password");

        // Validate that the user is not redirected
        String actualUrl = driver.getCurrentUrl();
        assert actualUrl.equals("https://www.saucedemo.com/") : "Should stay on login page";

        // Validate that the error message is displayed
        String errorMessage = loginPage.getErrorMessage();
        assert errorMessage.contains("Username and password do not match") : "Expected error not shown";

    }
}
