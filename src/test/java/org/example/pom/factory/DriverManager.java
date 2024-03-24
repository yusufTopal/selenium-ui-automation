package org.example.pom.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class DriverManager {

    public WebDriver initializeDriver() {
        String browser = System.getProperty("browser", "CHROME");

        WebDriver driver;

        switch (browser) {
            case "CHROME" -> {
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--headless");
                driver = new ChromeDriver(chromeOptions);
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
