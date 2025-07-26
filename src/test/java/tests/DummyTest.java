package tests;

import com.carlos.automation.utils.DriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DummyTest {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        DriverManager.initDriver();
        driver=DriverManager.getDriver();
        System.out.println("setup successfull");
    }

    @Test
    public void testOpenSauceDemo(){
        driver.get("https://www.saucedemo.com");
        System.out.println("test successful");
        System.out.println(driver.getTitle());
    }

    @AfterMethod
    public void tearDown(){
        DriverManager.quitDriver();
        System.out.println("tear down successful");
    }
}
