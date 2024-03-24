package org.example.pom.base;

import org.example.pom.factory.DriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class BaseTest {

    protected ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    @Parameters("browser")
    @BeforeMethod
    public void startDriver(String browser) {
        browser = System.getProperty("browser", browser);
        driver.set(new DriverManager().initializeDriver(browser));
    }

    @AfterMethod
    public void quitDriver() {
        driver.get().quit();
    }

}