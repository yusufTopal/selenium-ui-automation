package org.example.pom.factory;

import org.example.pom.base.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class DriverManager {


    public WebDriver initializeDriver(String browser) {
        WebDriver driver;

        switch (browser) {
            case "CHROME" -> {
                // For CI/CD headless mode can be started configured as follows.

                /*
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--headless");
                driver = new ChromeDriver(chromeOptions);
                */

                driver = new ChromeDriver();
            }
            case "SAFARI" -> driver = new SafariDriver();
            case "EDGE" -> driver = new EdgeDriver();
            case "FIREFOX" -> driver = new FirefoxDriver();
            default -> throw new RuntimeException("Browser is not supported");
        }

        driver.manage().window().maximize();

        return driver;
    }
}
