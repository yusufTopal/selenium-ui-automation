package org.example.pom.pages;

import org.example.pom.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class StorePage extends BasePage {

    private final By searchField = By.id("woocommerce-product-search-field-0");
    private final By searchButton = By.cssSelector("button[value='Search']");
    private final By title = By.cssSelector(".woocommerce-products-header__title.page-title");
    private final By viewCartLink = By.cssSelector("a[title='View cart']");

    public StorePage(WebDriver driver) {
        super(driver);
    }

    public StorePage enterTextInSearchField(String text) {
        driver.findElement(searchField).sendKeys(text);
        return this;
    }

    public StorePage clickSearchButton() {
        driver.findElement(searchButton).click();
        return this;
    }

    public String getTitle() {
       return driver.findElement(title).getText();
    }

    public StorePage clickAddToCartButtonForProduct(String productName) {
        driver.findElement(getAddToCartButtonForProduct(productName)).click();
        return this;
    }

    public CartPage clickViewCartLink() {
        driver.findElement(viewCartLink).click();
        return new CartPage(driver);
    }

    private By getAddToCartButtonForProduct(String productName) {
        return By.cssSelector("a[aria-label='Add “"+productName+"” to your cart']");
    }

}
