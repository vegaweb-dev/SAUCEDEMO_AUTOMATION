package com.carlos.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class InventoryPage extends BasePage {
    // Locators for inventory container, items, item names and Add to Cart buttons

    private final By inventoryList = By.cssSelector(".inventory_list");
    private final By inventoryItem = By.cssSelector(".inventory_item");
    private final By inventoryItemName = By.cssSelector(".inventory_item_name");
    private final By addToCartButton = By.cssSelector(".btn_inventory");

    public InventoryPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Checks if the product list container is present on the inventory page.
     */
    public boolean isProductListPresent() {
        return !driver.findElements(inventoryList).isEmpty();
    }

    public boolean isOnInventoryPage() {
        return driver.getCurrentUrl().contains("/inventory.html");
    }

    /**
     * Finds a product WebElement by its visible name on the inventory page.
     */
    private WebElement findProductElement(String productName) {
        if (!isProductListPresent()) {
            return null;
        }
        List<WebElement> products = driver.findElements(inventoryItem);
        for (WebElement product : products) {
            List<WebElement> nameElements = product.findElements(inventoryItemName);
            if (!nameElements.isEmpty() && nameElements.get(0).getText().trim().equalsIgnoreCase(productName.trim())) {
                return product;
            }
        }
        return null;
    }


    public boolean isProductDisplayed(String productName) {
        return findProductElement(productName) != null;
    }

    /**
     * Verifies if the Add to Cart button is visible for the specified product.
     */
    public boolean isAddToCartButtonVisible(String productName) {
        WebElement productElement = findProductElement(productName);
        if (productElement == null) {
            return false;
        }

        List<WebElement> buttons = productElement.findElements(addToCartButton);
        return !buttons.isEmpty() && buttons.get(0).isDisplayed();
    }

}
