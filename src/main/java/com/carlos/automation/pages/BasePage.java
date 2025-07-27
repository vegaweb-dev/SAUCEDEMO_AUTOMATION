package com.carlos.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;


import java.time.Duration;

public abstract class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    //Methods

    /**
     * find   returns a WebElement using the provided locator
     */

    protected WebElement find(By locator) {
        return driver.findElement(locator);
    }

    /**
     * type   clears and types the given text into the located input field
     */
    protected void type(By locator, String text) {
        find(locator).clear();
        find(locator).sendKeys(text);
    }

    /**
     * click  clicks the element identified by the locator
     */
    protected void click(By locator) {
        find(locator).click();
    }
}




