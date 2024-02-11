package org.example.pom.pages;

import org.example.pom.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage {

    private final By productName = By.cssSelector("td[class='product-name'] a");
    private final By checkOutButton = By.cssSelector(".checkout-button");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public String getProductName() {
        return driver.findElement(productName).getText();
    }

    public void clickCheckOutButton() {
        driver.findElement(checkOutButton).click();
    }
}
