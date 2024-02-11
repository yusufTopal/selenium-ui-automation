package org.example;

import org.example.pom.BaseTest;
import org.testng.annotations.Test;

public class MyFirstTestCase extends BaseTest {

    @Test
    public void firstMethod() {

        driver.get("https://www.google.com");

        System.out.println(driver.getTitle());
    }
}
