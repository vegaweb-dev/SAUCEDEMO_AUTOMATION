package com.carlos.automation.tests;

import com.carlos.automation.pages.InventoryPage;
import com.carlos.automation.pages.LoginPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;


public class InventoryTest extends BaseTest {
    LoginPage loginPage;
    InventoryPage inventoryPage;

    @BeforeMethod
    public void setUpPages() {
        loginPage = new LoginPage(driver);
        inventoryPage = new InventoryPage(driver);
    }

    @Test
    public void testProductAndAddToCartVisibility() {
        //Go to login page
        driver.get("http://www.saucedemo.com");
        //Login with valid credentials
        loginPage.loginAs("standard_user", "secret_sauce");
        //Verify we are on inventory page
        assertTrue(inventoryPage.isOnInventoryPage(), "User should be on inventory page");
        //Verify product is displayed
        String productName = "Sauce Labs Backpack";
        assertTrue(inventoryPage.isProductDisplayed(productName), "Product should be displayed");
        //Verify Add to Cart button is visible for the product
        assertTrue(inventoryPage.isAddToCartButtonVisible(productName), "'Add to Cart' button should be visible");

    }
}
